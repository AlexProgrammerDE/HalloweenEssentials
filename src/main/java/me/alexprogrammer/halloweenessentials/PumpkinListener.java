package me.alexprogrammer.halloweenessentials;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.concurrent.ThreadLocalRandom;

public class PumpkinListener implements Listener {
    HalloweenEssentials plugin;

    public PumpkinListener(HalloweenEssentials plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPumpkinClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (player.getInventory().getItemInMainHand().getType() == Material.PUMPKIN) {
                player.getInventory().setItemInMainHand(null);

                player.sendMessage("Here is a small surprise for you: ");

                getSurprise(player);
            }
        }
    }

    private void getSurprise(Player player) {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 12 + 1);
        ItemStack surprise;
        ItemMeta meta;

        switch (randomNum) {
            case 1:
                surprise = new ItemStack(Material.END_CRYSTAL, 5);
                meta = surprise.getItemMeta();
                meta.setDisplayName("Chocolate bars");
                surprise.setItemMeta(meta);
                player.getWorld().dropItemNaturally(player.getLocation(), surprise);
                player.sendMessage("Chocolate bars! ;)");

                break;
            case 2:
                surprise = new ItemStack(Material.GOLDEN_APPLE, 5, (short)1);
                meta = surprise.getItemMeta();
                meta.setDisplayName("Yellow candy");
                surprise.setItemMeta(meta);
                player.getWorld().dropItemNaturally(player.getLocation(), surprise);
                player.sendMessage("Yellow candy! ;)");

                break;
            case 3:
                player.getWorld().spawnEntity(player.getLocation(), EntityType.PRIMED_TNT);
                player.getWorld().spawnEntity(player.getLocation(), EntityType.PRIMED_TNT);
                player.getWorld().spawnEntity(player.getLocation(), EntityType.PRIMED_TNT);
                player.sendMessage("Zzzzzzzzzzzz! ;)");

                break;
            case 4:
                player.getWorld().spigot().strikeLightning(player.getLocation(), false);
                player.sendMessage("Zeus hates you! ;)");

                break;
            case 5:
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10 * 20, 3, true, true));
                player.sendMessage("Speed! ;)");

                break;
            case 6:
                player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 3 * 20, 3, true, true));
                player.sendMessage("Red bull! ;)");

                break;
            case 7:
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10 * 20, 3, true, true));
                player.sendMessage("RIP speed! ;)");

                break;
            case 8:
                player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 10 * 20, 3, true, true));
                player.sendMessage("Your a disco ball now! ;)");

                break;
            case 9:
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 10 * 20, 3, true, true));
                player.sendMessage("Kangaroo! ;)");

                break;
            case 10:
                player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 10 * 20, 3, true, true));
                player.sendMessage("Your the devil now! ;)");

                break;
            case 11:
                player.getWorld().setThundering(!player.getWorld().isThundering());
                player.sendMessage("Maybe a thunder will catch you! ;)");

                break;
            case 12:
                player.getWorld().setStorm(!player.getWorld().hasStorm());
                player.sendMessage("uwu halloween + storm! ;)");

                break;
            default:
                throw new IllegalStateException("Unexpected value: " + randomNum);
        }
    }
}
