package com.aleios.sandboxmod.tileentity;

import cofh.api.energy.IEnergyReceiver;

import com.aleios.sandboxmod.init.ModBlocks;
import com.aleios.sandboxmod.utility.Log;

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityFishery extends TileEntitySandboxMod implements IEnergyHandler, IInventory
{

	private final int CAPACITY = 1000;
	private final int workCost = 500;
	private final int maxIntake = 45;
	EnergyStorage storage = new EnergyStorage(CAPACITY);

	
	private ItemStack[] inventory = new ItemStack[1];
	
	public TileEntityFishery()
	{
		
		storage.setMaxTransfer(maxIntake);
		storage.setMaxReceive(maxIntake);
		storage.setMaxExtract(0);
		
		Log.info("Set storage params: " + storage.getMaxReceive());
	}
	
	@Override
	public boolean canConnectEnergy(ForgeDirection from) {
		// TODO Auto-generated method stub
		if(from != ForgeDirection.UP)
			return true;
		return false;
	}

	@Override
	public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {
		// TODO Auto-generated method stub
		if(from == ForgeDirection.UP)
			return 0;
		//storage.setMaxReceive(200);
		return storage.receiveEnergy(storage.getMaxReceive(), simulate);
	}

	@Override
	public int getEnergyStored(ForgeDirection from) {
		// TODO Auto-generated method stub
		return storage.getEnergyStored();
	}

	@Override
	public int getMaxEnergyStored(ForgeDirection from) {
		// TODO Auto-generated method stub
		return storage.getMaxEnergyStored();
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		storage.writeToNBT(nbt);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		storage.readFromNBT(nbt);
	}
	
	@Override
	public void updateEntity() {
		
		
		if(storage.getEnergyStored() >= workCost)
		{
			if(inventory[0] != null && inventory[0].stackSize >= inventory[0].getMaxStackSize())
				return;
			
			// Scan for water
			// TODO: Make this check way less frequent.
			int numWater = 0;
			for(ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
				int targetX = xCoord + dir.offsetX;
				int targetY = yCoord + dir.offsetY;
				int targetZ = zCoord + dir.offsetZ;
				
				Block blk = worldObj.getBlock(targetX, targetY, targetZ);
				if(blk == Blocks.water && worldObj.getBlockMetadata(targetX, targetY, targetZ) == 0)
				{
					numWater++;
				}
			}
			
			if(numWater < 3)
				return;
			
			int lastEnergy = storage.getEnergyStored();
			storage.modifyEnergyStored(-workCost);
			
			if(inventory[0] != null)
			{
				inventory[0].stackSize += 1;
			}
			else
			{
				setInventorySlotContents(0, new ItemStack(Item.getItemById(Item.getIdFromItem(Items.fish))));
			}
		}
	}

	@Override
	public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		// TODO Auto-generated method stub
		return inventory[index];
	}

	@Override
	public ItemStack decrStackSize(int slot, int decreaseAmount) {
        if(inventory[slot] != null) {
            ItemStack itemstack;

            if(inventory[slot].stackSize <= decreaseAmount) {
                itemstack = inventory[slot];
                setInventorySlotContents(slot, null);
                markDirty();
                return itemstack;
            } else {
                itemstack = inventory[slot].splitStack(decreaseAmount);

                if(inventory[slot].stackSize == 0) {
                    setInventorySlotContents(slot, null);
                }

                markDirty();
                return itemstack;
            }
        }
        else 
        {
            return null;
        }
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
        if(inventory[slot] != null) {
            ItemStack itemstack = inventory[slot];
            inventory[slot] = null;
            return itemstack;
        } else {
            return null;
        }
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
        inventory[slot] = stack;

        if(stack != null && stack.stackSize > getInventoryStackLimit()) {
            stack.stackSize = getInventoryStackLimit();
        }

        markDirty();
	}

	@Override
	public String getInventoryName() {
		// TODO Auto-generated method stub
		return ModBlocks.blockFishery.getUnlocalizedName() + ".container";
	}

	@Override
	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		// TODO Auto-generated method stub
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		// TODO Auto-generated method stub
		return false;
	}

}
