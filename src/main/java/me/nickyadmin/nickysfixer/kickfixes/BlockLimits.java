package me.nickyadmin.nickysfixer.kickfixes;


import me.nickyadmin.nickysfixer.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

    public class BlockLimits implements Listener {
        private final Main plugin;

        public BlockLimits(Main plugin) {
            this.plugin = plugin;
        }

        @EventHandler
        public void onBlockPlace(BlockPlaceEvent event) {
            Player p = event.getPlayer();
            FileConfiguration config = plugin.getConfig();
            if (config.getBoolean("fix-chunk-ban")) {
                Block block = event.getBlock();
                if ((block.getType() == Material.FURNACE || block.getType() == Material.CHEST || block.getType() == Material.TRAPPED_CHEST || block.getType() == Material.ENCHANTMENT_TABLE
                        || block.getType() == Material.WALL_SIGN || block.getType() == Material.HOPPER || block.getType() == Material.DROPPER || block.getType() == Material.DISPENSER
                        || block.getType() == Material.BREWING_STAND || block.getType() == Material.BEACON || block.getType() == Material.SIGN_POST
                        || block.getType() == Material.ENDER_CHEST || block.getType() == Material.TRAP_DOOR) && event.getBlock().getChunk().getTileEntities().length > config.getInt("max-tile-entities-per-chunk")) {

                    event.setCancelled(true);
                    p.sendMessage(ChatColor.DARK_RED + "[NickysFixer] " + ChatColor.DARK_AQUA + config.getString("anti-chunk-ban-message"));
                }

                if ((block.getType() == Material.SKULL || block.getType() == Material.SKULL_ITEM) && block.getChunk().getTileEntities().length > config.getInt("max-skulls-entities-per-chunk")) {
                    event.setCancelled(true);
                    p.sendMessage(ChatColor.DARK_RED + "[NickysFixer] " + ChatColor.DARK_AQUA + config.getString("anti-chunk-ban-message"));
                }
            }
        }
    }
