package cafe.ferret.mc.earlydays.init;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import cafe.ferret.mc.earlydays.EarlyDays;
import cafe.ferret.mc.earlydays.client.screen.BasketScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

@SuppressWarnings("deprecation")
public class EarlyDaysScreenHandlers {
    public static ScreenHandlerType<BasketScreenHandler> BASKET_SCREEN_HANDLER;

    public static void register() {
        BASKET_SCREEN_HANDLER =
                ScreenHandlerRegistry.registerSimple(new Identifier(EarlyDays.MODID, "wicker_basket"),
                        BasketScreenHandler::new);
    }
}

/* public class EarlyDaysScreenHandlers {
    public static ScreenHandlerType<BasketScreenHandler> BASKET_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerSimple(new Identifier(EarlyDays.MODID, "wicker_basket"),
            BasketScreenHandler::new);
} */