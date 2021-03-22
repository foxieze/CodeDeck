package eu.rowlinson.jonah.betterCodeEditor;

import javax.swing.*;
import java.awt.*;
class GUI {
    private JFrame frame;
    private JTextArea ta;
    public int fontSize = 16;

    public GUI() {
        EventListener listener = new EventListener();

        this.frame = new JFrame("CodeDeck");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(900, 800);

        // Menu bar at top (eg. file, edit)
        JMenuBar menubar = new JMenuBar();
        JMenu filemenu = new JMenu("File");
        JMenuItem savemenu = new JMenuItem("Save");
        filemenu.add(savemenu);
        menubar.add(filemenu);

        // Header
        JPanel taskpane = new JPanel();
        JButton fontUp = new JButton("Font Up");
        fontUp.addActionListener(listener);
        JButton fontDown = new JButton("Font Down");
        fontDown.addActionListener(listener);
        taskpane.add(fontDown);
        taskpane.add(fontUp);


        // Text Area at the Center
        this.ta = new JTextArea();
        JScrollPane tascroll = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.ta.setFont(new Font("Courier New", Font.PLAIN, fontSize));
        frame.add(tascroll);

        // Add all items to frame
        frame.setJMenuBar(menubar);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.getContentPane().add(BorderLayout.NORTH, taskpane);
    }

    public JFrame getFrame() {
        return this.frame;
    }

    public JTextArea getTextArea() {
        return this.ta;
    }


}
