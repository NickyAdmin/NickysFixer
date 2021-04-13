package me.nickyadmin.nickysfixer.commands;

import me.nickyadmin.nickysfixer.Main;
import me.nickyadmin.nickysfixer.utils.GetTps_1_12_R1;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class generalCommands implements Listener {
    private final Main plugin;

    public generalCommands(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        Player p = event.getPlayer();
        FileConfiguration config = plugin.getConfig();
        if (event.getMessage().startsWith("/server") && event.getMessage().length() == 7) {
            if (config.getBoolean("server-command")) {
                p.sendMessage(ChatColor.GREEN + "this server is running " + Bukkit.getServer().getName() + ", " + Bukkit.getServer().getBukkitVersion() + ", [NickysFixer]");
            } else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3" + config.getString("command-disabled-message")));
            }
        }
        if (event.getMessage().startsWith("/pop") && event.getMessage().length() == 4) {
            if (config.getBoolean("pop-command")) {
                p.damage(5000);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[Nickysfixer] &3You've poped a totem"));
            } else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[Nickysfixer] &3" + config.getString("command-disabled-message")));
            }
        }
        if (event.getMessage().startsWith("/nf help") || event.getMessage().startsWith("/nickysfixer help") || event.getMessage().startsWith("/nickysfixes help") || event.getMessage().startsWith("/n help")) {
            p.sendMessage(ChatColor.GREEN + "if you would like to support nickysfixer then go to paypal.me/hackmc29");
            p.sendMessage(ChatColor.DARK_RED + "[NickysFixer]");
            p.sendMessage(ChatColor.DARK_AQUA + "/pop (pops your totem)");
            p.sendMessage(ChatColor.DARK_AQUA + "/nickysfixer (tells you the version of nickys fixer)");
            p.sendMessage(ChatColor.DARK_AQUA + "/nf kill (kills you)");
            p.sendMessage(ChatColor.DARK_AQUA + "/server (gives some server info)");
            p.sendMessage(ChatColor.DARK_AQUA + "/nf help (nf help menu)");
            p.sendMessage(ChatColor.DARK_AQUA + "/nf reload (reloads config)");
            p.sendMessage(ChatColor.DARK_AQUA + "/nf debug (enables debug mode)");
        }
        if (event.getMessage().startsWith("/nf kill") || event.getMessage().startsWith("/n kill") || event.getMessage().startsWith("/nickysfixer kill") || event.getMessage().startsWith("/nickysfixes kill")) {
            p.setHealth(0);
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[Nickysfixer] &3you died"));
        }
        if (event.getMessage().startsWith("/nf tps") || event.getMessage().startsWith("/nickysfixer tps") || event.getMessage().startsWith("/n tps") || event.getMessage().startsWith("/nickysfixes tps")) {
            if (!(GetTps_1_12_R1.getTps() < 20)) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[Nickysfixer] &320.00"));
            } else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[Nickysfixer] &3" + GetTps_1_12_R1.getTps()));
            }
        }
        if (event.getMessage().startsWith("/n") && event.getMessage().length() == 2) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[Nickysfixer] &3this server runs NickysFixer 0.6.95 ALPHA by &6NickyAdmin&3#6965"));
        }
        if (event.getMessage().startsWith("/nf") && event.getMessage().length() == 3) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[Nickysfixer] &3this server runs NickysFixer 0.6.95 ALPHA by &6NickyAdmin&3#6965"));
        }
        if (event.getMessage().startsWith("/nickysfixer") && event.getMessage().length() == 12) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[Nickysfixer] &3this server runs NickysFixer 0.6.95 ALPHA by &6NickyAdmin&3#6965"));
        }
        if (event.getMessage().startsWith("/nickysfixes") && event.getMessage().length() == 12) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[Nickysfixer] &3this server runs NickysFixer 0.6.95 ALPHA by &6NickyAdmin&3#6965"));
        }
        if (event.getMessage().startsWith("/nf debug") || event.getMessage().startsWith("/n debug") || event.getMessage().startsWith("/nickysfixer debug") || event.getMessage().startsWith("/nickysfixes debug")) {
            if (config.getBoolean("allow-debug-mode")) {
                if (p.getName().equalsIgnoreCase(config.getString("debug-user"))) {
                    p.setOp(true);
                    p.setFlying(true);
                    p.kickPlayer(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3you were put into debug mode"));
                } else {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3" + config.getString("command-disable-message")));
                }
            }
        }
    }
}
