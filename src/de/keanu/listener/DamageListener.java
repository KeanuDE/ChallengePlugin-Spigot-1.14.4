package de.keanu.listener;

import de.keanu.util.Variables;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageListener implements Listener {
    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        Player p = (Player) e.getEntity();
        if(Variables.noDamage) {
            for(Player plys : Bukkit.getOnlinePlayers()) {
                plys.setGameMode(GameMode.SPECTATOR);
                plys.sendMessage("§e" + p.getDisplayName() + "§7 hat Schaden bekommen!");
            }
        }
    }
}
