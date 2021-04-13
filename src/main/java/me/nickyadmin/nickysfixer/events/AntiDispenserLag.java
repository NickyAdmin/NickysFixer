package me.nickyadmin.nickysfixer.events;

import me.nickyadmin.nickysfixer.Main;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;


    public class AntiDispenserLag implements Listener {
        private final Main plugin;

        public AntiDispenserLag(Main plugin) {
            this.plugin = plugin;
        }

        List<Material> items = Arrays.asList(Material.FIREBALL, Material.SNOW_BALL, Material.EXP_BOTTLE, Material.EGG, Material.SPLASH_POTION,
                Material.BOAT, Material.ARROW, Material.SPECTRAL_ARROW);

        @EventHandler
        public void onDispense(BlockDispenseEvent event) {
            FileConfiguration config = plugin.getConfig();
            if (config.getBoolean("anti-dispenser-lag")) {
                ItemStack item = event.getItem();
                if (items.contains(item.getType())) {
                    event.setCancelled(true);
                }
            }
        }
    }

