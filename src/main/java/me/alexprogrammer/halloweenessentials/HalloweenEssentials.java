package me.alexprogrammer.halloweenessentials;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class HalloweenEssentials extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PumpkinListener(this), this);

        getLogger().info("Halloween Essentials Enabled! Made by Pistonmaster");
    }

    @Override
    public void onDisable() {
        getLogger().info("Halloween Essentials Disabled! Made by Pistonmaster");
    }
}
