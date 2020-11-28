package yamlfile.module;


import main.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class MemoryModule <T extends Main> {
    protected T plugin;
    protected File file;
    protected FileConfiguration configuration;

    public MemoryModule(T plugin, String path, String file) {
        this.plugin = plugin;
        this.buildFilePath(plugin.getDataFolder().toString() + path);
        this.file = new File(plugin.getDataFolder() + path + file);
        this.configuration = new YamlConfiguration();
    }

    protected void buildFilePath(String path) {
        File f = new File(path);
        if(!f.exists()) {
            f.mkdirs();
            System.out.println( "Path build ok!" );
        }
    }
}
