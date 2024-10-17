package net.felsstudio.mellands.commands;

import net.felsstudio.mellands.Mellands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class lastOnline implements CommandExecutor {
    private final Mellands plugin;

    public lastOnline(Mellands plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {//lastonline MrNullYT

        try{
            if (sender instanceof Player) {
                Player p = (Player) sender;

                p.sendMessage((String) plugin.getConfig().get(args[0]));
            } else {
                sender.sendMessage(plugin.getConfig().get(args[0]).toString());
            }
        }catch (Exception e) {
            sender.sendMessage("Not found player "+args[0]);
        }

        plugin.saveConfig();

        return true;
    }
}
