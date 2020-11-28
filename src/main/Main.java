package main;

import yamlfile.ConfigManager;
import yamlfile.FileLoaderAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main extends JavaPlugin {
    private static Main plugin;
    private static String prefix;
    private static FileLoaderAPI config = null;
    private static FileLoaderAPI log = null;

    @Override
    public void onEnable () {
        plugin = this;
        prefix = "[" + plugin.getName() + "] ";
        System.out.println(prefix + ChatColor.GREEN + "Loading..");

        onReload();
        runTheCodeRepeatedly();

        System.out.println(prefix + ChatColor.GREEN + "Loaded!");
    }

    @Override
    public void onDisable () {
        System.out.println(prefix + ChatColor.RED + "Unloaded!");
    }

    public static Main getPlugin () {
        return plugin;
    }

    public static FileLoaderAPI getConfigFile () {
        return config;
    }

    public void onReload () {
        this.regConfigYaml();
    }

    private void regConfigYaml () {
        Main.config = ConfigManager.getFileLoaderAPI(this, "\\", "config.yml", false);
    }

    private void runTheCodeRepeatedly () {
        int TimeToTicks = 1200;

        int Interval = getConfigFile().getInt("Settings.Interval");
        getServer().getScheduler().scheduleSyncRepeatingTask(getPlugin(), new RunTheCodeRepeatedly(), Interval * TimeToTicks, Interval * TimeToTicks);
    }

    class RunTheCodeRepeatedly implements Runnable {
        @Override
        public void run () {
            List<Player> players = (List<Player>) plugin.getServer().getOnlinePlayers();
            for (Player player : players) {
                if (player.hasPermission("enchlimit.admin")) return;
                List<ItemStack> itemStacks = Arrays.asList(player.getInventory().getContents());
                for (ItemStack itemStack : itemStacks) {
                    if (! (itemStack == null)) {
                        List<Integer> enchLevels = (List<Integer>) itemStack.getEnchantments().values();
                        for (Integer enchlevel : enchLevels) {
                            if (enchlevel > 5) {
                                player.getInventory().remove(itemStack);
                                player.sendMessage(prefix + getConfigFile().getString("Settings.Message").replace('&', ChatColor.COLOR_CHAR));
                                if (getConfigFile().getBoolean("Settings.Record")) {
                                    Main.log = ConfigManager.getFileLoaderAPI(getPlugin(), "\\", "log.yml", false);

                                    SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
                                    Date date = new Date();
                                    String strDate = sdFormat.format(date);

                                    List<String> logs = log.getStringList("Logger");
                                    logs.add("時間: " + strDate + " - " + "玩家: " + player.getName() + " - " + "物品類型: " + itemStack.getType().name());
                                    log.set("Logger", logs);
                                    log.save();
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
