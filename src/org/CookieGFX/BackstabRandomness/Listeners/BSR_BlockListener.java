package org.CookieGFX.BackstabRandomness.Listeners;

import org.CookieGFX.BackstabRandomness.BackstabRandomness;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;


public class BSR_BlockListener implements Listener {
       
    private final BackstabRandomness plugin;

    public BSR_BlockListener(BackstabRandomness plugin)
    {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event)
    {
        Player player = event.getPlayer();
        switch (event.getBlockPlaced().getType()) {
            case BEDROCK: {
                if (!(player.hasPermission("backstabrandom.block.bedrock"))) {
                player.sendMessage(ChatColor.DARK_RED + "You do not have permission for bedrock!");
                event.setCancelled(true);
                }
            }    
        }
        
        switch (event.getBlockPlaced().getType()) {
            case SOUL_SAND: {
                if (!(player.hasPermission("backstabrandom.block.soulsand"))) {
                player.sendMessage(ChatColor.DARK_RED + "You do not have permission for soul sand!");
                event.setCancelled(true);
                }
            }    
        }
        
        
            
    }
}
