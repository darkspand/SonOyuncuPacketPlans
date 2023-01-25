package so.p.handler;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import so.p.handler.commands.CMD;

public class Core extends JavaPlugin implements Listener {


    public void onEnable() {


        getCommand("sophandler").setExecutor(new CMD());

        this.setEnabled(true);
        getLogger().info("This plugin's feature only work on s0n0yuncu client!");
        getLogger().info("If you don't try stealing S0 NETWORK'S BREAD, Don't use this!");
        getLogger().info("This plugin enabled and will be used for another plugin.");
        getLogger().info("Some features can will be added on req!");
    }



}
