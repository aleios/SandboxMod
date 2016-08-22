package com.aleios.sandboxmod.tileentity;

import cofh.api.energy.IEnergyReceiver;

import com.aleios.sandboxmod.utility.Log;

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyHandler;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityFishery extends TileEntitySandboxMod implements IEnergyHandler
{

	private final int CAPACITY = 1000;
	private final int workCost = 500;
	private final int maxIntake = 1;
	EnergyStorage storage = new EnergyStorage(CAPACITY);
	
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
			int lastEnergy = storage.getEnergyStored();
			storage.modifyEnergyStored(-workCost);
			Log.info("We took energy (" + lastEnergy + ") out and we have " + storage.getEnergyStored() + " energy left");
		}
	}

	@Override
	public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {
		// TODO Auto-generated method stub
		return 0;
	}

}
