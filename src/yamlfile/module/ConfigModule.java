package yamlfile.module;

import java.util.List;

import main.Main;
import yamlfile.ConfigSection;
import org.bukkit.Color;

public class ConfigModule<T extends Main> extends FileModule<T> implements ConfigSection {

    public ConfigModule(T plugin, String path, String file, boolean newFile, boolean replace) {
        super(plugin, path, file, newFile, replace);
    }

    @Override
    public void addDefault(String path, Object object) {
        this.configuration.addDefault(path, object);
    }

    @Override
    public void set(String path, Object object) {
        this.configuration.set(path, object);
    }

    @Override
    public boolean contains(String path) {
        return this.configuration.contains(path);
    }

    @Override
    public Object get(String path) {
        return this.configuration.get(path);
    }

    @Override
    public boolean getBoolean(String path) {
        return this.configuration.getBoolean(path);
    }

    @Override
    public double getDouble(String path) {
        return this.configuration.getDouble(path);
    }

    @Override
    public int getInt(String path) {
        return this.configuration.getInt(path);
    }

    @Override
    public Color getColor(String path) {
        return this.configuration.getColor(path);
    }

    @Override
    public String getString(String path) {
        return this.configuration.getString(path);
    }

    @Override
    public List<Boolean> getBooleanList(String path) {
        return this.configuration.getBooleanList(path);
    }

    @Override
    public List<String> getStringList(String path) {
        return this.configuration.getStringList(path);
    }

    @Override
    public List<Byte> getByteList(String path) {
        return this.configuration.getByteList(path);
    }

    @Override
    public List<Double> getDoubleList(String path) {
        return this.configuration.getDoubleList(path);
    }

    @Override
    public List<Float> getFloatList(String path) {
        return this.configuration.getFloatList(path);
    }

    @Override
    public List<Integer> getIntegerList(String path) {
        return this.configuration.getIntegerList(path);
    }

}
