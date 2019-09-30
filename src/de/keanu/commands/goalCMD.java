package de.keanu.commands;

import de.keanu.util.Variables;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class goalCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if(sender instanceof Player) {
            if (args.length == 1) {
                switch(args[0]) {
                    case "end": Variables.goal = "end"; Bukkit.getServer().broadcastMessage("§e" + p.getDisplayName() + "§7 hat das Ziel auf den §eEnderdragon §7gestellt!"); break;
                    case "wither": Variables.goal = "wither"; Bukkit.getServer().broadcastMessage("§e" + p.getDisplayName() + "§7 hat das Ziel auf den §eWither §7gestellt!"); break;
                    default: p.sendMessage("§c/goal <end/wither>");
                }
            } else {
                p.sendMessage("§c/goal <end/wither>");
            }
        }
        return true;
    }
}
