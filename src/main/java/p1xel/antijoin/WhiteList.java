package p1xel.antijoin;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class WhiteList {

    public static void createWhiteListFile() {

        File file = new File(AntiJoin.getInstance().getDataFolder(), "whitelist.yml");

        if (!file.exists()) {

            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            set("whitelist", Collections.singletonList("s1mple"));

        }

    }

    public static FileConfiguration get() {
        File file = new File(AntiJoin.getInstance().getDataFolder(), "whitelist.yml");
        return YamlConfiguration.loadConfiguration(file);
    }

    public static void set(String path, Object value) {
        File file = new File(AntiJoin.getInstance().getDataFolder(), "whitelist.yml");
        FileConfiguration yaml = YamlConfiguration.loadConfiguration(file);
        yaml.set(path,value);
        try {
            yaml.save(file);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static List<String> getWhiteList() {
        return get().getStringList("whitelist");
    }

    public static void addToList(String name) {
        List<String> wl = getWhiteList();
        wl.add(name);
        set("whitelist", wl);
    }

    public static void delFromList(String name) {
        List<String> wl = getWhiteList();
        wl.remove(name);
        set("whitelist", wl);
    }

    public static void clearList() {
        List<String> wl = getWhiteList();
        wl.clear();
        set("whitelist", wl);
    }

}
