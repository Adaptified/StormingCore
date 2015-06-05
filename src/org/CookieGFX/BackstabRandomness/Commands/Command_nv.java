package org.CookieGFX.BackstabRandomness.Commands;

import net.pravian.bukkitlib.command.BukkitCommand;
import org.CookieGFX.BackstabRandomness.BSR_Messages;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Command_nv extends BukkitCommand {

    @Override
    public boolean run(CommandSender sender, Command cmd, String label, String[] args) {
          Player player = (Player) sender;
          if (! (player.hasPermission("shadoweracore.command.nv"))) {
          sender.sendMessage(BSR_Messages.NO_PREMS);
          return true;
          }
          if (args.length == 0) {
          player.sendMessage(BSR_Messages.USAGE + "/nv <on | off>");
          }
          
          else if (args[0].equalsIgnoreCase("on")) {
          player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 2000000, 1));
          player.sendMessage(BSR_Messages.TAG_MOD + ChatColor.GOLD + "You have activated nightvision, you may do '/nv off' to disable :D");
          }
          else if (args[0].equalsIgnoreCase("off")) {
          player.chat("/heal");
          player.sendMessage(BSR_Messages.TAG_MOD + ChatColor.GOLD + "You have disabled nightvision!");
          } 
        return true;
       
    }      
}