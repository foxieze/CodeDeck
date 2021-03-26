package eu.rowlinson.jonah.betterCodeEditor;

import com.formdev.flatlaf.FlatDarkLaf;

public class Main {

    private static GUI gui;

    public static void main(String args[]) {
        FlatDarkLaf.install();

        gui = new GUI();
        gui.getFrame().setVisible(true);
    }

    public static GUI getGui() {
        return gui;
    }
}
