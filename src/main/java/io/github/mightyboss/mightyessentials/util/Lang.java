package io.github.mightyboss.mightyessentials.util;

import io.github.mightyboss.mightyessentials.MightyEssentials;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.logging.Logger;

public class Lang {
    private File file;
    private FileConfiguration lang;
    private MightyEssentials plugin;
    private Logger log;

    public Lang(MightyEssentials pl){
        plugin = pl;
        log = plugin.getLogger();

        loadFile();
    }

    public String get(String key){
        return lang.getString(key);
    }

    private void loadFile(){
        file = new File(plugin.getDataFolder(), File.separator + "lang" + File.separator + "messages.yml");
        if (!file.exists()){
            try {
                plugin.saveResource("lang" + File.separator + "messages.yml", true);
            } catch (Exception e)
            {
                log.info("Failed to create Language file.");
            }
        }
        lang = YamlConfiguration.loadConfiguration(file);
    }
}
