package de.keanu.listener;

import de.keanu.util.Variables;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        if(Variables.firstPlayer == null) {
            Variables.firstPlayer = p;
        }

        e.setJoinMessage("§e" + p.getDisplayName() + " ist dem Challenge-Server beigetreten!");
        if(Variables.timerStarted) {
            Variables.elapsedTime = (System.currentTimeMillis() - Variables.startTime);
            p.sendMessage("§eTimer: §7" + (Variables.elapsedTime/1000) +"sec");
            if(Variables.sharedHearts) {
                p.setHealth(Variables.sharedHP);
            }

        }
    }
}
