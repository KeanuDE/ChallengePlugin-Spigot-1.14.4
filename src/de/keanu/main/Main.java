package de.keanu.main;

import de.keanu.commands.settingsCMD;
import de.keanu.commands.timerCMD;
import de.keanu.listener.DamageListener;
import de.keanu.listener.JoinListener;
import de.keanu.listener.MoveListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        System.out.println("[Challenge-Plugin] starting..");
        
        this.getCommand("settings").setExecutor(new settingsCMD());
        this.getCommand("timer").setExecutor(new timerCMD());

        Bukkit.getPluginManager().registerEvents(new JoinListener(),this);
        Bukkit.getPluginManager().registerEvents(new DamageListener(),this);
        Bukkit.getPluginManager().registerEvents(new MoveListener(),this);
        System.out.println("[Challenge-Plugin] started.");
    }
}
