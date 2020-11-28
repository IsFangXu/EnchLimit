package yamlfile;

import java.io.File;

public interface FileSection {

    void load();
    void loadForm(File file);
    void loadForm(String file);

    void save();
    void saveForm(File file);
    void saveForm(String file);


}
