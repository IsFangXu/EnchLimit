package yamlfile;

import java.util.List;

import org.bukkit.Color;

public interface ConfigSection {

    void addDefault(String path, Object object);

    void set(String path, Object object);

    boolean contains(String path);

    Object get(String path);

    boolean getBoolean(String path);
    double getDouble(String path);
    int getInt(String path);
    Color getColor(String path);
    String getString(String path);

    List<Boolean> getBooleanList(String path);
    List<String> getStringList(String path);
    List<Byte> getByteList(String path);
    List<Double> getDoubleList(String path);
    List<Float> getFloatList(String path);
    List<Integer> getIntegerList(String path);

}
