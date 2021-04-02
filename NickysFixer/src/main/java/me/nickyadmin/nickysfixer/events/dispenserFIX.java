package me.nickyadmin.nickysfixer.events;

import me.nickyadmin.nickysfixer.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;

public class dispenserFIX implements Listener {
    private final Main plugin;

    public dispenserFIX(Main plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    private void onDispense(BlockDispenseEvent event) {
        FileConfiguration config = plugin.getConfig();
        if (config.getBoolean("fix-dispenser-crash-exploit")) {
            if (event.getBlock().getLocation().getY() > 253 || event.getBlock().getLocation().getY() < 2) {
                event.setCancelled(true);
            }
        }
    }
}
