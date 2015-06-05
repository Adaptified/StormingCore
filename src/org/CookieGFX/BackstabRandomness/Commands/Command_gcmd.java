package org.CookieGFX.BackstabRandomness.Commands;

import net.pravian.bukkitlib.command.BukkitCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Command_gcmd extends BukkitCommand {

    @Override
    public boolean run(CommandSender sender, Command command, String commandLabel, String[] args) {
        if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (p.hasPermission("backstabrandom.gcmd"))
                {
                    if (args.length < 2)
                    {
                        return false;
                    }
                    
                    Player target = Bukkit.getServer().getPlayer(args[0]);

                    String outcommand = "";
                    try
                    {
                        StringBuilder outcommand_bldr = new StringBuilder();
                        for (int i = 1; i < args.length; i++)
                        {
                            outcommand_bldr.append(args[i]).append(" ");
                        }
                        outcommand = outcommand_bldr.toString().trim();
                    }
                    catch (Throwable ex)
                    {
                        sender.sendMessage(ChatColor.GRAY + "Error building command: " + ex.getMessage());
                        return true;
                    }

                    try
                    {
                        p.sendMessage("Sending command as " + target.getName() + ": " + outcommand);
                        if (Bukkit.getServer().dispatchCommand(target, outcommand))
                        {
                            p.sendMessage("Command sent.");
                        }
                        else
                        {
                            p.sendMessage("Unknown error sending command.");
                        }
                    }
                    catch (Throwable ex)
                    {
                        p.sendMessage("Error sending command: " + ex.getMessage());
                    }
            
                    return true;
                }
                else
                {
                    return true;
                }
            }
            else
            {
            if (args.length < 2)
                {
                    return false;
                }

                Player target = Bukkit.getServer().getPlayer(args[0]);

                String outcommand = "";
                try
                {
                    StringBuilder outcommand_bldr = new StringBuilder();
                    for (int i = 1; i < args.length; i++)
                    {
                        outcommand_bldr.append(args[i]).append(" ");
                    }
                    outcommand = outcommand_bldr.toString().trim();
                }
                catch (Throwable ex)
                {
                    sender.sendMessage(ChatColor.GRAY + "Error building command: " + ex.getMessage());
                    return true;
                }

                try
                {
                    sender.sendMessage("Sending command as " + target.getName() + ": " + outcommand);
                    if (Bukkit.getServer().dispatchCommand(target, outcommand))
                    {
                        sender.sendMessage("Command sent.");
                    }
                    else
                    {
                        sender.sendMessage("Unknown error sending command.");
                    }
                }
                catch (Throwable ex)
                {
                    sender.sendMessage("Error sending command: " + ex.getMessage());
                }
        
                return true;
    }
    
}
}
