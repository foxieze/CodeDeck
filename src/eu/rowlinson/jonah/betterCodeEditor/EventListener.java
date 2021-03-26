package eu.rowlinson.jonah.betterCodeEditor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static eu.rowlinson.jonah.betterCodeEditor.Main.getGui;

public class EventListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        if ((e.getActionCommand()).equals("Font Up")) {
            getGui().fontSize += 3;
            getGui().getTextArea().setFont(new Font("Courier New", Font.PLAIN, getGui().fontSize));
        }
        else if ((e.getActionCommand()).equals("Font Down")) {
            getGui().fontSize -= 3;
            getGui().getTextArea().setFont(new Font("Courier New", Font.PLAIN, getGui().fontSize));
        }
        else if ((e.getActionCommand()).equals("Save Toolbar Button")) {
            getGui().saveFile();
        }
        else if ((e.getActionCommand()).equals("Open Toolbar Button")) {
            getGui().openFile();
        }
        else if ((e.getActionCommand()).equals("New Toolbar Button")) {
            getGui().newFile();
        }
    }
}
