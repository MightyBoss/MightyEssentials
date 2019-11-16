package io.github.mightyboss.mightyessentials;

import io.github.mightyboss.mightyessentials.listeners.PlayerListener;
import io.github.mightyboss.mightyessentials.managers.BlockManager;
import io.github.mightyboss.mightyessentials.util.CommandBase;
import io.github.mightyboss.mightyessentials.util.Lang;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MightyEssentials extends JavaPlugin implements Listener {
    private BlockManager blockManager;

    public Lang lang;
    public static List<UUID> editModePlayers = new ArrayList<>();

    FileConfiguration config = getConfig();
    PlayerListener pl = new PlayerListener(this);

    @Override
    public void onEnable() {
        config.addDefault("isTrue", true);
        config.options().copyDefaults(true);
        saveConfig();

        lang = new Lang(this);
        blockManager = new BlockManager(this);

        CommandBase.registerCommands(this);

        getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
    }


    @Override
    public void onDisable() {

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if(config.getBoolean("isTrue")) {
            player.sendMessage("You muda");
        } else {
            player.sendMessage("not true");
        }
    }

    @EventHandler
    public void AsyncPlayerChatEvent(AsyncPlayerChatEvent event) {
        if (event.getMessage().equals("T"))
            event.setMessage("Spic");
        else
            event.setCancelled(true);
    }

    @EventHandler
    public void Enchanter(InventoryOpenEvent e){
        Player player = (Player) e.getPlayer();

        if (e.getInventory().getType() == InventoryType.ENCHANTING) {
            player.sendMessage("Enchant");
        }

    }

}
