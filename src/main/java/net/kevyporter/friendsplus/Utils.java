package net.kevyporter.friendsplus;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by Kevy on 18/06/2015.
 */
public class Utils {

    public static void init() {
        MinecraftForge.EVENT_BUS.register(new ChatParser());
        MinecraftForge.EVENT_BUS.register(new ClickToAdd());

        ClientCommandHandler.instance.registerCommand(new RemoveCommand());
    }

    public static Boolean isHypixel() {
        if( Minecraft.getMinecraft().func_147104_D().serverIP.endsWith("hypixel.net")) {
            return true;
        } else {
            return false;
        }
    }

}
