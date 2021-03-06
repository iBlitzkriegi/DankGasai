package me.blitzerino.home.administration;

import me.blitzerino.home.Main;
import me.blitzerino.home.Settings;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.listener.message.MessageCreateListener;

import static me.blitzerino.home.administration.Mute.muted;

/**
 * Created by Blitz on 6/1/2016.
 */
public class Restart implements MessageCreateListener{
    @Override
    public void onMessageCreate(DiscordAPI discordAPI, Message message) {
        if(message.getContent().startsWith(Settings.getCommandStart() + "restart")){
            String[] args = message.getContent().split(" ");
            args[0] = args[0].replaceFirst(Settings.getCommandStart(), "");
            if(args[0].equalsIgnoreCase("restart")) {
                if (!muted.contains(message.getAuthor().getId())) {
                    message.delete();
                    if (Main.admins.contains(message.getAuthor().getId())) {
                        message.reply(Settings.getMsgStart() + "Rebooting in progress " + message.getAuthor().getMentionTag() + "!");
                        Main.delay();
                        Main.setShutdownNatural(false);
                        Main.delay();
                        System.exit(0);
                    } else {
                        message.reply(Settings.getAdminMsg());
                    }

                }
            }
        }
    }
}
