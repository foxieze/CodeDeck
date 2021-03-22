package eu.rowlinson.jonah.betterCodeEditor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static eu.rowlinson.jonah.betterCodeEditor.Main.getGui;

public class EventListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        if ((e.getActionCommand()).equals("Font Up")) {
            getGui().fontSize += 1;
            getGui().getTextArea().setFont(new Font("Courier New", Font.PLAIN, getGui().fontSize));
        }
        if ((e.getActionCommand()).equals("Font Down")) {
            getGui().fontSize -= 1;
            getGui().getTextArea().setFont(new Font("Courier New", Font.PLAIN, getGui().fontSize));
        }
    }
}
