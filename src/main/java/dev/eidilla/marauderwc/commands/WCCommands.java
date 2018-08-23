package dev.eidilla.marauderwc.commands;

import dev.eidilla.marauderwc.items.CardBase;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class WCCommands implements CommandExecutor {

    public String cmdgivecard = "givecard";
    public String cmdmain = "zwc";

    CardBase cardBase = new CardBase();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(command.getName().equalsIgnoreCase(cmdmain)) {
                if(args == null) {
                    player.sendMessage(ChatColor.GOLD + "Hello " + ChatColor.AQUA + player.getName() + ChatColor.GOLD + ", welcome to Zatcast's Wizard Cards Plugin. Type -/help zwc-");
                } else {
                    if(args.length == 0){
                        player.sendMessage(ChatColor.GOLD + "Hello " + ChatColor.AQUA + player.getName() + ChatColor.GOLD + ", welcome to Zatcast's Wizard Cards Plugin. Type -/help zwc-");
                    }
                    else if(args.length == 1) {
                        if(args[0].equalsIgnoreCase("givecard")) {
                            player.sendMessage(ChatColor.GOLD + "/zwc givecard <card>, or /zwc givecard <card> <player> <amount>");
                        } else {
                            player.sendMessage(ChatColor.RED + "That is not a argument for /zwc");
                        }
                    }
                    else if(args.length == 2) {
                        if(args[0].equalsIgnoreCase("givecard")) {
                            if(args[1] != null){
                                cardBase.makeCardWSS();
                                if(cardBase.cardDB.containsKey(args[1])){
                                    player.getInventory().addItem(cardBase.cardDB.get(args[1]));
                                }else{
                                    player.sendMessage(ChatColor.RED + "No card by that name.");
                                }
                            }
                        }
                    }
                }
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Only Players can send this command.");
            return true;
        }
        return true;
    }
}
