package me.nickyadmin.nickysfixer;

import me.nickyadmin.nickysfixer.antilag.AntiDispenserLag;
import me.nickyadmin.nickysfixer.events.OnJoin;
import me.nickyadmin.nickysfixer.books.AntiUniCode;
import me.nickyadmin.nickysfixer.events.*;
import me.nickyadmin.nickysfixer.exploits.*;
import me.nickyadmin.nickysfixer.kickfixes.BlockLimits;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import me.nickyadmin.nickysfixer.experiments.debug;

import java.util.HashMap;
import java.util.Map;


public final class Main extends JavaPlugin implements Listener {
    Map<String, Long> dupeslow = new HashMap<>();

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "[NickysFixer] " + ChatColor.DARK_AQUA + getConfig().getString("plugin-start-message"));
        this.saveDefaultConfig();
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(this, this);
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
        getCommand("nfdebug").setExecutor(new debug(this));



    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "[NickysFixer] " + ChatColor.DARK_AQUA + getConfig().getString("plugin-disable-message"));
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

                if (label.equalsIgnoreCase("server")) {
                    Player p = (Player) sender;
                    p.sendMessage(ChatColor.GREEN + "this server is running " + getServer().getName() + ", " + getServer().getBukkitVersion() + ", [NickysFixer]");
                    return true;
                }

        if (label.equalsIgnoreCase("nickysfixer") || label.equalsIgnoreCase("nf") || label.equalsIgnoreCase("n") || label.equalsIgnoreCase("nickysfixes")) {
            if (args.length == 0) {

                if (!(sender instanceof Player)) {
                    sender.sendMessage(ChatColor.DARK_RED + "[NickysFixer] " + ChatColor.DARK_AQUA + "this server runs NickysFixer 0.6.4 ALPHA by NickyAdmin#6965");
                    return true;
                }
                Player p = (Player) sender;
                if (!p.hasPermission("nickysfixer.command.nickysfixer.debug")) {
                    p.sendMessage(ChatColor.DARK_RED + "[NickysFixer]" + ChatColor.DARK_AQUA + " this server runs NickysFixer 0.6.4 ALPHA");
                    return true;
                }
                p.sendMessage(ChatColor.DARK_RED + "[NickysFixer]" + ChatColor.DARK_AQUA + " this server runs NickysFixer 0.6.4 ALPHA");
                p.sendMessage(ChatColor.DARK_RED + "[NickysFixer]" + ChatColor.DARK_AQUA + " you are now in debug mode ;p");
                return true;

            }
            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("help")) {
                    Player p = (Player) sender;
                    p.sendMessage(ChatColor.GREEN + "if you would like to support nickysfixer then go to paypal.me/hackmc29");
                    p.sendMessage(ChatColor.DARK_RED + "[NickysFixer]");
                    p.sendMessage(ChatColor.DARK_AQUA + "/pop (pops ur totem)");
                    p.sendMessage(ChatColor.DARK_AQUA + "/nickysfixer (tells you the version of nickys fixer)");
                    p.sendMessage(ChatColor.DARK_AQUA + "/dupe (toootaly doesn't kill you)");
                    p.sendMessage(ChatColor.DARK_AQUA + "/server (gives some server info)");
                    p.sendMessage(ChatColor.DARK_AQUA + "/nf help (nf help menu)");
                    p.sendMessage(ChatColor.DARK_AQUA + "/nf reload (reloads config)");
                    p.sendMessage(ChatColor.DARK_AQUA + "/nfdebug (enables debug mode)");
                }
            }
            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("reload")) {
                    Player p = (Player) sender;
                    if (!p.hasPermission("nickysfixer.command.reload")) {
                        p.sendMessage(ChatColor.DARK_RED + "[NickysFixer]" + ChatColor.DARK_AQUA + " the config was reloaded");
                        reloadConfig();
                    }
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[NickysFixer] &3You have no perms :("));
                }
            }
        }

            if (label.equalsIgnoreCase("dupe")) {
                Player p = (Player) sender;
                p.setHealth(0);
                p.sendMessage(ChatColor.DARK_RED + "[NickysFixer]" + ChatColor.DARK_AQUA + " OOOOOOOOOF");
                if (dupeslow.get(p.getName()) > System.currentTimeMillis()) {
                    p.sendMessage(ChatColor.DARK_RED + "[NickysFixer]" + ChatColor.DARK_AQUA + " please wait before executing this command again");
            }
                dupeslow.put(p.getName(), System.currentTimeMillis() + (8000));
        }
            if (label.equalsIgnoreCase("pop")) {
                if (!(sender instanceof Player)) {
                    sender.sendMessage(ChatColor.DARK_RED + "[NickysFixer]" + ChatColor.DARK_AQUA + " console pops*");
                    return true;
                }
                Player p = (Player) sender;
                p.damage(5000);
                p.sendMessage(ChatColor.DARK_RED + "[NickysFixer]" + ChatColor.DARK_AQUA + " successfully poped a totem");
                return true;
            }
        return false;
        }

    }
