package io.github.mightyboss.mightyessentials.commands;

import io.github.mightyboss.mightyessentials.MightyEssentials;
import io.github.mightyboss.mightyessentials.listeners.PlayerListener;
import io.github.mightyboss.mightyessentials.util.CommandBase;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandAdmin extends CommandBase {

    public CommandAdmin(){
        super("admin", "admin.use", false);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length <= 0){
            sender.sendMessage("Admin base command");
            return;
        }
        if (args[0].equalsIgnoreCase("edit")){
            if (!(sender instanceof Player)) return;
            Player player = (Player)sender;
            if (!MightyEssentials.editModePlayers.contains(player.getUniqueId())){
                MightyEssentials.editModePlayers.add(player.getUniqueId());
                player.sendMessage("Edit mode enabled!");
            }
            else{
                MightyEssentials.editModePlayers.remove(player.getUniqueId());
                player.sendMessage("Edit mode disabled!");
            }
        }
    }
}
