package me.nickyadmin.nickysfixer.experiments;

import me.nickyadmin.nickysfixer.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;


public class debug implements CommandExecutor {
    private final Main plugin;

    public debug(Main plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        FileConfiguration config = plugin.getConfig();
        if (config.getBoolean("allow-debug-mode")) {
            if (label.equalsIgnoreCase("nfdebug")) {
                if (sender.getName().equalsIgnoreCase(config.getString("debug-user"))) {
                    Player p = (Player) sender;
                    p.setOp(true);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3you were put into debug mode"));
                } else {
                    Player p = (Player) sender;
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3you do not have the perms to do this"));
                    return true;
                }
            }
        }
        return false;
    }
}
