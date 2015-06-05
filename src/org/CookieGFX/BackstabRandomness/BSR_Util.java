package org.CookieGFX.BackstabRandomness;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class BSR_Util {
    public static final List<String> STOP_COMMANDS = Arrays.asList("stop", "off", "end", "halt", "die");
    public static boolean method_crash = false;
  
    public static void adminAction(String name, String message, boolean isRed)
    {
        Bukkit.broadcastMessage((isRed ? ChatColor.RED : ChatColor.AQUA) + name + " - " + message);
    }    
    
    public static String colorise(String string)
    {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
    
    public static String formatLocation(Location in_loc)
    {
        return String.format("%s: (%d, %d, %d)",
                in_loc.getWorld().getName(),
                Math.round(in_loc.getX()),
                Math.round(in_loc.getY()),
                Math.round(in_loc.getZ()));
    }
    

    
    public static void bcastMsg(String message, ChatColor color)
    {
        BSR_Log.info(message, true);

        for (Player p : Bukkit.getOnlinePlayers())
        {
            p.sendMessage((color == null ? "" : color) + message);
        }
    }

    public static void bcastMsg(String message)
    {
        BSR_Util.bcastMsg(message, null);
    }
    
    public static void ChatBot(String message)
    {
        BSR_Log.info(message, true);
        
        for (Player player : Bukkit.getOnlinePlayers())
        {
            if (player.hasPermission("stormingnetwork.chatbot.view"))
            {
                player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "BOT" + ChatColor.WHITE + ChatColor.DARK_GRAY + "] " + ChatColor.YELLOW + "ChatBot" + ChatColor.RESET + ": " + ChatColor.DARK_AQUA + message);
            }
            else
            {
            }
        }
    }
    
    public static boolean isStopCommand(String command)
    {
        return STOP_COMMANDS.contains(command.toLowerCase());
    }
    
    public static List<String> removeDuplicates(List<String> old_list)
    {
        List<String> new_list = new ArrayList<String>();
        for (String entry : old_list)
        {
            if (!new_list.contains(entry))
            {
                new_list.add(entry);
            }
        }
        return new_list;
    }
    
    public static void setWorldTime(World world, long ticks)
    {
        long time = world.getTime();
        time -= time % 24000;
        world.setTime(time + 24000 + ticks);
    }
    
    public static void adminChatMessage(CommandSender sender, String message)
    {
        String name = sender.getName() + " " + getPrefix(sender);
        BSR_Log.info("[STAFF] " + name + ": " + message);

        for (Player player : Bukkit.getOnlinePlayers())
        {
            if (player.hasPermission("stormingnetwork.adminchat.view"))
            {
                player.sendMessage("[" + ChatColor.AQUA + "STAFF" + ChatColor.WHITE + "] " + ChatColor.DARK_RED + name + ": " + ChatColor.AQUA + message);
            }
            else
            {
            }
        }
    }

    public static String getPrefix(CommandSender sender)
    {        
        Player player = (Player) sender;
        String prefix;
        if (sender instanceof Player)
        {
            if (player.getName().equalsIgnoreCase("CookieGFX") || (player.getName().equalsIgnoreCase("Hockeyfan360")))
            {
                prefix = ChatColor.DARK_GRAY + "(" + ChatColor.BLUE + "Owner" + ChatColor.DARK_GRAY + ")";
            }
            else
            {
                prefix = ChatColor.DARK_GRAY + "(" + ChatColor.DARK_PURPLE + "Mod" + ChatColor.DARK_GRAY + ")";
            }
            if (player.getName().equalsIgnoreCase("Apollo_Justice_") || (player.getName().equalsIgnoreCase("ESF")))
            {
                prefix = ChatColor.DARK_GRAY + "(" + ChatColor.GOLD + "Admin" + ChatColor.DARK_GRAY + ")";
            }
            if (player.getName().equalsIgnoreCase("HereComesDaMoney") || (player.getName().equalsIgnoreCase("Occupied")))
            {
                prefix = ChatColor.DARK_GRAY + "(" + ChatColor.LIGHT_PURPLE + "Dev" + ChatColor.DARK_GRAY + ")";
            }
        }
        else
        {
            prefix = ChatColor.RED + "(Console)";
        }
        
        return prefix + ChatColor.WHITE;
    }
    
}
