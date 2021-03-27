package eu.rowlinson.jonah.codeDeck;

public class Main {

    private static GUI gui;
    private static BuildCommandsGUI BCGUI;

    public static void main(String[] args) {
        // FlatDarkLaf.install();

        EventListener listener = new EventListener();
        gui = new GUI(listener);
        BCGUI = new BuildCommandsGUI(listener);
        gui.getFrame().setVisible(true);
    }

    public static GUI getGui() {
        return gui;
    }

    public static BuildCommandsGUI getBCGUI() {
        return BCGUI;
    }


}
