package io.github.mightyboss.mightyessentials.commands;

import io.github.mightyboss.mightyessentials.MightyEssentials;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;

public class CommandTest implements CommandExecutor {
    private MightyEssentials plugin;

    public CommandTest(MightyEssentials pl){
        this.plugin = pl;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0){
            Player player = (Player) sender;
            Location loc = player.getLocation();

            sender.sendMessage("X: " + Double.toString(loc.getBlockX()) + "Y: " + Double.toString(loc.getBlockY()) + "Z: " + Double.toString(loc.getBlockZ()));
        }
        else if (args[0].equalsIgnoreCase("nig")){
            sender.sendMessage(plugin.lang.get("testCommand"));
        }
        else;

        return true;


    }
}
