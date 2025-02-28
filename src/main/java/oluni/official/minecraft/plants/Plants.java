package oluni.official.minecraft.plants;

import oluni.official.minecraft.plants.command.Reload;
import oluni.official.minecraft.plants.listeners.ClickListener;
import oluni.official.minecraft.plants.manager.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Plants extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        reloadConfig();
        ConfigManager.setupConfig(this);
        Bukkit.getPluginManager().registerEvents(new ClickListener(), this);
        Objects.requireNonNull(getCommand("plants")).setExecutor(new Reload(this));
        Objects.requireNonNull(getCommand("plants")).setTabCompleter(new Reload(this));
    }
}
