package me.nickyadmin.nickysfixer.events;

import me.nickyadmin.nickysfixer.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class DisableExplosions implements Listener {
        private final Main plugin;

        public DisableExplosions(Main plugin) {
            this.plugin = plugin;
        }
        @EventHandler
        public void onExplode(EntityExplodeEvent event) {
            FileConfiguration config = plugin.getConfig();
            if (config.getBoolean("disable-explosions")) {
                event.setCancelled(true);
            }
        }
    }

