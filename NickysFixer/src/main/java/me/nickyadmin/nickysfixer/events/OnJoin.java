package me.nickyadmin.nickysfixer.events;

import me.nickyadmin.nickysfixer.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnJoin implements Listener {
    private final Main plugin;

    public OnJoin(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        FileConfiguration config = plugin.getConfig();
        if (config.getBoolean("first-join-message")) {
            Player p = event.getPlayer();
            if (!p.hasPlayedBefore()) {
                Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "[NickysFixer] " + ChatColor.DARK_AQUA + p.getDisplayName() + " joined the server for the first time");
            }
        }
        if (config.getBoolean("everytime-join-nf-message")) {
            Player p = event.getPlayer();
            if (p.hasPlayedBefore()) {
                p.sendMessage(ChatColor.DARK_RED + "[NickysFixer] " + ChatColor.DARK_AQUA + config.getString("every-time-join-message"));
            }
        }
    }
}

