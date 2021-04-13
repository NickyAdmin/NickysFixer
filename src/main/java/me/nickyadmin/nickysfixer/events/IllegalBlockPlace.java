package me.nickyadmin.nickysfixer.events;

import me.nickyadmin.nickysfixer.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class IllegalBlockPlace implements Listener {
    private final Main plugin;

    public IllegalBlockPlace(Main plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        FileConfiguration config = plugin.getConfig();
        if (config.getBoolean("anti-illegal-place")) {
            Player p = event.getPlayer();
            Block block = event.getBlock();
            if (block.getType() == Material.BEDROCK) {
                        p.sendMessage(ChatColor.DARK_RED + "[NickysFixer] " + ChatColor.DARK_AQUA + "illegal block place");
                        event.setCancelled(true);
                    }

            if (block.getType() == Material.BARRIER) {
                p.sendMessage(ChatColor.DARK_RED + "[NickysFixer] " + ChatColor.DARK_AQUA + "illegal block place");
                event.setCancelled(true);
            }

            if ((block.getType() == Material.ENDER_PORTAL_FRAME) && ((!(p.getInventory().getItemInMainHand().getType() == Material.EYE_OF_ENDER))
                    || (!(p.getInventory().getItemInOffHand().getType() == Material.EYE_OF_ENDER)))) {
                if (!(p.getInventory().getItemInMainHand().getType() == Material.EYE_OF_ENDER)) {
                    if (!(p.getInventory().getItemInOffHand().getType() == Material.EYE_OF_ENDER)) {
                        p.sendMessage(ChatColor.DARK_RED + "[NickysFixer] " + ChatColor.DARK_AQUA + "illegal block place");
                        event.setCancelled(true);
                    }
                }
            } else {

            }

            if (block.getType() == Material.MOB_SPAWNER) {
                p.sendMessage(ChatColor.DARK_RED + "[NickysFixer] " + ChatColor.DARK_AQUA + "illegal block place");
                event.setCancelled(true);
            }
            if (block.getType() == Material.STRUCTURE_BLOCK) {
                p.sendMessage(ChatColor.DARK_RED + "[NickysFixer] " + ChatColor.DARK_AQUA + "illegal block place");
                event.setCancelled(true);

            }

            if (block.getType() == Material.STRUCTURE_VOID) {
                p.sendMessage(ChatColor.DARK_RED + "[NickysFixer] " + ChatColor.DARK_AQUA + "illegal block place");
                event.setCancelled(true);

            }

            if (block.getType() == Material.FROSTED_ICE) {
                p.sendMessage(ChatColor.DARK_RED + "[NickysFixer] " + ChatColor.DARK_AQUA + "illegal block place");
                event.setCancelled(true);

            }

            if (block.getType() == Material.COMMAND) {
                p.sendMessage(ChatColor.DARK_RED + "[NickysFixer] " + ChatColor.DARK_AQUA + "illegal block place");
                event.setCancelled(true);

            }
            if (block.getType() == Material.COMMAND_CHAIN) {
                p.sendMessage(ChatColor.DARK_RED + "[NickysFixer] " + ChatColor.DARK_AQUA + "illegal block place");
                event.setCancelled(true);

            }

            if (block.getType() == Material.COMMAND_MINECART) {
                p.sendMessage(ChatColor.DARK_RED + "[NickysFixer] " + ChatColor.DARK_AQUA + "illegal block place");
                event.setCancelled(true);
            }
            if (block.getType() == Material.COMMAND_REPEATING) {
                p.sendMessage(ChatColor.DARK_RED + "[NickysFixer] " + ChatColor.DARK_AQUA + "illegal block place");
                event.setCancelled(true);
            }
        }
    }
}
