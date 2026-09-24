package xitssunny.pingdisplay.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiPlayerTabOverlay;
import net.minecraft.client.network.NetworkPlayerInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiPlayerTabOverlay.class)
public class GuiPlayerTabOverlayMixin extends Gui {

	@Inject(method = "drawPing", at = @At("HEAD"), cancellable = true)
	private void onDrawPing(int i, int j, int k, NetworkPlayerInfo networkPlayerInfoIn, CallbackInfo ci) {
		ci.cancel();

		int ping = networkPlayerInfoIn.getResponseTime();
		String pingText = ping + "ms";

		String colorCode = "\u00a7a";
		if (ping >= 150 && ping < 300) {
			colorCode = "\u00a7e";
		} else if (ping >= 300) {
			colorCode = "\u00a7c";
		}

		Minecraft mc = Minecraft.getMinecraft();
		int xPos = j + i - 2 - mc.fontRendererObj.getStringWidth(pingText);
		mc.fontRendererObj.drawStringWithShadow(colorCode + pingText, xPos, k, 16777215);
	}
}
