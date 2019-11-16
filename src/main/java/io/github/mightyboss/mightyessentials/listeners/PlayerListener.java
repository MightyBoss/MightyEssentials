package io.github.mightyboss.mightyessentials.listeners;

import io.github.mightyboss.mightyessentials.MightyEssentials;
import org.bukkit.*;
import org.bukkit.block.*;
import org.bukkit.block.data.BlockData;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

public class PlayerListener implements Listener {
    private MightyEssentials plugin;

    public PlayerListener(MightyEssentials pl){
        plugin = pl;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        Server server = Bukkit.getServer();

        //server.broadcastMessage(plugin.lang.get("blockBreak"));
        server.broadcastMessage(event.getBlock().getBlockData().getAsString());
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event){
        if (MightyEssentials.editModePlayers.contains(event.getPlayer().getUniqueId())){
            if (event.getBlock() == null) return;


        }
    }

}
