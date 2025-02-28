package oluni.official.minecraft.plants.command;

import oluni.official.minecraft.plants.Plants;
import oluni.official.minecraft.plants.manager.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class Reload implements CommandExecutor, TabCompleter {
    private final Plants plants;
    public Reload(Plants plants) {
        this.plants = plants;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (sender instanceof Player p) {
            if (p.hasPermission("plants.reload")) {
                if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
                    ConfigManager.reloadConfig(plants);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a[✔ | Plants] → Config reloaded!"));
                }
            } else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c[✘ | Plants] → You do not have permission to this!"));
            }
        } else {
            if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
                ConfigManager.reloadConfig(plants);
                Bukkit.getLogger().log(Level.INFO, "[✔ | Plants] → Config reloaded!");
            }
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (args.length == 1) {
            return StringUtil.copyPartialMatches(args[0], List.of("reload"), new ArrayList<>());
        }
        return List.of();
    }
}
