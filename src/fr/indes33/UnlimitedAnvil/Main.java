package fr.indes33.UnlimitedAnvil;

import fr.indes33.UnlimitedAnvil.Events.AnvilEvents;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Le plugin \"UnlimitedAnvil\" vient de s'allumer");
        getServer().getPluginManager().registerEvents(new AnvilEvents(), this);
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_PURPLE + "Le plugin \"UnlimitedAnvil\" vient de s'arreter");
    }
}