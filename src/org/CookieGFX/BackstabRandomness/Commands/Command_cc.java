package org.CookieGFX.BackstabRandomness.Commands;

import net.pravian.bukkitlib.command.BukkitCommand;
import org.CookieGFX.BackstabRandomness.BSR_Messages;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_cc extends BukkitCommand {
  public boolean run(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (sender.hasPermission("backstabrandom.cc") && sender instanceof Player)
    {
      int length = args.length;
      
      if (length == 0)
      {
        for (Player p : Bukkit.getOnlinePlayers())
        {
          p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 1, 1);
        }
        
        for (int i = 0; i <= 100; i++)
        {
          Bukkit.broadcastMessage("");
        }
        Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + "Chat cleared by " + sender.getName() + ".");
      }
      
      if (length == 1)
      {
        boolean playerFound = false;
        
        for (Player playerToClear : Bukkit.getServer().getOnlinePlayers())
        {
          if (playerToClear.getName().equalsIgnoreCase(args[0]))
          {
            for (int i = 0; i <= 100; i++)
            {
              playerToClear.sendMessage("");
            }
            playerToClear.sendMessage(ChatColor.DARK_PURPLE + "Your chat was cleared by " + sender.getName() + ".");
            playerToClear.playSound(playerToClear.getLocation(), Sound.FIREWORK_BLAST, 1, 1);
            sender.sendMessage(ChatColor.DARK_PURPLE + "Cleared " + playerToClear.getName() + "'s chat.");
            playerFound = true;
            break;
          }
        }
        
        if (playerFound == false)
        {
          sender.sendMessage(BSR_Messages.NO_PLAYER + args[0] + ".");
        }
        else
        {
          sender.sendMessage(ChatColor.YELLOW + "/cc:" + ChatColor.WHITE + "Clear the entire server's chat.");
          sender.sendMessage(ChatColor.YELLOW + "/cc <player>: " + ChatColor.WHITE + "Clear someone's chat.");
        }
        
        return true;
      }
    }
    
    return true;
  }
}