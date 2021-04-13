package me.nickyadmin.nickysfixer.antilag;

import me.nickyadmin.nickysfixer.Main;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;

public class ArmourStands implements Listener {
    public final Main plugin;

    public ArmourStands (Main plugin) {
        this.plugin = plugin;
    }
    @EventHandler
        public void ArmourStandChange(PlayerArmorStandManipulateEvent event) {
        FileConfiguration config = plugin.getConfig();
        if (config.getBoolean("disable-armour-stand-manipulation")) {
            event.setCancelled(true);
            Player p = event.getPlayer();
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[Nickysfixer] &3armour stands were disabled by an admin"));
        }


    }




}
