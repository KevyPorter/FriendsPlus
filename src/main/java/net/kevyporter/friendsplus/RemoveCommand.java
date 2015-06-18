package net.kevyporter.friendsplus;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.event.ClickEvent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

/**
 * Created by Kevy on 18/06/2015.
 */
public class RemoveCommand extends CommandBase {

    private boolean isOp(ICommandSender sender) {
        return (MinecraftServer.getServer().isSinglePlayer())
                || (!(sender instanceof EntityPlayerMP))
                || MinecraftServer.getServer().getConfigurationManager().func_152596_g(((EntityPlayerMP)sender).getGameProfile());
    }

    public String getCommandName() {
        return "remove";
    }

    public int getRequiredPermissionLevel() {
        return 0;
    }

    public boolean canSenderUseCommand(ICommandSender sender) {
        return true;
    }

    public String getCommandUsage(ICommandSender sender) {
        return "/remove <player>";
    }

    public void processCommand(ICommandSender sender, String[] args) {
        try {
            if (Utils.isHypixel()) {
                if (args.length == 1) {
                    String name = args[0];
                    new FormattedMessage("Are you sure you want to remove ", EnumChatFormatting.RED).appendMessage(new FormattedMessage(name, EnumChatFormatting.GOLD).appendMessage(new FormattedMessage(" as a friend? ", EnumChatFormatting.RED).appendMessage(new FormattedMessage("(Click here to remove)", EnumChatFormatting.GRAY).makeClickable(ClickEvent.Action.RUN_COMMAND, "/f remove " + name, new FormattedMessage("Click here to confirm removing this player as a friend", EnumChatFormatting.GRAY))))).send(false);

                } else {
                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + getCommandUsage(sender)));
                }
            }
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }

}
