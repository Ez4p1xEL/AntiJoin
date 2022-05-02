package p1xel.antijoin;

import org.bukkit.ChatColor;

public class Config {

    public static String getString(String path) {
        return AntiJoin.getInstance().getConfig().getString(path);
    }

    public static String getMessage(String path) {
        return ChatColor.translateAlternateColorCodes('&', getString(path));
    }

    public static boolean getBool(String path) {
        return AntiJoin.getInstance().getConfig().getBoolean(path);
    }


}
