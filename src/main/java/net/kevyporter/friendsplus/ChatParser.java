package net.kevyporter.friendsplus;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.event.ClickEvent;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.ClientChatReceivedEvent;

/**
 * Created by Kevy on 18/06/2015.
 */
public class ChatParser {

    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent e) {
        if(Utils.isHypixel()) {
            String fMessage = e.message.getFormattedText();
            String message = e.message.getUnformattedText();
            if (message.contains(" is in a") && (message.endsWith("game") || message.endsWith("Lobby"))) {
                String name = message.split(" ")[0].trim();
                e.setCanceled(true);
                new FormattedMessage(fMessage).appendMessage(new FormattedMessage(" | ", EnumChatFormatting.WHITE).appendMessage(new FormattedMessage("Message", EnumChatFormatting.GREEN).makeClickable(ClickEvent.Action.SUGGEST_COMMAND, "/msg " + name, new FormattedMessage("Click to message this player.", EnumChatFormatting.GRAY)).appendMessage(new FormattedMessage("/", EnumChatFormatting.WHITE).appendMessage(new FormattedMessage("Remove", EnumChatFormatting.RED).makeClickable(ClickEvent.Action.RUN_COMMAND, "/remove " + name, new FormattedMessage("Click to remove this player as a friend.", EnumChatFormatting.GRAY)))))).send(false);
            }
            if (message.endsWith(" is currently offline")) {
                String name = message.split(" ")[0].trim();
                e.setCanceled(true);
                new FormattedMessage(fMessage).appendMessage(new FormattedMessage(" | ", EnumChatFormatting.WHITE).appendMessage(new FormattedMessage("Remove", EnumChatFormatting.RED).makeClickable(ClickEvent.Action.RUN_COMMAND, "/remove " + name, new FormattedMessage("Click to remove this player as a friend.", EnumChatFormatting.GRAY)))).send(false);
            }

            if (message.contains("from your friends list!")) {
                if (message.replace(message.split(" ")[2] + " ", "").equals("You removed from your friends list!")) {
                    e.setCanceled(true);
                    new FormattedMessage("You removed " + message.split(" ")[2] + " from your friends list!", EnumChatFormatting.YELLOW).send();
                }
            }
        }
    }

}
