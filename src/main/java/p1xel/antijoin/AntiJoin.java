package p1xel.antijoin;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiJoin extends JavaPlugin {

    private static AntiJoin instance;

    public static AntiJoin getInstance() {return instance;}

    public static boolean isAntiJoin = false;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        getConfig().set("Version", getDescription().getVersion());

        getServer().getPluginManager().registerEvents(new Listener(),this);
        getServer().getPluginCommand("AntiJoin").setExecutor(new Cmd());
    }
}
