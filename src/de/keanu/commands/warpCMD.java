package de.keanu.commands;

import de.keanu.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class warpCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if(sender instanceof Player) {
            if(args.length == 2) {
                if(args[0].equalsIgnoreCase("set")) {
                    Main.warps.put(args[1],p.getLocation());
                    p.sendMessage("§aWarp-Punkt platziert!");
                    Bukkit.broadcastMessage("§e" + p.getDisplayName() + "§7 hat den Warp-Punkt §e" + args[1] + " erstellt!");
                }
                else if(args[0].equalsIgnoreCase("tp")) {
                    p.teleport(Main.warps.get(args[1]));
                    p.sendMessage("§ateleported.");
                }
                else {
                    p.sendMessage("§c/warp set <name> ;; /warp tp <name>");
                }
            }
        }
        return true;
    }
}
