package yamlfile.module;

import java.io.File;
import java.io.IOException;

import main.Main;
import yamlfile.FileSection;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

public class FileModule<T extends Main> extends MemoryModule<T> implements FileSection {

    public FileModule (T plugin, String path, String file, boolean newFile, boolean replace) {
        super(plugin, path, file);

        if (! this.file.exists()) {
            try {
                if (newFile) {
                    this.file.createNewFile();
                    System.out.println(ChatColor.DARK_GREEN + "檔案創建成功！");
                } else {
                    try {
                        plugin.saveResource(file, replace);
                    } catch (IllegalArgumentException e) {
                        System.out.println(ChatColor.RED + "檔案創建失敗..");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.load();
    }

    @Override
    public void load () {
        this.configuration = YamlConfiguration.loadConfiguration(this.file);
    }

    @Override
    public void loadForm (File file) {
        this.file = file;
        this.load();
    }

    @Override
    public void loadForm (String file) {
        this.file = new File(file);
        this.load();
    }

    @Override
    public void save () {
        try {
            this.configuration.save(this.file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveForm (File file) {
        try {
            this.configuration.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveForm (String file) {
        try {
            this.configuration.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
