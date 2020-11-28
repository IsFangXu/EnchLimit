package yamlfile;

import main.Main;
import yamlfile.module.FileLoader;

public class ConfigManager {
    public static <T extends Main> FileLoaderAPI getFileLoaderAPI(T plugin, String path, String file, boolean newFile) {
        return new FileLoader<Main>(plugin, path, file, newFile, false);
    }
}
