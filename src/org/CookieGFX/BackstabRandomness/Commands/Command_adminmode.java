/*package org.CookieGFX.BackstabRandomness.Commands;

import net.pravian.bukkitlib.command.BukkitCommand;
import org.CookieGFX.BackstabRandomness.BSR_Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Command_adminmode extends BukkitCommand {

    @Override
    public boolean run(CommandSender sender, Command command, String commandLabel, String[] args) {
         if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (p.hasPermission("backstabrandom.adminmode"))
                {
                    if (args.length != 1)
                    {
                        return false;
                    }
    
                    if (args[0].equalsIgnoreCase("off"))
                    {
                        plugin.getConfig().set("admin_only_mode", false);
                        BSR_Util.bcastMsg(ChatColor.GREEN + p.getName() + " - Opening the server to all players.");
                        return true;
                    }
                    else if (args[0].equalsIgnoreCase("on"))
                    {
                        plugin.getConfig().set("admin_only_mode", true);
                        BSR_Util.bcastMsg(ChatColor.RED + p.getName() + " - Closing the server to non-admins.");
                        for (Player player : Bukkit.getServer().getOnlinePlayers())
                        {
                            if (!player.hasPermission("nonamedorg.adminmode.join"))
                            {
                                player.kickPlayer("Server is now closed to non-admins.");
                            }
                        }
                        return true;
                    }
                }
                else
                {
                    return true;
                }
            }
            else
            {
                if (args.length != 1)
                {
                    return false;
                }

                if (args[0].equalsIgnoreCase("off"))
                {
                    plugin.getConfig().set("admin_only_mode", false);
                    BSR_Util.bcastMsg(ChatColor.GREEN + sender.getName() + " - Opening the server to all players.");
                    return true;
                }
                else if (args[0].equalsIgnoreCase("on"))
                {
                    plugin.getConfig().set("admin_only_mode", true);
                    BSR_Util.bcastMsg(ChatColor.RED + sender.getName() + " - Closing the server to non-admins.");
                    for (Player player : Bukkit.getServer().getOnlinePlayers())
                    {
                        if (!player.hasPermission("backstabrandom.adminmode.join"))
                        {
                            player.kickPlayer("Server is now closed to non-admins.");
                        }
                    }
                    return true;
                }
    }
        return false;
    
}
}
*/