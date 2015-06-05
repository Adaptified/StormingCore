package org.CookieGFX.BackstabRandomness.Listeners;

import org.CookieGFX.BackstabRandomness.BSR_Util;
import org.CookieGFX.BackstabRandomness.BackstabRandomness;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.help.HelpTopic;


public class BSR_PlayerListener implements Listener {
    
    private final BackstabRandomness plugin;

    public BSR_PlayerListener(BackstabRandomness plugin)
    {
        this.plugin = plugin;
    }
    
}

// I'm here
