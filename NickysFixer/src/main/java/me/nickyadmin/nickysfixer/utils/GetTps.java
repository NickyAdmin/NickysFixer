package me.nickyadmin.nickysfixer.utils;

import me.nickyadmin.nickysfixer.Main;
import net.minecraft.server.v1_12_R1.MinecraftServer;

public class GetTps {
    private final Main plugin;

    public GetTps(Main plugin) {
        this.plugin = plugin;
    }

    @SuppressWarnings("deprecation")
    public static double getTps() {
        return (MinecraftServer.getServer().recentTps[0]);
    }


}

