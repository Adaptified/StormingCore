package org.CookieGFX.BackstabRandomness.Commands;

import net.pravian.bukkitlib.command.BukkitCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;

public class Command_pluginrl extends BukkitCommand {

    @Override
    public boolean run(CommandSender sender, Command command, String commandLabel, String[] args) {
        Player player = (Player) sender;
        if (!(player.hasPermission("backstabrandom.pluginrl"))) {
          sender.sendMessage(ChatColor.DARK_RED + "You do not have access to that command.");
          return true;
        }
        final PluginManager pm = plugin.getServer().getPluginManager();
        pm.disablePlugin(plugin);
        pm.enablePlugin(plugin);
        player.sendMessage(ChatColor.RED + "(!) You reloaded the plugin!");
        return true;
    }
    
}
