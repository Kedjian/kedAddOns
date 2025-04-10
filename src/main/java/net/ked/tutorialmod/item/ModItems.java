package net.ked.tutorialmod.item;

import net.ked.tutorialmod.KedMod;
import net.ked.tutorialmod.item.custom.ChiselItem;
import net.ked.tutorialmod.item.staffs.FireStaff;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, KedMod.MOD_ID);

    public static final RegistryObject<Item> CEDROANDRITE = ITEMS.register("cedroandrite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(50)));

    public static final RegistryObject<Item> FIRESTAFF = ITEMS.register("firestaff",
            () -> new FireStaff(new Item.Properties().durability(50)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
