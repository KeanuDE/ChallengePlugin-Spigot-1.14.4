package de.keanu.listener;

import de.keanu.util.Variables;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveListener implements Listener {
    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();

        if(Variables.noJump) {
            if(p.getVelocity().getY() >= 0 && !p.isOnGround() && Variables.timerStarted) {
                Variables.timerStarted = false;
                Variables.elapsedTime = (System.currentTimeMillis() - Variables.startTime);
                for(Player plys : Bukkit.getOnlinePlayers()) {
                    plys.setGameMode(GameMode.SPECTATOR);
                    plys.sendMessage("§e" + p.getDisplayName() + "§7 ist gesprungen!");
                }
                Bukkit.broadcastMessage("§eChallenge ist vorbei!\n§7Endzeit: §e" + (Variables.elapsedTime/1000)+"sec");
            }
        }
        if(Variables.noSneak) {
            if(p.isSneaking() && Variables.timerStarted) {
                Variables.timerStarted = false;
                Variables.elapsedTime = (System.currentTimeMillis() - Variables.startTime);
                for(Player plys : Bukkit.getOnlinePlayers()) {
                    plys.setGameMode(GameMode.SPECTATOR);
                    plys.sendMessage("§e" + p.getDisplayName() + "§7 hat gesneakt!");
                }
                Bukkit.broadcastMessage("§eChallenge ist vorbei!\n§7Endzeit: §e" + (Variables.elapsedTime/1000)+"sec");
            }
        }
    }
}
