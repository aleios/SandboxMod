package com.aleios.sandboxmod.proxy;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.IBlockAccess;

public abstract class CommonProxy
{
	public abstract void preInit();
	public abstract void init();
	public abstract void postInit();
	
}
