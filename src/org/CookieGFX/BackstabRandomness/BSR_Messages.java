package org.CookieGFX.BackstabRandomness;

import org.bukkit.ChatColor;

public class BSR_Messages {
   public static final String UNKNOWN_COMMAND = ChatColor.RESET + "Unknown command. Type \"help\" for help.";
   public static final String NO_PREMS = ChatColor.DARK_RED + "You don't have the required permissions to execute this command.";
   public static final String USAGE = ChatColor.GRAY + "The proper usage for this command is: ";
   public static final String TAG_MOD = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "BackstabRandomness" + ChatColor.DARK_GRAY + "] ";
   public static final String NO_PLAYER = ChatColor.RED + "That username cannot be found. Ensure your spelling is correct.";
   public static final String CANNOT_LOAD_BANS = "Could not load player ban: {0}!";
   public static final String BANS_MESSAGE = " {0} bans";
   public static final String LOADED = "Loaded";
   public static final String SAVED = "Saved";
   public static final String REMOVE_OLD_BANS = "Removing expired ban: {0}";
   public static final String BAN_GET_ERROR = "Sorry! " + ChatColor.AQUA + "There was a problem checking if you were banned.\n";
   public static final String APPEALAT_MESSAGE = "Please report this issue at";
   public static final String SPECIFY_REASON = ChatColor.DARK_RED + "You have not specified a valid reason.  Please, try again";
   public static final String ALREADY_BANNED = ChatColor.DARK_RED + "The player has already been banned - Sorry :)";
   public static final String PLAYER_NOT_FOUND = "The player you have entered cannot be found. Please check that the spelling is correct and the player is online.";
   public static final String CANNOT_KICK_PLAYER = ChatColor.DARK_RED + "You cannot kick this player. Please contact a host.";
   public static final String CANNOT_CHECK_BANS = "Problem checking ban status for {0}";
}
