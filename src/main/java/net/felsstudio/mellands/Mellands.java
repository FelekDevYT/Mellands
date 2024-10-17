package net.felsstudio.mellands;

import net.felsstudio.mellands.commands.lastOnline;
import net.felsstudio.mellands.listeners.CommandCheckerListener;
import net.felsstudio.mellands.listeners.QuitListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.io.File;

public final class Mellands extends JavaPlugin {
    private File cmdsConfFile;
    private FileConfiguration cmdsConf;

    public static boolean isPhantomSpawn = false;
    private static int dayCount = 0;


    @Override
    public void onEnable() {
        saveDefaultConfig();

        getCommand("lastonline").setExecutor(new lastOnline(this));

        getServer().getPluginManager().registerEvents(new QuitListener(this),this);
        getServer().getPluginManager().registerEvents(new CommandCheckerListener(this),this);

        BukkitScheduler bs = getServer().getScheduler();
        bs.runTaskTimer(this,() -> {
            dayCount++;
            if(dayCount == 8) {
                isPhantomSpawn = true;
            }else if(dayCount == 9) {
                isPhantomSpawn = false;
                dayCount = 0;
            }
        },0,24000);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
