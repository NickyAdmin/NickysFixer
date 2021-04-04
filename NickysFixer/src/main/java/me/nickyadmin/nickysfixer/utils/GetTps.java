package me.nickyadmin.nickysfixer.utils;

import net.minecraft.server.v1_12_R1.MinecraftServer;

public class GetTps {

    @SuppressWarnings("deprecation")
    public static double getTps() {
        return (MinecraftServer.getServer().recentTps[0]);
    }


}

