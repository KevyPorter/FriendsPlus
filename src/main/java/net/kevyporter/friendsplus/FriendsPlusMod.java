package net.kevyporter.friendsplus;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.input.Keyboard;

/**
 * Created by Kevy on 18/06/2015.
 */
@Mod(modid = FriendsPlusMod.MODID, name = FriendsPlusMod.NAME, version = FriendsPlusMod.VERSION)
public class FriendsPlusMod {

    public static final String MODID = "friendsplusmod";
    public static final String NAME = "Friends Plus";
    public static final String VERSION = "1.0";

    public Minecraft minecraft;
    private static FriendsPlusMod instance;

    public KeyBinding addToTeamKey;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        minecraft = Minecraft.getMinecraft();
        instance = this;
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(this);
        FMLCommonHandler.instance().bus().register(this);
        Utils.init();

        this.addToTeamKey = new KeyBinding("Team inv key", Keyboard.KEY_V, "Friends_Plus");
        ClientRegistry.registerKeyBinding(this.addToTeamKey);
    }

    public static FriendsPlusMod instance() {
        return instance;
    }

}
