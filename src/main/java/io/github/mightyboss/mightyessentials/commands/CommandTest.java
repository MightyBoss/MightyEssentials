package io.github.mightyboss.mightyessentials.commands;

import io.github.mightyboss.mightyessentials.util.CommandBase;
import org.apache.commons.lang.ObjectUtils;
import org.bukkit.*;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.Block;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.block.data.BlockData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.entity.*;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.*;
import org.bukkit.map.MapView;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.util.Vector;
import org.w3c.dom.events.Event;

import java.net.InetSocketAddress;
import java.util.*;

public class CommandTest extends CommandBase {

    public CommandTest(){
        super("test", "test.use", true);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 0){
            Player player = (Player) sender;
            Location loc = player.getLocation();

            sender.sendMessage("X: " + Double.toString(loc.getBlockX()) + "Y: " + Double.toString(loc.getBlockY()) + "Z: " + Double.toString(loc.getBlockZ()));
        }
        else if (args[0].equalsIgnoreCase("nig")){
            sender.sendMessage("you are a niger!");
        }
        else;


    }
}
