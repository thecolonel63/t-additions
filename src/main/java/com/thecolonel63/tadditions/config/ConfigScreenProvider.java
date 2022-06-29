package com.thecolonel63.tadditions.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import net.minecraft.text.Text;

public class ConfigScreenProvider implements ModMenuApi {
    public static ConfigBuilder builder() {
        ConfigBuilder configBuilder = ConfigBuilder.create().setTitle(Text.translatable("key.category.tadditions")).setEditable(true).setSavingRunnable(ModConfig::writeJson);

        ConfigCategory main = configBuilder.getOrCreateCategory(Text.translatable("tadditions.config.main"));

        main.addEntry(configBuilder.entryBuilder().startBooleanToggle(Text.translatable("tadditions.replacegive"), ModConfig.INSTANCE.replaceGive).setDefaultValue(false).setTooltip(Text.translatable("tadditions.config.replacegive")).setSaveConsumer(va1 -> ModConfig.INSTANCE.replaceGive = va1).build());

        return configBuilder;
    }

    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> builder().setParentScreen(parent).build();
    }
}
