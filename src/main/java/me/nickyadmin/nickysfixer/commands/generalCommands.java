package me.nickyadmin.nickysfixer.commands;

import me.nickyadmin.nickysfixer.Main;
import me.nickyadmin.nickysfixer.utils.GetTps;
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
        if (event.getMessage().startsWith("/server")) {
            if (config.getBoolean("server-command")) {
                p.sendMessage(ChatColor.GREEN + "this server is running " + Bukkit.getServer().getName() + ", " + Bukkit.getServer().getBukkitVersion() + ", [NickysFixer]");
            } else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3" + config.getString("command-disabled-message")));
            }
        }
        if (event.getMessage().startsWith("/pop")) {
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
            p.sendMessage(ChatColor.DARK_AQUA + "/nfdebug (enables debug mode)");
        }
        if (event.getMessage().startsWith("/nf kill") || event.getMessage().startsWith("/n kill") || event.getMessage().startsWith("/nickysfixer kill") || event.getMessage().startsWith("/nickysfixes kill")) {
            p.setHealth(0);
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[Nickysfixer] &3you died"));
        }
        if (event.getMessage().startsWith("/nf tps") || event.getMessage().startsWith("/nickysfixer tps") || event.getMessage().startsWith("/n tps") || event.getMessage().startsWith("/nickysfixes tps")) {
            if (!(GetTps.getTps() < 20)) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[Nickysfixer] &320.00"));
            } else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[Nickysfixer] &3" + GetTps.getTps()));
            }
        }
        if (event.getMessage().startsWith("/n") && event.getMessage().length() == 2) {
            p.sendMessage(ChatColor.DARK_RED + "[NickysFixer] " + ChatColor.DARK_AQUA + "this server runs NickysFixer 0.6.79 ALPHA by NickyAdmin#6965");
        }
        if (event.getMessage().startsWith("/nf") && event.getMessage().length() == 3) {
            p.sendMessage(ChatColor.DARK_RED + "[NickysFixer] " + ChatColor.DARK_AQUA + "this server runs NickysFixer 0.6.79 ALPHA by NickyAdmin#6965");
        }
        if (event.getMessage().startsWith("/nickysfixer") && event.getMessage().length() == 12) {
            p.sendMessage(ChatColor.DARK_RED + "[NickysFixer] " + ChatColor.DARK_AQUA + "this server runs NickysFixer 0.6.79 ALPHA by NickyAdmin#6965");
        }
        if (event.getMessage().startsWith("/nickysfixes") && event.getMessage().length() == 12) {
            p.sendMessage(ChatColor.DARK_RED + "[NickysFixer] " + ChatColor.DARK_AQUA + "this server runs NickysFixer 0.6.79 ALPHA by NickyAdmin#6965");
        }
    }
}
