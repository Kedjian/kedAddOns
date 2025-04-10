package net.ked.tutorialmod.item.staffs;

import net.minecraft.client.particle.DragonBreathParticle;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.behavior.MeleeAttack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.damagesource.DamageSources; // For access to predefined types
import net.minecraft.world.damagesource.DamageType;    // For custom types
import org.intellij.lang.annotations.MagicConstant;


import java.util.Random;

public class FireStaff extends Item {

    public FireStaff(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide) {
            Vec3 start = player.getEyePosition(1.0F);
            Vec3 look = player.getLookAngle();
            Vec3 end = start.add(look.scale(30)); // 10 block range

            // Ray trace for entities
            EntityHitResult hitResult = ProjectileUtil.getEntityHitResult(
                    level, player, start, end, player.getBoundingBox().expandTowards(look.scale(10)).inflate(1.0),
                    e -> !e.isSpectator() && e.isPickable() && e != player
            );


            BlockState blockState = Blocks.YELLOW_STAINED_GLASS_PANE.defaultBlockState(); // Or any block you want
            BlockParticleOption blockParticles = new BlockParticleOption(ParticleTypes.BLOCK, blockState);

            // Spawn flame particles along the path
            for (int i = 0; i < 50; i++) {
                double t = i / 50.0;
                Vec3 point = start.add(look.scale(t * 50));
                ((ServerLevel) level).sendParticles(blockParticles, point.x, point.y, point.z, 20, 0.2, 0.2, 0.2, 0.07);
            }

            player.getCooldowns().addCooldown(this, 50);
        }

        return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), level.isClientSide());
    }
}
