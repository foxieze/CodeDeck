package eu.rowlinson.jonah.codeDeck;

// Java Imports
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// Project Imports
import static eu.rowlinson.jonah.codeDeck.Main.getBCGUI;
import static eu.rowlinson.jonah.codeDeck.Main.getGui;
import static eu.rowlinson.jonah.codeDeck.FileUtils.getFileExtension;

public class BuildAndRun {

    protected static Map<String, String> extensionToType = setExtensionTypeMap();
    // HashMap to convert file extension to file type

    public static void buildRun(File file) {
        System.out.println("HM" + extensionToType);
        String fileType = extensionToType.get(getFileExtension(file));
        System.out.println("FT:" + fileType);
        String buildCommand = getBCGUI().executors.get(fileType);
        if (fileType == null && buildCommand == null) {
            JOptionPane.showMessageDialog(
                    getGui().getFrame(), // Parent Component
                    "We do not support this file type yet!");
        }
        else {
            String command = buildCommand.replace( // Replace %f with absolute path surrounded in quotes
                    "%f", "\"" + file.getAbsolutePath() + "\"");
            System.out.println("RBC: " + command);
            runSystemCommand(command);
        }
    }

    // Run a system command
    public static void runSystemCommand(String command) {

        try {
            Runtime.getRuntime().exec("cmd.exe /c cd \"C:/Windows/System32\" & start cmd.exe /c \"" + command + "\" ^& pause");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    // Create hashmap for extension to type
    private static Map<String, String> setExtensionTypeMap() {
        Map<String, String> map = new HashMap<>();
        map.put("py","python");
        map.put("pyw","python");
        map.put("html", "html");
        map.put("htm", "html");
        return map;
    }
}
