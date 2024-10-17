package net.felsstudio.mellands.listeners;

import net.felsstudio.mellands.Mellands;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Date;

public class QuitListener implements Listener {
    final Mellands plugin;

    public QuitListener(Mellands plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        plugin.getConfig().set(e.getPlayer().getName(), new Date());
        plugin.saveConfig();
    }
}
