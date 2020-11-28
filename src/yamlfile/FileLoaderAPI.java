package yamlfile;

import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;

public interface FileLoaderAPI extends FileSection, ConfigSection {

    File getFile();
    FileConfiguration getConfiguration();

}
