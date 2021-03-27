package eu.rowlinson.jonah.codeDeck;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class GUI {
    private JFrame frame;
    private JTextArea ta;
    public int fontSize = 16;
    private File openFile;
    private String fileExtension;

    final JFileChooser fc = new JFileChooser();

    protected ImageIcon resizeIcon(ImageIcon icon, int w, int h) {
        return new ImageIcon(icon.getImage().getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH));
    }

    protected ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return resizeIcon(new ImageIcon(imgURL), 25, 25);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public GUI(EventListener listener) {

        FlatDarkLaf.install();

        this.frame = new JFrame("CodeDeck");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(900, 800);

        // Menu bar at top (eg. file, edit)
        JMenuBar menubar = new JMenuBar();
        JMenu filemenu = new JMenu("File");
        JMenuItem savemenu = new JMenuItem("Save");
        savemenu.setActionCommand("Save Menu");
        savemenu.addActionListener(listener);
        filemenu.add(savemenu);
        menubar.add(filemenu);
        JMenu projectmenu = new JMenu("Project");
        JMenuItem bcmenuitem = new JMenuItem("Build / Run Commands");
        bcmenuitem.addActionListener(listener);
        bcmenuitem.setActionCommand("BC C Button");
        projectmenu.add(bcmenuitem);
        menubar.add(projectmenu);

        // Header
        JPanel taskpane = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // New Button
        Icon newIcon = createImageIcon("assets/new-icon.png");
        JButton newToolbarButton = new JButton(newIcon);
        newToolbarButton.setPreferredSize(new Dimension(30,30));
        newToolbarButton.addActionListener(listener);
        newToolbarButton.setActionCommand("New Toolbar Button");
        taskpane.add(newToolbarButton);

        // Save Button
        Icon saveIcon = createImageIcon("assets/save-icon.png");
        JButton saveToolbarButton = new JButton(saveIcon);
        saveToolbarButton.setPreferredSize(new Dimension(30,30));
        saveToolbarButton.setActionCommand("Save Toolbar Button");
        saveToolbarButton.addActionListener(listener);
        taskpane.add(saveToolbarButton);

        // Open Button
        Icon openIcon = createImageIcon("assets/open-icon.png");
        JButton openToolbarButton = new JButton(openIcon);
        openToolbarButton.setPreferredSize(new Dimension(30,30));
        openToolbarButton.setActionCommand("Open Toolbar Button");
        openToolbarButton.addActionListener(listener);
        taskpane.add(openToolbarButton);

        // Font Button
        Icon plusIcon = createImageIcon("assets/add-icon.png");
        Icon minusIcon = createImageIcon("assets/minus-icon.png");
        JButton fontUp = new JButton(plusIcon);
        fontUp.addActionListener(listener);
        fontUp.setActionCommand("Font Up");
        fontUp.setPreferredSize(new Dimension(30, 30));
        JButton fontDown = new JButton(minusIcon);
        fontDown.setActionCommand("Font Down");
        fontDown.setPreferredSize(new Dimension(30, 30));
        fontDown.addActionListener(listener);
        taskpane.add(fontDown);
        taskpane.add(fontUp);

        // Build - Run Button
        Icon buildIcon = createImageIcon("assets/run-icon.png");
        JButton buildButton = new JButton(buildIcon);
        buildButton.setPreferredSize(new Dimension(30,30));
        buildButton.addActionListener(listener);
        buildButton.setActionCommand("BC Build Button");
        taskpane.add(buildButton);

        // Text Area at the Center
        this.ta = new JTextArea();
        JScrollPane tascroll = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.ta.setFont(new Font("Courier New", Font.PLAIN, fontSize));
        frame.add(tascroll);

        // Add all items to frame
        frame.setJMenuBar(menubar);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.getContentPane().add(BorderLayout.NORTH, taskpane);

        this.ta.requestFocus();
    }

    public JFrame getFrame() {
        return this.frame;
    }

    public JTextArea getTextArea() {
        return this.ta;
    }

    public void saveFile() {
        String textAreaText = getTextArea().getText();
        if (openFile == null) {
            int returnVal = fc.showSaveDialog(getFrame());
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                String file = fc.getSelectedFile().getAbsolutePath();
                try {
                    FileWriter fw = new FileWriter(file);
                    fw.write(textAreaText);
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        else {
            File file = openFile;
            try {
                FileWriter fw = new FileWriter(file);
                fw.write(textAreaText);
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void openFile() {
        int returnVal = fc.showOpenDialog(getFrame());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            try {
                getTextArea().setText("");
                Scanner fr = new Scanner(file);
                while (fr.hasNextLine()) {
                    String data = fr.nextLine();
                    getTextArea().append(data + "\n");
                }
                openFile = file;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void newFile() {
        getTextArea().setText("");
        openFile = null;
    }

    private void convertFileExtension() {
        String path = openFile.getAbsolutePath();
        fileExtension = path.substring(path.lastIndexOf('.') + 1);
    }

}
