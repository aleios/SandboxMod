package com.aleios.sandboxmod;

import com.aleios.sandboxmod.init.ModBlocks;
import com.aleios.sandboxmod.init.ModItems;
import com.aleios.sandboxmod.init.ModTileEntities;
import com.aleios.sandboxmod.network.NetworkHandler;
import com.aleios.sandboxmod.proxy.CommonProxy;
import com.aleios.sandboxmod.reference.Reference;
import com.aleios.sandboxmod.utility.Log;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.block.Block;

@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.MOD_VERSION)
public class SandboxMod
{
	// Mod Instance
	@Mod.Instance("SandboxMod")
	private static SandboxMod instance; // This can be public instead and remove the getMod() if wanted.
	
	// Proxy
	@SidedProxy(clientSide = Reference.MOD_CLIENTPROXY, serverSide=Reference.MOD_SERVERPROXY)
	public static CommonProxy proxy;

	public static SandboxMod getMod()
	{
		return instance;
	}
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent ev)
	{
		// Config, networkhandlers, blocks, items init.
		ModBlocks.init();
		ModItems.init();
		ModTileEntities.init();
		proxy.preInit();
		
		NetworkHandler.init();
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		
		Log.info("PreInitialization Complete");
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent ev)
	{
		// Gui, tileents, craftrecipes, eventhandlers.
		//
		proxy.init();
		Log.info("Initialization Complete");
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent ev)
	{
		// other crap.
		proxy.postInit();
		Log.info("PostInitialization Complete");
	}
}
