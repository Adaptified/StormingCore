package org.CookieGFX.BackstabRandomness.Commands;

import net.pravian.bukkitlib.command.BukkitCommand;
import net.pravian.bukkitlib.util.StringUtils;
import org.CookieGFX.BackstabRandomness.BSR_Util;
import static org.bukkit.Bukkit.getServer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_changetabname extends BukkitCommand {

    @Override
    public boolean run(CommandSender sender, Command command, String commandLabel, String[] args) {
        Player player = (Player) sender;
        if (!(player.hasPermission("backstabrandom.changetabname"))) {
          sender.sendMessage(ChatColor.DARK_RED + "You do not have access to that command.");
          return true;
        }
        
        
        
        String newtab = StringUtils.join(args, " ");
        getServer().dispatchCommand(getServer().getConsoleSender(), "nick " + sender.getName() + " &7" + newtab);
        getServer().dispatchCommand(getServer().getConsoleSender(), "gcmd " + sender.getName() +  " d p " + newtab);
        player.setPlayerListName(newtab);
       player.sendMessage(ChatColor.RED + "Tab name changed to " + ChatColor.GREEN + newtab + ChatColor.RED + "!");      
        return true;
    }
    
}
