package io.github.mightyboss.mightyessentials.util;

import io.github.mightyboss.mightyessentials.commands.CommandAdmin;
import io.github.mightyboss.mightyessentials.commands.CommandTest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class CommandBase implements CommandExecutor {
    public static JavaPlugin plugin;
    private final String commandName;
    private final String permission;
    private final boolean canConsoleUse;

    public CommandBase(final String commandName, final String permission, final boolean canConsoleUse){
        this.commandName = commandName;
        this.permission = permission;
        this.canConsoleUse = canConsoleUse;
        plugin.getCommand(commandName).setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!command.getLabel().equalsIgnoreCase(commandName))
            return true;
        if (!commandSender.hasPermission(permission)) {
            commandSender.sendMessage("You don't have permission for this.");
            return true;
        }
        if (!canConsoleUse && !(commandSender instanceof Player)){
            commandSender.sendMessage("Only players may use this command.");
            return true;
        }
        execute(commandSender, args);
        return true;
    }

    public abstract void execute(CommandSender sender, String[] args);

    public final static void registerCommands(JavaPlugin pl){
        plugin = pl;
        new CommandTest();
        new CommandAdmin();
    }


}
