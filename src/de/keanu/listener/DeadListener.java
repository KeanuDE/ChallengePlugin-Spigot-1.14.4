package de.keanu.listener;

import de.keanu.util.Variables;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class DeadListener implements Listener {
    @EventHandler
    public void onDeath(EntityDeathEvent e) {
        if(e.getEntityType() == EntityType.ENDER_DRAGON && Variables.timerStarted) {
            Variables.timerStarted = false;
            Variables.elapsedTime = (System.currentTimeMillis() - Variables.startTime);
            Bukkit.broadcastMessage("§eChallenge ist vorbei!\n§7Endzeit: §e" + (Variables.elapsedTime/1000)+"sec");
        }
    }
}
