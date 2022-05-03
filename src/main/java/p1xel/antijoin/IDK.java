package p1xel.antijoin;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class IDK {

    public static void createIDKFile() {

        File file = new File(AntiJoin.getInstance().getDataFolder(), "idk.yml");

        if (!file.exists()) {

            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            set("AntiJoin", false);

        }

    }

    public static FileConfiguration get() {
        File file = new File(AntiJoin.getInstance().getDataFolder(), "idk.yml");
        return YamlConfiguration.loadConfiguration(file);
    }

    public static void set(String path, Object value) {
        File file = new File(AntiJoin.getInstance().getDataFolder(), "idk.yml");
        FileConfiguration yaml = YamlConfiguration.loadConfiguration(file);
        yaml.set(path,value);
        try {
            yaml.save(file);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static boolean getAntiJoin() {
        return get().getBoolean("AntiJoin");
    }

    public static void setAntiJoin(boolean bool) {
        set("AntiJoin", bool);
    }

}
