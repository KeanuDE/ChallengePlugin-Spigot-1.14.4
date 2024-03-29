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
        String msg = "§e" + p.getDisplayName() + "§7 hat den Timer gestartet!\n§cChallenges: §7";
        if(args.length == 1) {
            switch(args[0]) {
                case "start": {
                    Variables.startTime = System.currentTimeMillis();
                    Variables.timerStarted = true;
                    p.sendMessage("§7Du hast den Timer gestartet.");
                    if(Variables.noRegeneration) {
                        msg = msg + "\nnoRegeneration";
                    }
                    if(Variables.sharedHearts) {
                        msg = msg + "\nsharedHearts";
                    }
                    if(Variables.noSneak) {
                        msg = msg + "\nnoSneak";
                    }
                    if(Variables.noJump) {
                        msg = msg + "\nnoJump";
                    }
                    if(Variables.noDamage) {
                        msg = msg + "\nnoDamage";
                    }
                    Bukkit.broadcastMessage(msg);
                    break;
                }
                case "reset": {
                    Variables.timerStarted = true;
                    Variables.startTime = System.currentTimeMillis();
                    p.sendMessage("§7Du hast den Timer neugestartet.");
                    Bukkit.broadcastMessage("§e" + p.getDisplayName() + "§7 hat den Timer neugestartet!");
                    break;
                }
                case "time": {
                    System.out.println("Time");
                    Variables.elapsedTime = (System.currentTimeMillis() - Variables.startTime);
                    p.sendMessage("§eTimer: §7" + (Variables.elapsedTime/1000) +"sec");
                    break;
                }
                case "stop": {
                    System.out.println("Stop");
                    Variables.elapsedTime = (System.currentTimeMillis() - Variables.startTime);
                    Bukkit.broadcastMessage("§e" + p.getDisplayName() + "§7 hat den Timer gestoppt!");
                    Bukkit.broadcastMessage("§7Endzeit: §e" + (Variables.elapsedTime/1000)+"sec");
                    Variables.timerStarted = false;
                    break;
                }
                default: {
                    p.sendMessage("§estart,reset,time,stop");
                }
            }
        } else {
            p.sendMessage("§c/timer <setting>");
            p.sendMessage("§estart,reset,time,stop");
        }
        return true;
    }
}
