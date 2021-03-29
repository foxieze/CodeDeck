package eu.rowlinson.jonah.codeDeck;

import java.io.File;

public class FileUtils {
    public static String getFileExtension(File openFile) {
        String path = openFile.getAbsolutePath();
        return path.substring(path.lastIndexOf('.') + 1);
    }
}
