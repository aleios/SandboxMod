package com.aleios.sandboxmod.network;

import com.aleios.sandboxmod.reference.Reference;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class NetworkHandler 
{
	private static SimpleNetworkWrapper instance;
	
	public static void init()
	{
		instance = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);
	}
}
