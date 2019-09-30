package de.keanu.main;

import de.keanu.commands.*;
import de.keanu.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class Main extends JavaPlugin {
    public Main plugin;
    public Main() {
        this.plugin = plugin;
    }
    public static HashMap<String, Location> warps = new HashMap<>();
    @Override
    public void onEnable() {
        System.out.println("[Challenge-Plugin] starting..");
        
        this.getCommand("settings").setExecutor(new settingsCMD());
        this.getCommand("timer").setExecutor(new timerCMD());
        this.getCommand("warp").setExecutor(new warpCMD());
        this.getCommand("backpack").setExecutor(new backpackCMD());
        this.getCommand("goal").setExecutor(new goalCMD());

        Bukkit.getPluginManager().registerEvents(new JoinListener(),this);
        Bukkit.getPluginManager().registerEvents(new DamageListener(),this);
        Bukkit.getPluginManager().registerEvents(new MoveListener(),this);
        Bukkit.getPluginManager().registerEvents(new DeadListener(), this);
        Bukkit.getPluginManager().registerEvents(new RegenerationListener(), this);
        Bukkit.getPluginManager().registerEvents(new ServerListListener(),this);

        System.out.println("[Challenge-Plugin] started.");
    }
}
