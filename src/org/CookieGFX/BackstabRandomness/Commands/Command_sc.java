package org.CookieGFX.BackstabRandomness.Commands;

import org.CookieGFX.BackstabRandomness.BSR_PlayerData;
import net.pravian.bukkitlib.command.BukkitCommand;
import net.pravian.bukkitlib.util.StringUtils;
import org.CookieGFX.BackstabRandomness.BSR_Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_sc extends BukkitCommand {

    @Override
    public boolean run(CommandSender sender, Command command, String commandLabel, String[] args) {
      if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (p.hasPermission("backstabrandom.staffchat"))
                {
                    if (args.length == 0)
                    {
                        BSR_PlayerData userinfo = BSR_PlayerData.getPlayerData(p);
                        userinfo.setAdminChat(!userinfo.inAdminChat());
                        p.sendMessage(ChatColor.GRAY + "Toggled Staff Chat " + (userinfo.inAdminChat() ? "on" : "off") + ".");
                        return true;
                    }
                    else
                    {
                        BSR_Util.adminChatMessage(sender, BSR_Util.colorise(StringUtils.join(args, " ")));
                        return true;
                    }
                }
                else
                {
                    return true;
                }
            }
            else
            {
                if (args.length == 0)
                {
                    sender.sendMessage("Only in-game players can toggle admin chat.");
                    return true;
                }
                else
                {
                    BSR_Util.adminChatMessage(sender, BSR_Util.colorise(StringUtils.join(args, " ")));
                    return true;
                }
            }
    }
    }
