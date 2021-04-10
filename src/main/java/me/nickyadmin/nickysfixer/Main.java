package me.nickyadmin.nickysfixer;

import me.nickyadmin.nickysfixer.antilag.AntiDispenserLag;
import me.nickyadmin.nickysfixer.antilag.redstone;
import me.nickyadmin.nickysfixer.commands.generalCommands;
import me.nickyadmin.nickysfixer.events.OnJoin;
import me.nickyadmin.nickysfixer.books.AntiUniCode;
import me.nickyadmin.nickysfixer.events.*;
import me.nickyadmin.nickysfixer.exploits.*;
import me.nickyadmin.nickysfixer.kickfixes.BlockLimits;
import me.nickyadmin.nickysfixer.utils.GetTps;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import me.nickyadmin.nickysfixer.experiments.debug;
import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin {


    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "[NickysFixer] " + ChatColor.DARK_AQUA + getConfig().getString("plugin-start-message"));
        getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3it is highly recommended that you edit the config to your liking"));
        this.saveDefaultConfig();
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new dispenserFIX(this), this);
        pm.registerEvents(new IllegalBlockPlace(this), this);
        pm.registerEvents(new netherroofFIX(this), this);
        pm.registerEvents(new OnJoin(this), this);
        pm.registerEvents(new AntiDispenserLag(this), this);
        pm.registerEvents(new AntiUniCode(this), this);
        pm.registerEvents(new BlockLimits(this), this);
        pm.registerEvents(new DisableExplosions(this), this);
        pm.registerEvents(new BedrockFixer(this), this);
        pm.registerEvents(new BookHandCrash(this), this);
        pm.registerEvents(new DeathFixer(this), this);
        pm.registerEvents(new BookDropCrash(this), this);
        pm.registerEvents(new EndPortal(this), this);
        pm.registerEvents(new AntiBed(this), this);
        pm.registerEvents(new EntityFix(this), this);
        pm.registerEvents(new ProjectileLag(this), this);
        pm.registerEvents(new redstone(this), this);
        pm.registerEvents(new debug(this), this);
        pm.registerEvents(new antiPlugins(this), this);
        pm.registerEvents(new generalCommands(this), this);
        Metrics metrics = new Metrics(this, 10876);
        if (getServer().getName().equalsIgnoreCase("bukkit") || getServer().getName().equalsIgnoreCase("craftserver") || getServer().getName().equalsIgnoreCase("craftbukkit")) {
            getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3please use spigot, paper or tunity"));
        }


    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "[NickysFixer] " + ChatColor.DARK_AQUA + getConfig().getString("plugin-disable-message"));
        if (getServer().getName().equalsIgnoreCase("bukkit") || getServer().getName().equalsIgnoreCase("craftserver") || getServer().getName().equalsIgnoreCase("craftbukkit")) {
            getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3please use spigot, paper or tunity"));
        }
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        try {
            if (label.equalsIgnoreCase("nickysfixer") || label.equalsIgnoreCase("nf") || label.equalsIgnoreCase("n") || label.equalsIgnoreCase("nickysfixes")) {
                if (args.length == 0) {
                    if (!(sender instanceof Player)) {
                        sender.sendMessage(ChatColor.DARK_RED + "[NickysFixer]" + ChatColor.DARK_AQUA + " this server runs NickysFixer 0.6.78 ALPHA by NickyAdmin#6965");
                        return true;
                    }
                }
                if (args[0].equalsIgnoreCase("reload")) {
                    if (!(sender instanceof Player)) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3the config was reloaded"));
                        saveDefaultConfig();
                        reloadConfig();
                    } else {
                        Player p = (Player) sender;
                        if (p.hasPermission("nickysfixer.command.reload")) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3the config was reloaded"));
                            saveDefaultConfig();
                            reloadConfig();
                        } else {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3I don't think you have the abilities for that big man"));
                        }
                    }
                }
                if (args[0].equalsIgnoreCase("kill")) {
                    if (!(sender instanceof Player)) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[Nickysfixer] &3dies**"));
                    }
                }
                if (args[0].equalsIgnoreCase("tps")) {
                    if (!(sender instanceof Player)) {
                        if (!(GetTps.getTps() < 20)) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[Nickysfixer] &320.00"));
                        } else {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[Nickysfixer] &3" + GetTps.getTps()));
                        }
                    }
                }
            }

        }catch(ArrayIndexOutOfBoundsException e){}
        return false;
    }
}

