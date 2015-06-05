package org.CookieGFX.BackstabRandomness.Commands;

import net.pravian.bukkitlib.command.BukkitCommand;
import org.CookieGFX.BackstabRandomness.BSR_Messages;
import static org.bukkit.Bukkit.getServer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_machat extends BukkitCommand {

    @Override
    public boolean run(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (! (player.hasPermission("backstabrandom.machat"))) {
          sender.sendMessage(BSR_Messages.NO_PREMS);
          return true;
          }
         if (args.length == 0) {
          player.sendMessage(BSR_Messages.USAGE + "/machat <player> <message>");
          }        
        String Say = "";
        for (int i = 1; i <= args.length - 1; i++)
        {
          Say = Say + args[i];
          if (i != args.length - 1) {
            Say = Say + " ";
          }
        }
        if (getServer().getPlayerExact(args[0]) == null) {
          sender.sendMessage(BSR_Messages.NO_PLAYER);
        } else {
          getServer().getPlayer(args[0]).chat(Say);
          player.sendMessage(BSR_Messages.TAG_MOD + ChatColor.GOLD + "You made " + getServer().getPlayer(args[0]).getName() + " say: " + Say);
                }
        return true;
    }
}