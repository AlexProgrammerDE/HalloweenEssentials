package me.alexprogrammer.halloweenessentials;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.ShulkerBox;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
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
                if (player.getInventory().getItemInMainHand().getAmount() == 1) {
                    player.getInventory().setItemInMainHand(null);
                } else {
                    player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                }

                player.sendMessage("Here is a small surprise for you: ");

                getSurprise(player);
            }
        }
    }

    private void getSurprise(Player player) {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 25 + 1);
        ItemStack surprise;
        ItemMeta meta;

        switch (randomNum) {
            case 1:
                surprise = new ItemStack(Material.END_CRYSTAL, 5);
                meta = surprise.getItemMeta();
                meta.setDisplayName("Chocolate bars");
                surprise.setItemMeta(meta);
                player.getWorld().dropItemNaturally(player.getLocation(), surprise);
                player.sendMessage(ChatColor.GOLD + "Chocolate bars! ;)");

                break;
            case 2:
                surprise = new ItemStack(Material.GOLDEN_APPLE, 5, (short)1);
                meta = surprise.getItemMeta();
                meta.setDisplayName("Yellow candy");
                surprise.setItemMeta(meta);
                player.getWorld().dropItemNaturally(player.getLocation(), surprise);
                player.sendMessage(ChatColor.GOLD + "Yellow candy! ;)");

                break;
            case 3:
                player.getWorld().spawnEntity(player.getLocation(), EntityType.PRIMED_TNT);
                player.getWorld().spawnEntity(player.getLocation(), EntityType.PRIMED_TNT);
                player.getWorld().spawnEntity(player.getLocation(), EntityType.PRIMED_TNT);
                player.sendMessage(ChatColor.GOLD + "Zzzzzzzzzzzz! ;)");

                break;
            case 4:
                player.getWorld().spigot().strikeLightning(player.getLocation(), false);
                player.sendMessage(ChatColor.GOLD + "Zeus hates you! ;)");

                break;
            case 5:
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10 * 20, 3, true, true));
                player.sendMessage(ChatColor.GOLD + "Your on speed now! ;)");

                break;
            case 6:
                player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 3 * 20, 3, true, true));
                player.sendMessage(ChatColor.GOLD + "Red bull! ;)");

                break;
            case 7:
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10 * 20, 3, true, true));
                player.sendMessage(ChatColor.GOLD + "RIP speed! ;)");

                break;
            case 8:
                player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 10 * 20, 3, true, true));
                player.sendMessage(ChatColor.GOLD + "Your a disco ball now! ;)");

                break;
            case 9:
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 10 * 20, 3, true, true));
                player.sendMessage(ChatColor.GOLD + "Kangaroo! ;)");

                break;
            case 10:
                player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 10 * 20, 3, true, true));
                player.sendMessage(ChatColor.GOLD + "Your the devil now! ;)");

                break;
            case 11:
                player.getWorld().setThundering(!player.getWorld().isThundering());
                player.sendMessage(ChatColor.GOLD + "Maybe a thunder will catch you! ;)");

                break;
            case 12:
                player.getWorld().setStorm(!player.getWorld().hasStorm());
                player.sendMessage(ChatColor.GOLD + "uwu halloween + storm! ;)");

                break;
            case 13:
                Witch witch = (Witch) player.getWorld().spawnEntity(player.getLocation(), EntityType.WITCH);

                witch.setCustomName("Hermione");
                witch.setCustomNameVisible(true);

                player.sendMessage(ChatColor.GOLD + "Did you read harry potter yet? ;)");

                break;
            case 14:
                Skeleton skeleton = (Skeleton) player.getWorld().spawnEntity(player.getLocation(), EntityType.SKELETON);

                skeleton.setCustomName("Spooky scary skeleton");
                skeleton.setCustomNameVisible(true);

                player.sendMessage(ChatColor.GOLD + "U know this song? ;)");

                break;
            case 15:
                Zombie zombie = (Zombie) player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);

                zombie.setCustomName("Frankenstein's Monster");
                zombie.setCustomNameVisible(true);

                player.sendMessage(ChatColor.GOLD + "Did you know most people think its real name is Frankenstein? ;)");

                break;
            case 16:
                Wolf wolf = (Wolf) player.getWorld().spawnEntity(player.getLocation(), EntityType.WOLF);

                wolf.setCustomName(player.getName() + "'s buddy");
                wolf.setCustomNameVisible(true);
                wolf.setOwner(player);

                player.sendMessage(ChatColor.GOLD + "You may need a friend for this spooky time! ;)");

                break;
            case 17:
                player.giveExpLevels(1);

                player.sendMessage(ChatColor.GOLD + "Here is some green candy! ;)");

                break;
            case 18:
                surprise = new ItemStack(Material.TOTEM, 1);
                meta = surprise.getItemMeta();
                meta.setDisplayName("Voodoo doll");
                surprise.setItemMeta(meta);
                player.getWorld().dropItemNaturally(player.getLocation(), surprise);
                player.sendMessage(ChatColor.GOLD + "Voodoo doll! ;)");

                break;
            case 19:
                ItemStack cookie = new ItemStack(Material.COOKIE);
                ItemMeta cookieMeta = cookie.getItemMeta();
                cookieMeta.setDisplayName("Delicious cookie");
                cookie.setItemMeta(cookieMeta);

                surprise = new ItemStack(Material.BLACK_SHULKER_BOX, 1);

                BlockStateMeta shulkerMeta = (BlockStateMeta) surprise.getItemMeta();
                ShulkerBox box = (ShulkerBox) shulkerMeta.getBlockState();
                Inventory inventory = box.getInventory();

                shulkerMeta.setDisplayName("Candy bag");

                for (int i = 0; i < 27; i++) {
                    inventory.setItem(i, cookie.clone());
                }

                box.update();

                shulkerMeta.setBlockState(box);

                surprise.setItemMeta(shulkerMeta);

                player.getWorld().dropItemNaturally(player.getLocation(), surprise);
                player.sendMessage(ChatColor.GOLD + "Candy bag! ;)");

                break;
            case 20:
                Blaze blaze = (Blaze) player.getWorld().spawnEntity(player.getLocation(), EntityType.BLAZE);

                blaze.setCustomName("Devils slave");
                blaze.setCustomNameVisible(true);

                player.sendMessage(ChatColor.GOLD + "Directly from the hell! ;)");

                break;
            case 21:
                surprise = new ItemStack(Material.LEATHER_HELMET, 1);
                meta = surprise.getItemMeta();
                meta.setDisplayName("Witch hat");
                surprise.setItemMeta(meta);
                player.getWorld().dropItemNaturally(player.getLocation(), surprise);
                player.sendMessage(ChatColor.GOLD + "Witch hat! ;)");

                break;
            case 22:
                surprise = new ItemStack(Material.IRON_HELMET, 1);
                meta = surprise.getItemMeta();
                meta.setDisplayName("Dracula hat");
                surprise.setItemMeta(meta);
                player.getWorld().dropItemNaturally(player.getLocation(), surprise);
                player.sendMessage(ChatColor.GOLD + "Dracula hat! ;)");

                break;
            case 23:
                surprise = new ItemStack(Material.GOLD_HELMET, 1);
                meta = surprise.getItemMeta();
                meta.setDisplayName("Mummy hat");
                surprise.setItemMeta(meta);
                player.getWorld().dropItemNaturally(player.getLocation(), surprise);
                player.sendMessage(ChatColor.GOLD + "Mummy hat! ;)");

                break;
            case 24:
                surprise = new ItemStack(Material.DIAMOND_HELMET, 1);
                meta = surprise.getItemMeta();
                meta.setDisplayName("Pumpkin hat");
                surprise.setItemMeta(meta);
                player.getWorld().dropItemNaturally(player.getLocation(), surprise);
                player.sendMessage(ChatColor.GOLD + "Pumpkin hat! ;)");

                break;
            case 25:
                surprise = new ItemStack(Material.COOKIE, 1);
                meta = surprise.getItemMeta();
                meta.setDisplayName("Tasty cookie");
                surprise.setItemMeta(meta);
                player.getWorld().dropItemNaturally(player.getLocation(), surprise);
                player.sendMessage(ChatColor.GOLD + "Tasty cookie! ;)");

                break;
            default:
                throw new IllegalStateException("Unexpected value: " + randomNum);
        }
    }
}
