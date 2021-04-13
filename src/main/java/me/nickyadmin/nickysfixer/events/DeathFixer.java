package me.nickyadmin.nickysfixer.events;

import me.nickyadmin.nickysfixer.Main;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class DeathFixer implements Listener {
    private final Main plugin;

    public DeathFixer(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player p = event.getPlayer();
        FileConfiguration config = plugin.getConfig();
        if (config.getBoolean("anti-ghost-movements")) {
            if (event.getPlayer().isDead()) {
                event.getPlayer().kickPlayer(ChatColor.DARK_RED + "[NickysFixer] " + ChatColor.DARK_AQUA + "ghost moving is prohibited");
            }
        }
    }
}
