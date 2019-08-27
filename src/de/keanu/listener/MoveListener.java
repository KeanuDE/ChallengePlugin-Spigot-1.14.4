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
            if(p.getVelocity().getY() >= 0 && !p.isOnGround()) {
                for(Player plys : Bukkit.getOnlinePlayers()) {
                    plys.setGameMode(GameMode.SPECTATOR);
                    plys.sendMessage("§e" + p.getDisplayName() + "§7 ist gesprungen!");
                }
            }
        }
        if(Variables.noSneak) {
            if(p.isSneaking()) {
                for(Player plys : Bukkit.getOnlinePlayers()) {
                    plys.setGameMode(GameMode.SPECTATOR);
                    plys.sendMessage("§e" + p.getDisplayName() + "§7 hat gesneakt!");
                }
            }
        }
    }
}
