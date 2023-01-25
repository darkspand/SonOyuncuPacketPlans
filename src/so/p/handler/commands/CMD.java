package so.p.handler.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import so.p.handler.api.ItemCooldown;
import so.p.handler.api.ShutDown;

@SuppressWarnings("deprecation")
public class CMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {


        if (!sender.hasPermission("sophandler.op4")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&4YOU DON'T HAVE PERMISSION FOR TO DO THIS!"));
            return true;
        }



        if (args.length < 1) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&2AVAILABLE &a<itemcooldown, shutdown>"));
            return true;
        }


        if (args[0].equalsIgnoreCase("shutdown")) {
            if (args.length != 2) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        "&6USAGE &e/sophandler shutdown <target_player>"));
                return true;
            }


            Player player = Bukkit.getPlayer(args[1]);
            if (player == null) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        "&4ERROR TARGET PLAYER NOT ONLINE!"));
                return true;
            }

            new ShutDown(player);
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&dIF PLAYER USING SOCLIENT: PLAYER WILL BE SHUTDOWN!"));

            return true;
        }

        if (args[0].equalsIgnoreCase("itemcooldown")) {
            if (args.length != 4) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        "&6USAGE &e/sophandler itemcooldown <target_player> <materialID> <time>"));
                return true;
            }

            Player player = Bukkit.getPlayer(args[1]);
            if (player == null) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        "&4ERROR TARGET PLAYER NOT ONLINE!"));
                return true;
            }
            Material material;
            long time;
            try {
                int mId = Integer.parseInt(args[2]);
                material = Material.getMaterial(mId);
                if (material == null) throw new NullPointerException();
                time = Long.parseLong(args[3]);
            } catch (Exception ignored) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        "&4ERROR BAD INPUTS"));
                return true;
            }



            new ItemCooldown(player, material, time);
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    "&dIF PLAYER USING SOCLIENT: PLAYER WILL SEE COOLDOWN ANIM IN OWN INV!"));

            return true;

        }


        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                "&2AVAILABLE &a<itemcooldown, shutdown>"));
        return true;
    }

}
