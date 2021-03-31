package me.nickyadmin.nickysfixer.events;

import me.nickyadmin.nickysfixer.Main;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class AntiBed implements Listener {
    private final Main plugin;

    public AntiBed(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onTame(PlayerBedEnterEvent event) {
        FileConfiguration config = plugin.getConfig();
        if (config.getBoolean("anti-bed")) {
            if (config.getBoolean("anti-bed-message")) {
                Player p = event.getPlayer();
                p.sendMessage(ChatColor.DARK_RED + "[NickysFixer] " + ChatColor.DARK_AQUA + "beds were disabled by an admin");
            }
            event.setCancelled(true);

        }
    }
}
