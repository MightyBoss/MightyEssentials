package io.github.mightyboss.mightyessentials;

import io.github.mightyboss.mightyessentials.commands.CommandTest;
import io.github.mightyboss.mightyessentials.listeners.PlayerListener;
import io.github.mightyboss.mightyessentials.managers.BlockManager;
import io.github.mightyboss.mightyessentials.util.Config;
import io.github.mightyboss.mightyessentials.util.Lang;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MightyEssentials extends JavaPlugin implements Listener {
    private BlockManager blockManager;

    public Lang lang;
    public Config config;
    public static List<UUID> editModePlayers = new ArrayList<>();

    public CommandTest CommandTest;

    @Override
    public void onEnable() {
        config = new Config(this);
        lang = new Lang(this);
        blockManager = new BlockManager(this);

        this.getCommand("test").setExecutor(new CommandTest(this));

        getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
    }


    @Override
    public void onDisable() {

    }

}
