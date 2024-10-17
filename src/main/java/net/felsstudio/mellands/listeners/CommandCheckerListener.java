package net.felsstudio.mellands.listeners;

import net.felsstudio.mellands.Mellands;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.io.*;
import java.util.Date;
import java.util.List;

public class CommandCheckerListener implements Listener {
    private final Mellands plugin;

    public CommandCheckerListener(Mellands plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) throws IOException {
        List<String> coms = plugin.getConfig().getStringList("cmds");
        coms.add("[ "+e.getPlayer().getName()+" ] "+"&!& [ "+e.getMessage()+" ] "+" ( "+new Date()+" )");
        plugin.getConfig().set("cmds", coms);

        File cmds = new File(plugin.getDataFolder(), "cmds.txt");

        if(!cmds.exists()){
            cmds.createNewFile();
        }

        StringBuffer sb = new StringBuffer();
        try(BufferedReader br = new BufferedReader(new FileReader(cmds))) {
            int ch;
            do{
                ch = br.read();

                sb.append((char)ch);

            }while(ch != -1);
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(cmds))) {
            bw.write(sb.toString()+"\n");
            bw.write("[ "+e.getPlayer().getName()+" ] "+"&!& [ "+e.getMessage()+" ] "+" ( "+new Date()+" )");
        }
    }
}
