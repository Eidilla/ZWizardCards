package dev.eidilla.marauderwc.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;

public class CardBase implements Listener {

    private ItemStack card_wss;
    String cn_wss;

    public HashMap<String, ItemStack> cardDB = new HashMap<>();

    public void makeCardWSS() {
        card_wss = new ItemStack(Material.SEEDS, 1);
        cn_wss = "Salazar_Slytherin";
        ItemMeta card_wss_meta = card_wss.getItemMeta();

        card_wss_meta.setDisplayName(ChatColor.GOLD + "Card: " + ChatColor.DARK_GREEN + "Salazar Slytherin");
        ArrayList<String> card_wss_lore = new ArrayList<String>();
        card_wss_lore.add(ChatColor.DARK_GRAY + "Type: " + ChatColor.DARK_GREEN + "Wizard");
        card_wss_lore.add(ChatColor.DARK_GRAY + "Rarity: " + ChatColor.DARK_GREEN + "Fabled");
        card_wss_lore.add(ChatColor.DARK_GRAY + "Description: " + ChatColor.DARK_GREEN + "A wizard known for his cunning and determination.");
        card_wss_lore.add(ChatColor.DARK_GREEN + "One of the four founders of Hogwarts.");
        card_wss_lore.add(ChatColor.DARK_GRAY + "Quote: " + ChatColor.DARK_GREEN + "- We'll teach just those whose ancestry's purest -");
        card_wss_meta.setLore(card_wss_lore);
        card_wss.setItemMeta(card_wss_meta);

        if(!cardDB.values().contains("Salazar_Slytherin")) {
            cardDB.put(cn_wss, card_wss);
        }
    }
}
