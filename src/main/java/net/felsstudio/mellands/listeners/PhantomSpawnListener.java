package net.felsstudio.mellands.listeners;

import net.felsstudio.mellands.Mellands;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class PhantomSpawnListener implements Listener {
    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        if (event.getEntityType() == EntityType.PHANTOM) {
            if(!Mellands.isPhantomSpawn){
                event.setCancelled(true);
            }
        }
    }
}
