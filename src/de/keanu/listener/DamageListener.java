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
                Bukkit.broadcastMessage("§e"+p.getDisplayName()+"§7 hat Schaden bekommen! (§e"+e.getDamage()+"§7 : §e"+e.getCause().name()+")");
                for(Player plys : Bukkit.getOnlinePlayers() ) {
                    if(plys != p) {
                        Variables.sharedHP = p.getHealth();
                        plys.setHealth(p.getHealth());
                    }
                }
            }
        }
    }
}
