package de.keanu.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerListListener implements Listener {
    @EventHandler
    public void onListPing(ServerListPingEvent e) {
        e.setMotd("§ca Challenge-Server §7[§aPlugin by Keanu§7]");
    }
}
