package de.keanu.listener;

import de.keanu.util.Variables;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;

public class RegenerationListener implements Listener {
    @EventHandler
    public void onRegeneration(EntityRegainHealthEvent e) {
        Entity ent = e.getEntity();
        if(ent instanceof Player) {
            if(Variables.sharedHearts && Variables.timerStarted && !Variables.noRegeneration) {
                for(Player plys : Bukkit.getOnlinePlayers() ) {
                    plys.setHealth(((Player) ent).getHealth());
                    Variables.sharedHP = ((Player) ent).getHealth();
                }
            } else if ((Variables.sharedHearts && Variables.timerStarted && Variables.noRegeneration) || Variables.noRegeneration) {
                if(e.getRegainReason().equals(EntityRegainHealthEvent.RegainReason.SATIATED) || e.getRegainReason().equals(EntityRegainHealthEvent.RegainReason.EATING)) {
                    e.setCancelled(true);
                }
            }

        }
    }
}
