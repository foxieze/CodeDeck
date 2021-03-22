package eu.rowlinson.jonah.betterCodeEditor;

public class Main {

    private static GUI gui;

    public static void main(String args[]) {
        gui = new GUI();
        gui.getFrame().setVisible(true);
    }

    public static GUI getGui() {
        return gui;
    }
}
