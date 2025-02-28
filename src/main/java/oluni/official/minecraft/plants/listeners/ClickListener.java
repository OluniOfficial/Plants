package oluni.official.minecraft.plants.listeners;

import oluni.official.minecraft.plants.manager.ConfigManager;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import java.util.List;

public class ClickListener implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        if (ConfigManager.getPermissionEnable()) {
            if (!e.getPlayer().hasPermission("plants.interact")) {
                e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigManager.getAccessMessage()));
                return;
            }
        }
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getClickedBlock() != null) {
                if (e.getClickedBlock().getType() == Material.WHEAT || e.getClickedBlock().getType() == Material.POTATOES || e.getClickedBlock().getType() == Material.CARROTS || e.getClickedBlock().getType() == Material.BEETROOTS) {
                    Ageable age = (Ageable) e.getClickedBlock().getBlockData();
                    if (age.getAge() == age.getMaximumAge()) {
                        e.getClickedBlock().breakNaturally();
                        e.getClickedBlock().setType(e.getClickedBlock().getType());
                        age.setAge(0);
                        e.getClickedBlock().setBlockData(age);
                    }
                }
                if (e.getClickedBlock().getType() == Material.WHEAT || e.getClickedBlock().getType() == Material.POTATOES || e.getClickedBlock().getType() == Material.CARROTS || e.getClickedBlock().getType() == Material.BEETROOTS) {
                    List<String> itemTypes = ConfigManager.itemList();
                    if (e.getItem() != null && itemTypes.contains(e.getItem().getType().name())) {
                        if (e.getItem().hasItemMeta() && e.getItem().getItemMeta().hasCustomModelData()) {
                            if (e.getItem().getItemMeta().getCustomModelData() == ConfigManager.getCustomModelData()) {
                                Location pl = e.getClickedBlock().getLocation();
                                int px = pl.getBlockX();
                                int py = pl.getBlockY();
                                int pz = pl.getBlockZ();
                                for (int x = -1; x <= 1; x++) {
                                    for (int z = -1; z <= 1; z++) {
                                        Block b = e.getPlayer().getWorld().getBlockAt(px + x, py, pz + z);
                                        if (b.getType() == Material.WHEAT || b.getType() == Material.POTATOES || b.getType() == Material.CARROTS || b.getType() == Material.BEETROOTS) {
                                            Ageable a = (Ageable) b.getBlockData();
                                            if (a.getAge() == a.getMaximumAge()) {
                                                b.breakNaturally();
                                                b.setType(b.getType());
                                                a.setAge(0);
                                                b.setBlockData(a);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
