package org.CookieGFX.BackstabRandomness;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BSR_Log
{
    private static final Logger logger = Logger.getLogger("Minecraft-Server");

    private BSR_Log()
    {
        throw new AssertionError();
    }

    
    public static void info(String message)
    {
        BSR_Log.info(message, false);
    }
    
    private static void log(Level level, String message, boolean raw)
    {
        logger.log(level, (raw ? "" : "[StormingMC]: ") + message);
    }


    public static void info(String message, boolean raw)
    {
        BSR_Log.log(Level.INFO, message, raw);
    }

    public static void warning(String message)
    {
        BSR_Log.info(message, false);
    }

    public static void warning(String message, boolean raw)
    {
        BSR_Log.log(Level.WARNING, message, raw);
    }

    public static void severe(String message)
    {
        BSR_Log.info(message, false);
    }

    public static void severe(String message, boolean raw)
    {
        BSR_Log.log(Level.SEVERE, message, raw);
    }

    public static void severe(Throwable ex)
    {
        logger.log(Level.SEVERE, null, ex);
    }
}