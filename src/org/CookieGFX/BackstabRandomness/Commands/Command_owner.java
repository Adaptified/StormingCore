package org.CookieGFX.BackstabRandomness.Commands;

import net.pravian.bukkitlib.command.BukkitCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Command_owner extends BukkitCommand {
    @Override
    public boolean run(CommandSender sender, Command command, String commandLabel, String[] args) {
    
    Player cyro = Bukkit.getServer().getPlayer("Cyrokrypto");
    if (cyro != null)
    {
    sender.sendMessage(ChatColor.GREEN + "The owner is " + ChatColor.BLUE + "online" + ChatColor.GREEN + "!");
    return true;
    }
    else if (cyro == null)
    {
    sender.sendMessage(ChatColor.GREEN + "The owner is " + ChatColor.DARK_RED + "offline" + ChatColor.GREEN + "!");
    return true;
    }
    else
    {
    
    }


return false;
    
}
}
