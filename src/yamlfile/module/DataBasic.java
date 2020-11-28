package yamlfile.module;

import main.Main;

public class DataBasic<T extends Main> extends FileLoader<Main> {
    private String pathlString = "";

    public DataBasic(T plugin, String path, String file) {
        super(plugin, path, file, true, false);
        this.setPath(path);
    }

    public void setPath(String path) { this.pathlString = path; }
    public String getPath() { return this.pathlString; }
}
