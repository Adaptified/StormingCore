package org.CookieGFX.BackstabRandomness.Commands;

import net.pravian.bukkitlib.command.BukkitCommand;
import net.pravian.bukkitlib.util.StringUtils;
import org.CookieGFX.BackstabRandomness.BSR_Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_rawsay extends BukkitCommand {

    @Override
    public boolean run(CommandSender sender, Command command, String commandLabel, String[] args) {
        if (sender instanceof Player)
            {
                Player p = (Player) sender;
                if (p.hasPermission("nonamedorg.rawsay"))
                {
                    if (args.length > 0)
                    {
                        BSR_Util.bcastMsg(BSR_Util.colorise(StringUtils.join(args, " ")));
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    return true;
                }
            }
            else
            {
                BSR_Util.bcastMsg(BSR_Util.colorise(StringUtils.join(args, " ")));
                return true;
            }
    }
    
    
}
