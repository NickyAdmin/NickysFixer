package me.nickyadmin.nickysfixer.antilag;

import me.nickyadmin.nickysfixer.Main;
import me.nickyadmin.nickysfixer.utils.GetTps_1_12_R1;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;
import org.bukkit.event.block.BlockRedstoneEvent;

public class redstone implements Listener {
    private final Main plugin;

    public redstone(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPistonOff(BlockPistonRetractEvent event) {
        FileConfiguration config = plugin.getConfig();
        if (config.getBoolean("limit-redstone")) {
            if (GetTps_1_12_R1.getTps() <= config.getInt("tps-to-disable-redstone")) {
                event.setCancelled(true);
                if (config.getBoolean("break-redstone")) {
                    event.getBlock().setType(Material.AIR);
                }
            }

        }
    }

    @EventHandler
    public void onPistonOn(BlockPistonExtendEvent event) {
        FileConfiguration config = plugin.getConfig();
        if (config.getBoolean("limit-redstone")) {
            if (GetTps_1_12_R1.getTps() <= config.getInt("tps-to-disable-redstone")) {
                event.setCancelled(true);
                if (config.getBoolean("break-redstone")) {
                    event.getBlock().setType(Material.AIR);
                }
            }

        }
    }
    @EventHandler
    public void onRedstone(BlockRedstoneEvent event) {
        FileConfiguration config = plugin.getConfig();
        if (config.getBoolean("limit-redstone")) {
            if (GetTps_1_12_R1.getTps() <= config.getInt("tps-to-disable-redstone")) {
                if (config.getBoolean("break-redstone")) {
                    event.getBlock().setType(Material.AIR);
                }
            }

        }
    }
}
