package eu.rowlinson.jonah.codeDeck;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static eu.rowlinson.jonah.codeDeck.Main.getBCGUI;
import static eu.rowlinson.jonah.codeDeck.Main.getGui;

public class EventListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        switch ((e.getActionCommand())) {
            case "Font Up" -> {
                getGui().fontSize += 3;
                getGui().getTextArea().setFont(new Font("Courier New", Font.PLAIN, getGui().fontSize));
            }
            case "Font Down" -> {
                getGui().fontSize -= 3;
                getGui().getTextArea().setFont(new Font("Courier New", Font.PLAIN, getGui().fontSize));
            }
            case "Save Toolbar Button", "Save Menu" -> getGui().saveFile();
            case "Open Toolbar Button" -> getGui().openFile();
            case "New Toolbar Button" -> getGui().newFile();
            case "BC C Button" -> getBCGUI().getFrame().setVisible(true);
            case "BC OK Button" -> getBCGUI().confirmCommands();
        }
    }
}
