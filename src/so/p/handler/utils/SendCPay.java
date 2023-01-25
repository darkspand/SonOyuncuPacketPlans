package so.p.handler.utils;

import io.netty.buffer.Unpooled;
import net.minecraft.server.v1_8_R3.PacketDataSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutCustomPayload;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class SendCPay {

    private final Player player;
    private final String ch;
    private final String meth;
    public SendCPay(Player player, String ch, String meth) {
        this.player = player;
        this.ch = ch;
        this.meth = meth;
    }

    public void send() {

        final ByteArrayOutputStream stream = new ByteArrayOutputStream();
        final DataOutputStream output = new DataOutputStream(stream);

        try {
            output.writeUTF(meth);
        } catch (IOException ignored) {}

        final PacketDataSerializer serializer = new PacketDataSerializer(Unpooled.wrappedBuffer(stream.toByteArray()));
        final PacketPlayOutCustomPayload pay = new PacketPlayOutCustomPayload(ch, serializer);

        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(pay);
    }

}
