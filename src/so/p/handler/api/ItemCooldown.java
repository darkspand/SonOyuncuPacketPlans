package so.p.handler.api;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import so.p.handler.utils.SendCPay;

public class ItemCooldown {

    public ItemCooldown(Player player, Material material, long time) {


        @SuppressWarnings("deprecation")
        String meth = "itemcooldown###" + material.getId() + "###" + time;


        new SendCPay(player, "Teyyap", meth).send();


    }

}
