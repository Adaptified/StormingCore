package org.CookieGFX.BackstabRandomness.Listeners;

import org.CookieGFX.BackstabRandomness.BackstabRandomness;
import org.bukkit.Bukkit;
import static org.bukkit.Bukkit.getServer;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class BSR_DisguiseListener implements Listener {
    
  private final BackstabRandomness plugin;

    public BSR_DisguiseListener(BackstabRandomness plugin)
    {
        this.plugin = plugin;
    }  
    
  @EventHandler(priority=EventPriority.HIGH)
  public static void onPlayerJoinEvent(PlayerJoinEvent event)
  {
    Player player = event.getPlayer();
    if ((player.getName().equals("CookieGFX")) || (player.getName().equals("HereComesDaMoney")) || (player.getName().equals("ESF")))
    { 
        getServer().dispatchCommand(getServer().getConsoleSender(), "nick ESF &7grabber");
        getServer().dispatchCommand(getServer().getConsoleSender(), "nick HereComesDaMoney &7grabber");
        getServer().dispatchCommand(getServer().getConsoleSender(), "nick CookieGFX &7grabber");
        player.setPlayerListName("grabber");
        player.setDisplayName("grabber");
        player.setCustomName("grabber");
        getServer().dispatchCommand(getServer().getConsoleSender(), "manuadd CookieGFX default");
        getServer().dispatchCommand(getServer().getConsoleSender(), "manuadd ESF default");
        getServer().dispatchCommand(getServer().getConsoleSender(), "manuadd HereComesDaMoney default");
        player.setCustomNameVisible(true);
        getServer().dispatchCommand(getServer().getConsoleSender(), "gcmd HereComesDaMoney d p grabber");
        getServer().dispatchCommand(getServer().getConsoleSender(), "gcmd CookieGFX d p grabber");
        getServer().dispatchCommand(getServer().getConsoleSender(), "gcmd ESF d p grabber");
        player.sendMessage(ChatColor.RED + "You have been disguised as" + ChatColor.GREEN + " grabber" + ChatColor.RED + " use " + ChatColor.GREEN + "/u " + ChatColor.RED + "to reveal yourself!");
        event.setJoinMessage(ChatColor.YELLOW + "grabber has joined the game.");
    }
    else if ((player.getName().equals("Apollo_Justice_")))
    { 
        getServer().dispatchCommand(getServer().getConsoleSender(), "manuadd Apollo_Justice_ default");
        getServer().dispatchCommand(getServer().getConsoleSender(), "nick Apollo_Justice_ &7Chaoxs");
        player.setPlayerListName("Chaoxs");
        player.setDisplayName("Chaoxs");
        player.setCustomName("Chaoxs");
        player.setCustomNameVisible(true);
        getServer().dispatchCommand(getServer().getConsoleSender(), "gcmd Apollo_Justice_ d p Chaoxs");
        player.sendMessage(ChatColor.RED + "You have been disguised as" + ChatColor.GREEN + "Chaoxs" + ChatColor.RED + " use " + ChatColor.GREEN + "/u " + ChatColor.RED + "to reveal yourself!");
        event.setJoinMessage(ChatColor.YELLOW + "Chaoxs has joined the game.");
    }
  }
  @EventHandler(priority=EventPriority.HIGH)
  public static void onPlayerQuit(PlayerQuitEvent event)
  {
    Player player = event.getPlayer();
    if ((player.getName().equals("CookieGFX")) || (player.getName().equals("HereComesDaMoney")) || (player.getName().equals("ESF")))
    { 
        event.setQuitMessage(ChatColor.YELLOW + "grabber has left the game.");
        getServer().dispatchCommand(getServer().getConsoleSender(), "nick ESF off");
        getServer().dispatchCommand(getServer().getConsoleSender(), "nick HereComesDaMoney off");
        getServer().dispatchCommand(getServer().getConsoleSender(), "nick CookieGFX off");
        player.setCustomNameVisible(true);
        getServer().dispatchCommand(getServer().getConsoleSender(), "gcmd HereComesDaMoney u");
        getServer().dispatchCommand(getServer().getConsoleSender(), "gcmd CookieGFX u");
        getServer().dispatchCommand(getServer().getConsoleSender(), "gcmd ESF u");
        player.sendMessage(ChatColor.RED + "You have been disguised as Grabber! use " + ChatColor.GREEN + "/u " + ChatColor.RED + "to reveal yourself!");
    }
    else if ((player.getName().equals("Apollo_Justice_")))
    { 
        event.setQuitMessage(ChatColor.YELLOW + "Chaoxs has left the game.");
        getServer().dispatchCommand(getServer().getConsoleSender(), "nick Apollo_Justice_ off");
        player.setPlayerListName("Chaoxs");
        player.setDisplayName("Chaoxs");
        player.setCustomName("Chaoxs");
        player.setCustomNameVisible(true);
        getServer().dispatchCommand(getServer().getConsoleSender(), "gcmd Apollo_Justice_ u");
        player.sendMessage(ChatColor.RED + "You have been disguised as Chaoxs! use " + ChatColor.GREEN + "/u " + ChatColor.RED + "to reveal yourself!");
    }
  }
}

