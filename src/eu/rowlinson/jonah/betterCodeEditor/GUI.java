package eu.rowlinson.jonah.betterCodeEditor;

import javax.swing.*;
import java.awt.*;
class GUI {
    private JFrame frame;
    private JMenuBar menubar;
    private JMenu filemenu;
    private JMenuItem savemenu;
    private JPanel taskpane;
    private JButton fontUp;

    public void createGUI() {
        this.frame = new JFrame("CodeDeck");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(900, 800);

        // Menu bar at top (eg. file, edit)
        this.menubar = new JMenuBar();
        this.filemenu = new JMenu("File");
        this.savemenu = new JMenuItem("Save");
        this.filemenu.add(savemenu);
        this.menubar.add(filemenu);

        // Header
        this.taskpane = new JPanel();
        this.fontUp = new JButton("Font Up");
        this.taskpane.add(fontUp);


        // Text Area at the Center
        JTextArea ta = new JTextArea();
        JScrollPane tascroll = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        ta.setFont(new Font("Courier New", Font.PLAIN, 16));
        frame.add(tascroll);

        frame.setJMenuBar(menubar);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.getContentPane().add(BorderLayout.NORTH, taskpane);
        // frame.setVisible(true);
    }

    public JFrame getFrame() {
        return this.frame;
    }


}