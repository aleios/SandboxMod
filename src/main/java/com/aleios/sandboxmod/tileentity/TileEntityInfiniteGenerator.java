package com.aleios.sandboxmod.tileentity;


import com.aleios.sandboxmod.utility.Log;

import cofh.api.energy.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import scala.Int;

public class TileEntityInfiniteGenerator extends TileEntitySandboxMod implements IEnergyProvider
{
	
	protected EnergyStorage storage = new EnergyStorage(Int.MaxValue() - 1);

	public TileEntityInfiniteGenerator()
	{
		storage.setMaxReceive(0);
		storage.setMaxExtract(320);
		storage.setMaxTransfer(320);
	}
	
	@Override
	public boolean canConnectEnergy(ForgeDirection from) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {
		// TODO Auto-generated method stub
		
		return storage.extractEnergy(storage.getMaxExtract(), simulate);
	}

	@Override
	public int getEnergyStored(ForgeDirection from) {
		// TODO Auto-generated method stub
		return storage.getEnergyStored() - 1;
	}

	@Override
	public int getMaxEnergyStored(ForgeDirection from) {
		// TODO Auto-generated method stub
		return storage.getMaxEnergyStored() - 1;
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
		storage.modifyEnergyStored(1000);
		if ((storage.getEnergyStored() > 0)) {
			for(ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {

				//ForgeDirection is a useful helper class for handling directions.
				int targetX = xCoord + dir.offsetX;
				int targetY = yCoord + dir.offsetY;
				int targetZ = zCoord + dir.offsetZ;

				TileEntity tile = worldObj.getTileEntity(targetX, targetY, targetZ);
				if (tile instanceof IEnergyHandler) {
					

					int maxExtract = storage.getMaxExtract(); //Gets the maximum amount of energy that can be extracted from this tile in one tick.
					int maxAvailable = storage.extractEnergy(maxExtract, true); //Simulates removing "maxExtract" to find out how much energy is actually available.
					int energyTransferred = ((IEnergyHandler) tile).receiveEnergy(dir.getOpposite(), maxAvailable, false); //Sends "maxAvailable" to the target tile and records how much energy was accepted. 

					storage.extractEnergy(energyTransferred, false);//Extract the energy transferred from the internal storage.
				}
			}
		}
	}

}
