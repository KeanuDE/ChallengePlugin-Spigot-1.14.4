package de.keanu.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        e.setJoinMessage("§e" + p.getDisplayName() + " ist dem Challenge-Server beigetreten!");
        p.teleport(new Location(Bukkit.getWorld("world"),16,61,93));

    }
}
