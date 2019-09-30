package de.keanu.commands;

import de.keanu.util.Variables;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class backpackCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if(sender instanceof Player) {
            if(args.length == 0) {
                if(Variables.backpack) {
                    p.openInventory(Variables.firstPlayer.getEnderChest());
                } else {
                    p.sendMessage("§cDas Backpack wurde nicht aktiviert!");
                }
            } else {
                p.sendMessage("§cEs ist nur §e/backpack§c!");
            }
        }
        return true;
    }
}
