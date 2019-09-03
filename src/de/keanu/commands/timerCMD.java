package de.keanu.commands;

import de.keanu.util.Variables;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class timerCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p =(Player) sender;
        if(args.length == 1) {
            if(p.hasPermission("challenge.timer")) {
                switch(args[0]) {
                    case "reset": {
                        System.out.println("Start");
                        Variables.timerStarted = true;
                        Variables.startTime = System.currentTimeMillis();
                        p.sendMessage("§7Du hast den Timer neugestartet.");
                        Bukkit.broadcastMessage("§e" + p.getDisplayName() + "§7 hat den Timer neugestartet!");
                        break;
                    }
                    case "time": {
                        System.out.println("Time");
                        Variables.elapsedTime = (System.currentTimeMillis() - Variables.startTime);
                        p.sendMessage("§eTimer: §7" + Variables.elapsedTime);
                        break;
                    }
                    case "stop": {
                        System.out.println("Stop");
                        Variables.elapsedTime = (System.currentTimeMillis() - Variables.startTime);
                        Bukkit.broadcastMessage("§e" + p.getDisplayName() + "§7 hat den Timer gestoppt!");
                        Bukkit.broadcastMessage("§7Endzeit:§e" + Variables.elapsedTime);
                        Variables.timerStarted = false;
                        break;
                    }
                    default: {
                        p.sendMessage("§ereset,time,stop");
                    }
                }
            } else {
                p.sendMessage("§cDas kannst du nicht tun!");
            }
        } else {
            p.sendMessage("§c/timer <setting>");
        }
        return true;
    }
}
