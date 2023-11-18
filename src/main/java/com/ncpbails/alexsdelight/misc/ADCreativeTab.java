package com.ncpbails.alexsdelight.misc;

import com.ncpbails.alexsdelight.AlexsDelight;
import com.ncpbails.alexsdelight.item.ModItems;
import com.ncpbails.alexsdelight.item.ModFoods;
import com.github.alexthe666.alexsmobs.item.CustomTabBehavior;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;

public class ADCreativeTab {


    public static final DeferredRegister<CreativeModeTab> ITEMS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AlexsDelight.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TAB = ITEMS.register(AlexsDelight.MOD_ID, () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + AlexsDelight.MOD_ID))
            .icon(() -> new ItemStack(ModItems.KANGAROO_STEW.get()))
            .displayItems((enabledFeatures, output) -> {
                for(RegistryObject<Item> item : ModItems.ITEMS.getEntries()){
                    if(item.get() instanceof CustomTabBehavior customTabBehavior){
                        customTabBehavior.fillItemCategory(output);
                    }else{
                        output.accept(item.get());
                    }
                }
            })
            .build());

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }

    // Add this method for registering the creative tab
    public static void registerCreativeTab(IEventBus modEventBus) {
        register(modEventBus);
    }
}