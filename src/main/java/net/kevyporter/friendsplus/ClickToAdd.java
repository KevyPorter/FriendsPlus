package net.kevyporter.friendsplus;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.event.ClickEvent;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.player.EntityInteractEvent;

/**
 * Created by Kevy on 18/06/2015.
 */
public class ClickToAdd {

    private String CLICK_HERE = "Click Here";
    private String ADD_FRIEND = "/f add ";
    private String MESSAGE = "/msg ";
    private String ADD_TO_TEAM = "/team invite ";

    @SubscribeEvent
    public void entityInteract(EntityInteractEvent e) {
        if (Utils.isHypixel()) {
        /* Checking if ChromaPixel is installed */
            if (Loader.isModLoaded("tYSKretsvEuPdDx")) {
            /* As ChromaPixel already has this feature, return so that it doesn't Override the current ChromaPixel one */
                return;
            } else {
                if (e.target instanceof EntityPlayer) {
                    EntityPlayer player = (EntityPlayer) e.target;
                    String name = player.getCommandSenderName();
                    if (Minecraft.getMinecraft().thePlayer.getHeldItem() == null && Minecraft.getMinecraft().thePlayer.isSneaking()) {
                        new FormattedMessage(CLICK_HERE, EnumChatFormatting.GOLD).addFormatting(EnumChatFormatting.UNDERLINE).makeClickable(ClickEvent.Action.RUN_COMMAND, ADD_FRIEND + name, new FormattedMessage("Click here to add " + name + " as a friend.", EnumChatFormatting.GRAY)).appendMessage(new FormattedMessage(" to send a friend request to \'", EnumChatFormatting.YELLOW).appendMessage(new FormattedMessage(name, EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("\'", EnumChatFormatting.YELLOW)))).send();
                        new FormattedMessage(CLICK_HERE, EnumChatFormatting.GOLD).addFormatting(EnumChatFormatting.UNDERLINE).makeClickable(ClickEvent.Action.SUGGEST_COMMAND, MESSAGE + name + " ", new FormattedMessage("Click here send a message to " + name, EnumChatFormatting.GRAY)).appendMessage(new FormattedMessage(" to send a message to \'", EnumChatFormatting.YELLOW).appendMessage(new FormattedMessage(name, EnumChatFormatting.GREEN).appendMessage(new FormattedMessage("\'", EnumChatFormatting.YELLOW)))).send();
                    }
                }
            }

            if (e.target instanceof EntityPlayer && Utils.isHypixel()) {
                EntityPlayer player = (EntityPlayer) e.target;
                String name = player.getCommandSenderName();
                if (FriendsPlusMod.instance().minecraft.thePlayer.getHeldItem() == null && FriendsPlusMod.instance().addToTeamKey.getIsKeyPressed()) {
                    new FormattedMessage(CLICK_HERE, EnumChatFormatting.GREEN).addFormatting(EnumChatFormatting.UNDERLINE).makeClickable(ClickEvent.Action.RUN_COMMAND, ADD_TO_TEAM + name, new FormattedMessage("Click here to add " + name + " to your team", EnumChatFormatting.GRAY)).appendMessage(new FormattedMessage(" to add \'", EnumChatFormatting.GREEN).appendMessage(new FormattedMessage(name, EnumChatFormatting.YELLOW).appendMessage(new FormattedMessage("\' to your team.", EnumChatFormatting.GREEN)))).send();
                }
            }
        }
    }

}
