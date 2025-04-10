package net.ked.tutorialmod.item;

import net.ked.tutorialmod.KedMod;
import net.ked.tutorialmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, KedMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> KED_ADD_ONS = CREATIVE_MODE_TABS.register("ked_add_ons",
            () -> CreativeModeTab.builder().icon( () -> new ItemStack(ModItems.CEDROANDRITE.get()))
                    .title(Component.translatable("creativetab.kedmod.ked_add_ons"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.CEDROANDRITE_BLOCK.get());
                        output.accept(ModBlocks.KEDOANDRITE_BLOCK.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
