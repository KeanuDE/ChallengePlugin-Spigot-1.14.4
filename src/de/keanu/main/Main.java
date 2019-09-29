package de.keanu.main;

import de.keanu.commands.settingsCMD;
import de.keanu.commands.timerCMD;
import de.keanu.commands.warpCMD;
import de.keanu.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;

public class Main extends JavaPlugin {
    public static HashMap<String, Location> warps = new HashMap<>();
    @Override
    public void onEnable() {
        System.out.println("[Challenge-Plugin] starting..");
        
        this.getCommand("settings").setExecutor(new settingsCMD());
        this.getCommand("timer").setExecutor(new timerCMD());
        this.getCommand("warp").setExecutor(new warpCMD());

        Bukkit.getPluginManager().registerEvents(new JoinListener(),this);
        Bukkit.getPluginManager().registerEvents(new DamageListener(),this);
        Bukkit.getPluginManager().registerEvents(new MoveListener(),this);
        Bukkit.getPluginManager().registerEvents(new DeadListener(), this);
        Bukkit.getPluginManager().registerEvents(new RegenerationListener(), this);

        System.out.println("[Challenge-Plugin] started.");
    }
}
