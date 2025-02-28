package oluni.official.minecraft.plants.manager;

import oluni.official.minecraft.plants.Plants;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class ConfigManager {
    private static FileConfiguration cfg;
    public static void setupConfig(Plants plants) {
        ConfigManager.cfg = plants.getConfig();
        plants.saveConfig();
    }
    public static void reloadConfig(Plants plants) {
        plants.reloadConfig();
        ConfigManager.cfg = plants.getConfig();
    }
    public static int getCustomModelData() {
        return cfg.getInt("custom-model-data", 500);
    }
    public static List<String> itemList() {
        return cfg.getStringList("items-list");
    }
    public static boolean getPermissionEnable() {
        return cfg.getBoolean("permission-enable", false);
    }
    public static String getAccessMessage() {
        return cfg.getString("no-access-message", "&c[✘ | Plants] → You dont have access to this action!");
    }
}
