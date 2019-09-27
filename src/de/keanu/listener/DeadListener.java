package de.keanu.listener;

import de.keanu.main.Main;
import de.keanu.util.Variables;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeadListener implements Listener {
    @EventHandler
    public void onDeath(EntityDeathEvent e) {
        if(e.getEntityType() == EntityType.ENDER_DRAGON && Variables.timerStarted) {
            Variables.timerStarted = false;
            Variables.elapsedTime = (System.currentTimeMillis() - Variables.startTime);
            Bukkit.broadcastMessage("§eChallenge ist vorbei!\n§7Endzeit: §e" + (Variables.elapsedTime/1000)+"sec");
        }
    }
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        p.setGameMode(GameMode.SPECTATOR);
        if(Main.deathPlayer.size() == Bukkit.getServer().getOnlinePlayers().size()) {
            Bukkit.broadcastMessage("§eChallenge ist vorbei!\n§7Endzeit: §e" + (Variables.elapsedTime/1000)+"sec");
        } else {
            Bukkit.broadcastMessage("§7Der Spieler §e" + p.getDisplayName() + "§7 ist augeschieden!");
            Main.deathPlayer.add(p);
        }
    }
}
