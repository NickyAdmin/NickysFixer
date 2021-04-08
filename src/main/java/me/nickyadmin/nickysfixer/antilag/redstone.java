package me.nickyadmin.nickysfixer.antilag;

import me.nickyadmin.nickysfixer.Main;
import me.nickyadmin.nickysfixer.utils.GetTps;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;

public class redstone implements Listener {
        private final Main plugin;

        public redstone(Main plugin) {
            this.plugin = plugin;
        }

        @EventHandler
        public void onRedstone(BlockPistonRetractEvent event) {
            FileConfiguration config = plugin.getConfig();
            if (config.getBoolean("limit-redstone")) {
            if (GetTps.getTps() <= config.getInt("tps-to-disable-redstone")) {
                event.setCancelled(true);
            }

            }
        }
    @EventHandler
    public void onRedstone(BlockPistonExtendEvent event) {
        FileConfiguration config = plugin.getConfig();
        if (config.getBoolean("limit-redstone")) {
            if (GetTps.getTps() <= config.getInt("tps-to-disable-redstone")) {
                event.setCancelled(true);
            }

        }
    }
    }
