package net.ked.tutorialmod.item;

import net.ked.tutorialmod.KedMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, KedMod.MOD_ID);

    public static final RegistryObject<Item> KEDANDRYT = ITEMS.register("kedandryt",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REFANDRYT = ITEMS.register("refandryt",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DADOSZANDRYT = ITEMS.register("dadoszandryt",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KAROANDRYT = ITEMS.register("karoandryt",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CEDROANDRYT = ITEMS.register("cedroandryt",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
