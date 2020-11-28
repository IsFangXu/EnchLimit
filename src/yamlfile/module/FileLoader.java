package yamlfile.module;

import main.Main;
import yamlfile.FileLoaderAPI;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;

public class FileLoader<T extends Main> extends ConfigModule<T> implements FileLoaderAPI {

    public FileLoader(T plugin, String path, String file, boolean newFile, boolean replace) {
        super(plugin, path, file, newFile, replace);
    }

    @Override
    public File getFile() {
        return this.file;
    }

    @Override
    public FileConfiguration getConfiguration() {
        return this.configuration;
    }
}
