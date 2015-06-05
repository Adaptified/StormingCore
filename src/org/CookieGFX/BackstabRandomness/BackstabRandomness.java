package org.CookieGFX.BackstabRandomness;

import net.pravian.bukkitlib.BukkitLib;
import net.pravian.bukkitlib.command.BukkitCommandHandler;
import net.pravian.bukkitlib.config.YamlConfig;
import net.pravian.bukkitlib.implementation.BukkitPlugin;
import net.pravian.bukkitlib.util.ChatUtils;
import net.pravian.bukkitlib.util.PlayerUtils;
import org.CookieGFX.BackstabRandomness.Commands.Command_backstabrandom;
import org.CookieGFX.BackstabRandomness.Listeners.BSR_BlockListener;
import org.CookieGFX.BackstabRandomness.Listeners.BSR_DisguiseListener;
import org.CookieGFX.BackstabRandomness.Listeners.BSR_PlayerListener;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.scheduler.BukkitRunnable;

public class BackstabRandomness extends BukkitPlugin
{

    public String Message;
    private BackstabRandomness plugin;
    public BukkitCommandHandler handler;
    //
    public String pluginName;
    public String pluginVersion;
    public String pluginBuildNumber;
    public String pluginBuildDate;
    public String pluginAuthors;
    //
    public boolean debugMode;
    //
    public YamlConfig mainConfig;
    public YamlConfig bansConfig;
    public YamlConfig likersConfig;
    public YamlConfig topicsConfig;
    public YamlConfig dataFile;


    @Override
    public void onLoad()
    {
        plugin = this;
        this.handler = new BukkitCommandHandler(plugin);

        // Plugin info
        final PluginDescriptionFile pdf = plugin.getDescription();
        pluginName = pdf.getName();
        pluginVersion = pdf.getVersion();
        pluginAuthors = PlayerUtils.concatPlayernames(pdf.getAuthors());

        // Configs
        mainConfig = new YamlConfig(plugin, "config.yml", true);
        bansConfig = new YamlConfig(plugin, "bans.yml", true);
        

        
    }

    @Override
    public void onEnable()
    {
        this.Message = ChatColor.translateAlternateColorCodes("&".charAt(0), this.mainConfig.getString("Message"));
        
        if(!mainConfig.getString("broadcast").equals("")) {
            new BukkitRunnable() {

                @Override
                public void run() {
                    plugin.getServer().broadcastMessage(ChatUtils.colorize(mainConfig.getString("prefix") + mainConfig.getString("broadcast")));
                }
                
            }.runTaskTimer(plugin, 20L, mainConfig.getInt("interval")*20L);
        }
        
        
        // Bukkit Lib Important Stuff
        BukkitLib.init(plugin);
        handler.setCommandLocation(Command_backstabrandom.class.getPackage());
        
        // Load main config
        mainConfig.load();


        // Load other configs
        bansConfig.load();
        likersConfig.load();
        topicsConfig.load();
        dataFile.load();

        // Register events
        final PluginManager pm = plugin.getServer().getPluginManager();
        pm.registerEvents(new BSR_PlayerListener(plugin), plugin);
        pm.registerEvents(new BSR_BlockListener(plugin), plugin);
        pm.registerEvents(new BSR_DisguiseListener(plugin), plugin);
    }

    @Override
    public void onDisable()
    {
        plugin.getServer().getScheduler().cancelTasks(plugin);       
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        return handler.handleCommand(sender, cmd, commandLabel, args);
    }

}