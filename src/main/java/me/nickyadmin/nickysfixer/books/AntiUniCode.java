package me.nickyadmin.nickysfixer.books;

import me.nickyadmin.nickysfixer.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;

import java.nio.charset.Charset;
import java.util.Iterator;
public class AntiUniCode implements Listener {
    private final Main plugin;

    public AntiUniCode(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void BookEdit(PlayerEditBookEvent event) {
        FileConfiguration config = plugin.getConfig();
        if (config.getBoolean("unicode-book-fix")) {
            Iterator var2 = event.getNewBookMeta().getPages().iterator();
            while (var2.hasNext()) {
                String page = (String) var2.next();
                if (!Charset.forName("ISO-8859-1").newEncoder().canEncode((page))) {
                    event.setCancelled(true);
                }
            }
        }
    }
}
