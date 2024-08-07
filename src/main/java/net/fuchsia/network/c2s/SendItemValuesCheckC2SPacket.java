package net.fuchsia.network.c2s;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fuchsia.Faden;
import net.fuchsia.network.FadenNetwork;
import net.fuchsia.util.FadenCheckSum;
import net.fuchsia.util.FadenIdentifier;
import net.fuchsia.util.NetworkUtils;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;

public record SendItemValuesCheckC2SPacket(String checksum) implements CustomPayload {

    public static final CustomPayload.Id<SendItemValuesCheckC2SPacket> ID = new CustomPayload.Id<>(FadenIdentifier.create("send_item_values"));
    public static final PacketCodec<RegistryByteBuf, SendItemValuesCheckC2SPacket> CODEC = new PacketCodec<>() {
        @Override
        public SendItemValuesCheckC2SPacket decode(RegistryByteBuf buf) {
            return new SendItemValuesCheckC2SPacket(buf.readString());
        }

        @Override
        public void encode(RegistryByteBuf buf, SendItemValuesCheckC2SPacket value) {
           buf.writeString(value.checksum);
        }
    };

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }

    public void receive(ServerPlayNetworking.Context context) {
        String serverChecksum = FadenCheckSum.checkSum(Faden.GSON.toJson(NetworkUtils.trimItemValueMap()));
        if(!checksum.equalsIgnoreCase(serverChecksum)) {
            Faden.LOGGER.debug("Updated Item Values for {} due to mismatched Checksum", context.player().getName());
            FadenNetwork.Server.sendItemValues(context.player());
        }
    }
}
