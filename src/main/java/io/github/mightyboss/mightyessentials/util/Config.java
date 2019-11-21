package io.github.mightyboss.mightyessentials.util;

import io.github.mightyboss.mightyessentials.MightyEssentials;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Config {
    private final MightyEssentials plugin;
    private FileConfiguration config;

    public Config(MightyEssentials pl){
        plugin = pl;
    }


    private void LoadConfig(){
        File file = new File(plugin.getDataFolder(), "config.yml");
        if (!file.exists()){
            plugin.getLogger().info("No config found.");
        }
        else {
            try {
                config = YamlConfiguration.loadConfiguration(file);
            }
            catch (Exception e){
                e.printStackTrace();
                config = null;
            }
        }
    }
    private void NewConfig(File file){
        config = new YamlConfiguration();
        config.set("debug", false);
    }

}
