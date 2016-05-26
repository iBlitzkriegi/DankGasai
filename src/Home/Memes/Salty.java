package Home.Memes;

import Home.Settings;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.Channel;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.listener.message.MessageCreateListener;

/**
 * Created by Blitz on 5/25/2016.
 */
public class Salty implements MessageCreateListener{
    @Override
    public void onMessageCreate(DiscordAPI discordAPI, Message message) {
        if(message.getContent().startsWith(Settings.getCommandStart() + "salty")){
            message.delete();
            Channel c = message.getChannelReceiver();
            c.sendFile(Memecatch.imageCache.get("salty"));
        }
    }
}