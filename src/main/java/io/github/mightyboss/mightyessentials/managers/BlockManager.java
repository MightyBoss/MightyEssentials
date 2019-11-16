package io.github.mightyboss.mightyessentials.managers;

import io.github.mightyboss.mightyessentials.MightyEssentials;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.logging.Logger;

public class BlockManager {
    private File file;
    private FileConfiguration customBlocks;
    private Logger log;
    private MightyEssentials plugin;
    private static int nextInt = 1;

    public BlockManager(MightyEssentials pl){
        plugin = pl;
        customBlockFile();
    }

    public void customBlockFile(){
        file = new File(plugin.getDataFolder(), File.separator + "data" + File.separator + "customblocks.yml");
        if (!file.exists()){
            try {
                File dataFolder = new File(plugin.getDataFolder(), "data");
                dataFolder.mkdirs();
                file.createNewFile();
            } catch (Exception e)
            {
                log.info("Failed to create customblocks file.");
            }
        }
        customBlocks = YamlConfiguration.loadConfiguration(file);
    }

    public void addBlock(Block b){
        customBlocks.createSection("customBlocks");
        //customBlocks.set("customBlocks." + nextInt + "." + b.getType().toString() + b.getData(),);
    }
}
