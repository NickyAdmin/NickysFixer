package me.nickyadmin.nickysfixer.events;

import me.nickyadmin.nickysfixer.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class netherroofFIX implements Listener {
    private final Main plugin;

    public netherroofFIX(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void PlayerMove(PlayerMoveEvent event) {

        FileConfiguration config = plugin.getConfig();
        Player p = event.getPlayer();
        if (config.getBoolean("anti-nether-roof")) {
            if (p.isOp() && config.getBoolean("nether-roof-op-bypass")) {

            } else {
                if (event.getPlayer().getWorld().getEnvironment().equals(World.Environment.NETHER)) {
                    if (event.getTo().getY() >= 126) {
                        event.getPlayer().teleport(new Location(event.getPlayer().getWorld(), event.getPlayer().getLocation().getX(), 115, event.getPlayer().getLocation().getZ()));
                        event.getPlayer().sendMessage(ChatColor.DARK_RED + "[NickysFixer]" + ChatColor.DARK_AQUA + " nether roof is disabled due to lag :(");
                    }
                }


                if (event.getPlayer().isInsideVehicle()) {
                    if (event.getPlayer().getWorld().getEnvironment().equals(World.Environment.NETHER)) {
                        if (p.getLocation().getY() >= 126) {
                            p.leaveVehicle();
                            p.teleport(new Location(event.getPlayer().getWorld(), event.getPlayer().getLocation().getX(), 115, event.getPlayer().getLocation().getZ()));
                            p.sendMessage(ChatColor.DARK_RED + "[NickysFixer]" + ChatColor.DARK_AQUA + " nether roof is disabled due to lag :(");
                        }
                    }
                }
                if (p.isGliding()) {
                    if (p.getWorld().getEnvironment().equals(World.Environment.NETHER)) {
                        if (p.getLocation().getY() >= 126) {
                            p.setGliding(false);
                            p.sendMessage(ChatColor.DARK_RED + "[NickysFixer]" + ChatColor.DARK_AQUA + " nether roof is disabled due to lag :(");
                        }
                    }
                }
            }
        }
    }
}


