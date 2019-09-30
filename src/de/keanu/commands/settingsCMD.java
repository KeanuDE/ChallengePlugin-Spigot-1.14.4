package de.keanu.commands;

import de.keanu.util.Variables;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class settingsCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        String setting = args[0];

        if(args.length == 1) {
            if(p.hasPermission("challenge.settings")) {
                switch (setting) {
                    case "noReg": {
                        if (Variables.noRegeneration) {
                            Variables.noRegeneration = false;
                            Bukkit.broadcastMessage("§enoRegeneration§7: §coff");
                        } else {
                            Variables.noRegeneration = true;
                            Bukkit.broadcastMessage("§enoRegeneration§7: §aon");
                        }
                        break;
                    }
                    case "sharedHP": {
                        if (Variables.sharedHearts) {
                            Variables.sharedHearts = false;
                            Bukkit.broadcastMessage("§esharedHearts§7: §coff");
                        } else {
                            Variables.sharedHearts = true;
                            Bukkit.broadcastMessage("§esharedHearts§7: §aon");
                        }
                        break;
                    }
                    case "noDamage": {
                        if (Variables.noDamage) {
                            Variables.noDamage = false;
                            Bukkit.broadcastMessage("§eNoDamage§7: §coff");
                        } else {
                            Variables.noDamage = true;
                            Bukkit.broadcastMessage("§eNoDamage§7: §aon");
                        }
                        break;
                    }
                    case "noJump": {
                        if (Variables.noJump) {
                            Variables.noJump = false;
                            Bukkit.broadcastMessage("§eNoJump§7: §coff");
                        } else {
                            Variables.noJump = true;
                            Bukkit.broadcastMessage("§eNoJump§7: §aon");
                        }
                        break;
                    }
                    case "noSneak": {
                        if (Variables.noSneak) {
                            Variables.noSneak = false;
                            Bukkit.broadcastMessage("§eNoSneak§7: §coff");
                        } else {
                            Variables.noSneak = true;
                            Bukkit.broadcastMessage("§eNoSneak§7: §aon");
                        }
                        break;
                    }
                    case "backpack": {
                        if (Variables.backpack) {
                            Variables.backpack = false;
                            Bukkit.broadcastMessage("§eBackpack§7: §coff");
                        } else {
                            Variables.backpack = true;
                            Bukkit.broadcastMessage("§eBackpack§7: §aon");
                        }
                        break;
                    }
                    default:
                        p.sendMessage("§enoDamage§7,§enoJump§7,§enoSneak§7,§esharedHP§7,§enoReg§7,§eBackpack");
                }
            } else {
                p.sendMessage("§cDas kannst du nicht!");
            }
        } else {
            p.sendMessage("§enoDamage§6,§enoJump§6,§enoSneak§7,§esharedHP");
        }

        return true;
    }
}
