package me.nickyadmin.nickysfixer.events;

import me.nickyadmin.nickysfixer.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;

public class antiIllegalOnMove implements Listener {
    private final Main plugin;

    public antiIllegalOnMove(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void AntiIllegalMove(PlayerMoveEvent event) {
        FileConfiguration config = plugin.getConfig();
        Player p = event.getPlayer();
        if (p.getInventory().getItemInMainHand().getType() == Material.ENDER_PORTAL_FRAME) {
            if (config.getBoolean("anti-illegal-hold")) {
                p.getInventory().getItemInMainHand().setAmount(0);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3illegal block"));
            }
        }
        if (p.getInventory().getItemInOffHand().getType() == Material.ENDER_PORTAL_FRAME) {
            if (config.getBoolean("anti-illegal-hold")) {
                p.getInventory().getItemInOffHand().setAmount(0);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3illegal block"));
            }
        }
        if (p.getInventory().getItemInMainHand().getType() == Material.BEDROCK) {
            if (config.getBoolean("anti-illegal-hold")) {
                p.getInventory().getItemInMainHand().setAmount(0);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3illegal block"));
            }
        }
        if (p.getInventory().getItemInOffHand().getType() == Material.BEDROCK) {
            if (config.getBoolean("anti-illegal-hold")) {
                p.getInventory().getItemInOffHand().setAmount(0);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3illegal block"));
            }
        }
        if (p.getInventory().getItemInMainHand().getType() == Material.MOB_SPAWNER) {
            if (config.getBoolean("anti-illegal-hold")) {
                p.getInventory().getItemInMainHand().setAmount(0);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3illegal block"));
            }
        }
        if (p.getInventory().getItemInOffHand().getType() == Material.MOB_SPAWNER) {
            if (config.getBoolean("anti-illegal-hold")) {
                p.getInventory().getItemInOffHand().setAmount(0);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3illegal block"));
            }
        }
        if (p.getInventory().getItemInMainHand().getType() == Material.STRUCTURE_BLOCK) {
            if (config.getBoolean("anti-illegal-hold")) {
                p.getInventory().getItemInMainHand().setAmount(0);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3illegal block"));
            }
        }
        if (p.getInventory().getItemInOffHand().getType() == Material.STRUCTURE_BLOCK) {
            if (config.getBoolean("anti-illegal-hold")) {
                p.getInventory().getItemInOffHand().setAmount(0);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3illegal block"));
            }
        }
        if (p.getInventory().getItemInMainHand().getType() == Material.STRUCTURE_VOID) {
            if (config.getBoolean("anti-illegal-hold")) {
                p.getInventory().getItemInMainHand().setAmount(0);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3illegal block"));
            }
        }
        if (p.getInventory().getItemInOffHand().getType() == Material.STRUCTURE_VOID) {
            if (config.getBoolean("anti-illegal-hold")) {
                p.getInventory().getItemInOffHand().setAmount(0);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3illegal block"));
            }
        }
        if (p.getInventory().getItemInMainHand().getType() == Material.FROSTED_ICE) {
            if (config.getBoolean("anti-illegal-hold")) {
                p.getInventory().getItemInMainHand().setAmount(0);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3illegal block"));
            }
        }
        if (p.getInventory().getItemInOffHand().getType() == Material.FROSTED_ICE) {
            if (config.getBoolean("anti-illegal-hold")) {
                p.getInventory().getItemInOffHand().setAmount(0);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3illegal block"));
            }
        }
        if (p.getInventory().getItemInMainHand().getType() == Material.COMMAND) {
            if (config.getBoolean("anti-illegal-hold")) {
                p.getInventory().getItemInMainHand().setAmount(0);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3illegal block"));
            }
        }
        if (p.getInventory().getItemInOffHand().getType() == Material.COMMAND) {
            if (config.getBoolean("anti-illegal-hold")) {
                p.getInventory().getItemInOffHand().setAmount(0);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3illegal block"));
            }
        }
        if (p.getInventory().getItemInMainHand().getType() == Material.COMMAND_CHAIN) {
            if (config.getBoolean("anti-illegal-hold")) {
                p.getInventory().getItemInMainHand().setAmount(0);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3illegal block"));
            }
        }
        if (p.getInventory().getItemInOffHand().getType() == Material.COMMAND_CHAIN) {
            if (config.getBoolean("anti-illegal-hold")) {
                p.getInventory().getItemInOffHand().setAmount(0);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3illegal block"));
            }
        }
        if (p.getInventory().getItemInMainHand().getType() == Material.COMMAND_MINECART) {
            if (config.getBoolean("anti-illegal-hold")) {
                p.getInventory().getItemInMainHand().setAmount(0);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3illegal block"));
            }
        }
        if (p.getInventory().getItemInOffHand().getType() == Material.COMMAND_MINECART) {
            if (config.getBoolean("anti-illegal-hold")) {
                p.getInventory().getItemInOffHand().setAmount(0);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3illegal block"));
            }
        }
        if (p.getInventory().getItemInMainHand().getType() == Material.COMMAND_REPEATING) {
            if (config.getBoolean("anti-illegal-hold")) {
                p.getInventory().getItemInMainHand().setAmount(0);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3illegal block"));
            }
        }
        if (p.getInventory().getItemInOffHand().getType() == Material.COMMAND_REPEATING) {
            if (config.getBoolean("anti-illegal-hold")) {
                p.getInventory().getItemInOffHand().setAmount(0);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3illegal block"));
            }
        }


    }

    @EventHandler
    public void SwapPatch(PlayerSwapHandItemsEvent event) {
        ItemStack item = event.getOffHandItem();
        ItemStack item2 = event.getMainHandItem();
        if (item.getType() == Material.COMMAND_REPEATING || item.getType() == Material.COMMAND_CHAIN || item.getType() == Material.COMMAND_MINECART || item.getType() == Material.FROSTED_ICE || item.getType()
                == Material.STRUCTURE_VOID || item.getType() == Material.STRUCTURE_BLOCK || item.getType() == Material.MOB_SPAWNER || item.getType() == Material.BEDROCK || item.getType()
                == Material.BARRIER || item.getType() == Material.ENDER_PORTAL_FRAME) {
            Player p = event.getPlayer();
            event.setCancelled(true);
            p.getInventory().getItemInMainHand().setAmount(0);
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3illegal block"));
        }
        if (item2.getType() == Material.COMMAND_REPEATING || item2.getType() == Material.COMMAND_CHAIN || item2.getType() == Material.COMMAND_MINECART || item2.getType() == Material.FROSTED_ICE || item2.getType()
                == Material.STRUCTURE_VOID || item2.getType() == Material.STRUCTURE_BLOCK || item2.getType() == Material.MOB_SPAWNER || item2.getType() == Material.BEDROCK || item2.getType()
                == Material.BARRIER || item2.getType() == Material.ENDER_PORTAL_FRAME) {
            Player p = event.getPlayer();
            event.setCancelled(true);
            p.getInventory().getItemInOffHand().setAmount(0);
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3illegal block"));
        }

    }

    @EventHandler
    public void ItemFramePatch(PlayerInteractEntityEvent event) {
        Player p = event.getPlayer();
        FileConfiguration config = plugin.getConfig();
        ;
        if (config.getBoolean("anti-item-frame-bypass")) {
            if (p.getInventory().getItemInOffHand().getType() == Material.COMMAND_REPEATING || p.getInventory().getItemInOffHand().getType() == Material.COMMAND_CHAIN || p.getInventory().getItemInOffHand().getType() == Material.COMMAND_MINECART || p.getInventory().getItemInOffHand().getType() == Material.FROSTED_ICE || p.getInventory().getItemInOffHand().getType()
                    == Material.STRUCTURE_VOID || p.getInventory().getItemInOffHand().getType() == Material.STRUCTURE_BLOCK || p.getInventory().getItemInOffHand().getType() == Material.MOB_SPAWNER || p.getInventory().getItemInOffHand().getType() == Material.BEDROCK || p.getInventory().getItemInOffHand().getType() == Material.BARRIER || p.getInventory().getItemInOffHand().getType() == Material.ENDER_PORTAL_FRAME) {
                event.setCancelled(true);
                p.getInventory().getItemInOffHand().setAmount(0);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3illegal block"));
            }
            if (p.getInventory().getItemInMainHand().getType() == Material.COMMAND_REPEATING || p.getInventory().getItemInMainHand().getType() == Material.COMMAND_CHAIN || p.getInventory().getItemInMainHand().getType() == Material.COMMAND_MINECART || p.getInventory().getItemInMainHand().getType() == Material.FROSTED_ICE || p.getInventory().getItemInMainHand().getType()
                    == Material.STRUCTURE_VOID || p.getInventory().getItemInMainHand().getType() == Material.STRUCTURE_BLOCK || p.getInventory().getItemInMainHand().getType() == Material.MOB_SPAWNER || p.getInventory().getItemInMainHand().getType() == Material.BEDROCK || p.getInventory().getItemInMainHand().getType() == Material.BARRIER || p.getInventory().getItemInMainHand().getType() == Material.ENDER_PORTAL_FRAME) {
                event.setCancelled(true);
                p.getInventory().getItemInMainHand().setAmount(0);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3illegal block"));
            }
        }
    }

    @EventHandler
    public void ItemFramePatch2(PlayerQuitEvent event) {
        FileConfiguration config = plugin.getConfig();
        if (config.getBoolean("remove-illegals-in-hand-on-quit-game")) {
            Player p = event.getPlayer();
            if (p.getInventory().getItemInMainHand().getType() == Material.COMMAND_REPEATING || p.getInventory().getItemInMainHand().getType() == Material.COMMAND_CHAIN || p.getInventory().getItemInMainHand().getType() == Material.COMMAND_MINECART || p.getInventory().getItemInMainHand().getType() == Material.FROSTED_ICE || p.getInventory().getItemInMainHand().getType()
                    == Material.STRUCTURE_VOID || p.getInventory().getItemInMainHand().getType() == Material.STRUCTURE_BLOCK || p.getInventory().getItemInMainHand().getType() == Material.MOB_SPAWNER || p.getInventory().getItemInMainHand().getType() == Material.BEDROCK || p.getInventory().getItemInMainHand().getType() == Material.BARRIER || p.getInventory().getItemInMainHand().getType() == Material.ENDER_PORTAL_FRAME) {
                p.getInventory().getItemInMainHand().setAmount(0);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3illegal block"));
            }
            if (p.getInventory().getItemInOffHand().getType() == Material.COMMAND_REPEATING || p.getInventory().getItemInOffHand().getType() == Material.COMMAND_CHAIN || p.getInventory().getItemInOffHand().getType() == Material.COMMAND_MINECART || p.getInventory().getItemInOffHand().getType() == Material.FROSTED_ICE || p.getInventory().getItemInOffHand().getType()
                    == Material.STRUCTURE_VOID || p.getInventory().getItemInOffHand().getType() == Material.STRUCTURE_BLOCK || p.getInventory().getItemInOffHand().getType() == Material.MOB_SPAWNER || p.getInventory().getItemInOffHand().getType() == Material.BEDROCK || p.getInventory().getItemInOffHand().getType() == Material.BARRIER || p.getInventory().getItemInOffHand().getType() == Material.ENDER_PORTAL_FRAME) {
                p.getInventory().getItemInMainHand().setAmount(0);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3illegal block"));
            }
        }
    }
}
