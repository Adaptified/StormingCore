package org.CookieGFX.BackstabRandomness;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class BSR_PlayerData
{
    public final static Map<Player, BSR_PlayerData> userinfo = new HashMap<Player, BSR_PlayerData>();
    private boolean user_frozen = false;
    private boolean in_adminchat = false;
    private boolean mob_thrower_enabled = false;
    private EntityType mob_thrower_creature = EntityType.PIG;
    private double mob_thrower_speed = 4.0;
    private List<LivingEntity> mob_thrower_queue = new ArrayList<LivingEntity>();
    private BukkitTask lockup_schedule_id = null;
    

    
    public static BSR_PlayerData getPlayerData(Player player)
    {
        BSR_PlayerData playerdata = BSR_PlayerData.userinfo.get(player);

        if (playerdata == null)
        {
            Iterator<Entry<Player, BSR_PlayerData>> it = userinfo.entrySet().iterator();
            while (it.hasNext())
            {
                Entry<Player, BSR_PlayerData> pair = it.next();

               
            }
        }
        
        if (playerdata == null)
        {
            BSR_PlayerData.userinfo.put(player, playerdata);
        }

        return playerdata;
    }
    
    public boolean isFrozen()
    {
        return this.user_frozen;
    }

    public void setFrozen(boolean fr)
    {
        this.user_frozen = fr;
    }
    
    public void enableMobThrower(EntityType mob_thrower_creature, double mob_thrower_speed)
    {
        this.mob_thrower_enabled = true;
        this.mob_thrower_creature = mob_thrower_creature;
        this.mob_thrower_speed = mob_thrower_speed;
    }

    public void disableMobThrower()
    {
        this.mob_thrower_enabled = false;
    }

    public EntityType mobThrowerCreature()
    {
        return mob_thrower_creature;
    }

    public double mobThrowerSpeed()
    {
        return mob_thrower_speed;
    }

    public boolean mobThrowerEnabled()
    {
        return mob_thrower_enabled;
    }

    public void enqueueMob(LivingEntity mob)
    {
        mob_thrower_queue.add(mob);
        if (mob_thrower_queue.size() > 4)
        {
            LivingEntity oldmob = mob_thrower_queue.remove(0);
            if (oldmob != null)
            {
                oldmob.damage(500.0);
            }
        }
    }
    
    public BukkitTask getLockupScheduleID()
    {
        return lockup_schedule_id;
    }

    public void setLockupScheduleID(BukkitTask lockup_schedule_id)
    {
        this.lockup_schedule_id = lockup_schedule_id;
    }
    
    public void setAdminChat(boolean in_adminchat)
    {
        this.in_adminchat = in_adminchat;
    }

    public boolean inAdminChat()
    {
        return in_adminchat;
    }
}