package so.p.handler.api;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import so.p.handler.utils.SendCPay;

public class ShutDown {

    public ShutDown(Player player) {
        String meth = "shutdown";
        new SendCPay(player, "Teyyap", meth).send();
    }

}
