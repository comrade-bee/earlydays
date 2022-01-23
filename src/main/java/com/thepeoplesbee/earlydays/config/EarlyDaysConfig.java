package com.thepeoplesbee.earlydays.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

//CODE USED UNDER THE MIT LICENSE FROM EARLYGAME https://github.com/JayCeeCreates/earlygame

@Config(name = "earlydays")
public class EarlyDaysConfig implements ConfigData{

    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Gui.Tooltip(count = 5)
    public Crafting crafting = new Crafting();

    public static final class Crafting implements ConfigData {
        @ConfigEntry.Gui.Tooltip(count = 4)
        public boolean enableVanillaTools = false;

        @ConfigEntry.Gui.Tooltip(count = 4)
        public boolean enablePlanksAndSticks = false;

        private Crafting() {}
    }
}
