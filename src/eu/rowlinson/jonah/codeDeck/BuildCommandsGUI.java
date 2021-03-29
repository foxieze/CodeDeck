package eu.rowlinson.jonah.codeDeck;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class BuildCommandsGUI {
    private JFrame frame;
    public Map<String, String> executors = new HashMap<>();

    // Executioners
    private JTextField pythonField;
    private JTextField htmlField;

    public BuildCommandsGUI(EventListener listener) {
        FlatDarkLaf.install();

        // Top Text
        JLabel notice = new JLabel("Note: Use %f to input file path.");
        notice.setBorder(BorderFactory.createEmptyBorder(15, 0,15,0));
        notice.setHorizontalAlignment(JLabel.CENTER);

        GridLayout layout = new GridLayout(0,2);
        layout.setVgap(20);
        this.frame = new JFrame("Build / Run Commands");
        this.frame.setSize(500,225);
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10,0,10,10));
        panel.setLayout(layout);

        // Python
        JLabel pythonLabel = new JLabel("Python: ");
        pythonLabel.setHorizontalAlignment(JLabel.CENTER);
        pythonField = new JTextField();
        panel.add(pythonLabel);
        panel.add(pythonField);

        // HTML
        JLabel htmlLabel = new JLabel("HTML: ");
        htmlLabel.setHorizontalAlignment(JLabel.CENTER);
        htmlField = new JTextField();
        panel.add(htmlLabel);
        panel.add(htmlField);

        JPanel confirmPanel = new JPanel();
        JButton okButton = new JButton("OK");
        okButton.setActionCommand("BC OK Button");
        okButton.addActionListener(listener);
        confirmPanel.add(okButton);


        frame.getContentPane().add(BorderLayout.NORTH, notice);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, confirmPanel);
    }

    public void confirmCommands() {
        executors.put("python", pythonField.getText());
        executors.put("html", htmlField.getText());
    }

    public JFrame getFrame() { return this.frame; }
}
