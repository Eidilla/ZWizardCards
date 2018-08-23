package dev.eidilla.marauderwc;

import dev.eidilla.marauderwc.commands.WCCommands;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class MarauderWC extends JavaPlugin {

    private WCCommands commands = new WCCommands();

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "\n\nMarauder: Wizard Cards, has been enabled\n\n");

        getCommand(commands.cmdmain).setExecutor(commands);

        loadConfig();
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "\n\nMarauder: Wizard Cards, has been disabled\n\n");
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}
