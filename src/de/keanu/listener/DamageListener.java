package de.keanu.listener;

import de.keanu.util.Variables;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;

public class DamageListener implements Listener {
    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        Entity ent = e.getEntity();

        if(ent instanceof Player) {
            Player p = (Player) ent;
            if(Variables.noDamage && Variables.timerStarted) {
                Variables.timerStarted = false;
                Variables.elapsedTime = (System.currentTimeMillis() - Variables.startTime);
                for(Player plys : Bukkit.getOnlinePlayers() ) {
                    plys.getInventory().clear();
                    plys.setGameMode(GameMode.SPECTATOR);
                    plys.sendMessage("§e" + p.getDisplayName() + "§7 hat Schaden bekommen!");
                }
                Bukkit.broadcastMessage("§eChallenge ist vorbei!\n§7Endzeit: §e" + (Variables.elapsedTime/1000)+"sec");
            }
            if(Variables.sharedHearts && Variables.timerStarted) {
                for(Player plys : Bukkit.getOnlinePlayers() ) {
                    plys.setHealth(p.getHealth());
                    Variables.sharedHP = p.getHealth();
                    plys.sendMessage("§e" + p.getDisplayName() + "§7 hat Schaden bekommen!");
                }
            }
        }
    }
    @EventHandler
    public void onGeneration(EntityRegainHealthEvent e) {
        Entity ent = e.getEntity();
        Player p = (Player) e;
        if(ent instanceof Player) {
            if(Variables.sharedHearts && Variables.timerStarted) {
                for(Player plys : Bukkit.getOnlinePlayers() ) {
                    plys.setHealth(p.getHealth());
                    Variables.sharedHP = p.getHealth();
                }
            }
        }
    }
}
