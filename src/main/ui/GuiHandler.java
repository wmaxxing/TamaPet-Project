package ui;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// The GUI handler class handles the GUI for the TamaHandler Class 

public class GuiHandler implements ActionListener {
   
    private TamaHandler tamaHandler;
    private JFrame frame;
    private JPanel panel;
    private JTextArea  textField;
    private JScrollPane scroll;
    private ImageIcon imageIcon;
    private JLabel label;
    private Image image;
    private ImageIcon resizedIcon; 

    //Modifies: this 
    //Effects Creates a new GUIHandler object and sets up the GUI
    public GuiHandler(TamaHandler tamaHandler) {
        this.tamaHandler = tamaHandler;
        frame = new JFrame("Tama Info");
        panel = new JPanel();
        textField = new JTextArea();
        scroll = new JScrollPane(textField);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        imageIcon = new ImageIcon("./data/image.png");
        image = imageIcon.getImage().getScaledInstance(500, 400, Image.SCALE_SMOOTH);
        resizedIcon = new ImageIcon(image);
        label = new JLabel(resizedIcon);
        panel.add(label);
        frame.getContentPane().add(BorderLayout.SOUTH, label);
        label.setVisible(false);
        getBtnSave();
        getBtnLoad();
        getBtnDisplayAll();
        getBtnFeed();
        getBtnPlay();
        getScroll();
    }

    //Modifies: This
    //Effects: Creates the text box and scroll bar in the middle of the window for displaying info
    private void getScroll() {
        textField.setText("hello world");
        textField.setEditable(false);
        panel.add(scroll);
        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER, scroll); 
        frame.setVisible(true);
    }

    //Modifies: This
    //Effects: Creates the Save button and associated functionality
    private void getBtnSave() {
        JButton btnSave = new JButton("SAVE");
        btnSave.setActionCommand("SAVE");
        btnSave.addActionListener(this);
        panel.add(btnSave);
    }

    //Modifies: This
    //Effects: Creates the Load button and associated functionality
    private void getBtnLoad() {
        JButton btnLoad = new JButton("LOAD");
        btnLoad.setActionCommand("LOAD");
        btnLoad.addActionListener(this);
        panel.add(btnLoad);
    }

    //Modifies: This
    //Effects: Creates the DisplayAll button and associated functionality
    private void getBtnDisplayAll() {
        JButton btnDisplayAll = new JButton("DISPLAY ALL");
        btnDisplayAll.setActionCommand("DISPLAY ALL");
        btnDisplayAll.addActionListener(this);
        panel.add(btnDisplayAll);
    }

    //Modifies: This
    //Effects: Creates the Feed button and associated functionality
    private void getBtnFeed() {
        JButton btnFeed = new JButton("FEED");
        btnFeed.setActionCommand("FEED");
        btnFeed.addActionListener(this);
        panel.add(btnFeed);
    }

    //Modifies: This
    //Effects: Creates the Play button and associated functionality
    private void getBtnPlay() {
        JButton btnPlay = new JButton("PLAY");
        btnPlay.setActionCommand("PLAY");
        btnPlay.addActionListener(this);
        panel.add(btnPlay);
    }

    //Effects: This methods listens for button clicks and responds with the corresponding action
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("SAVE")) {
            label.setVisible(true);
            textField.setText("TamaPet Saved");
            tamaHandler.saveTamaPet();
        }
        if (e.getActionCommand().equals("LOAD")) {
            label.setVisible(false);
            textField.setText("TamaPet Loaded");
            tamaHandler.loadTamaPet();
        }
        if (e.getActionCommand().equals("DISPLAY ALL")) {
            label.setVisible(false);
            getDisplayAll();
        }
        if (e.getActionCommand().equals("FEED")) {
            label.setVisible(false);
            getFeed();
        }
        if (e.getActionCommand().equals("PLAY")) {
            label.setVisible(false);
            getPlay();
        }
    }

    //Effects: Prints all of the Play events in the historylog to the GUI
    private void getPlay() {
        HistoryLog historylog = tamaHandler.getHistoryLog();
        String curr = "";
        for (int i = 0; i < historylog.getSize(); i++) {
            if (historylog.getTamaHistory(i).getName().equalsIgnoreCase("PLAY")) {
                curr += i + ". " + historylog.getTamaHistory(i).getName() + "\n";
                curr += "Description: " + historylog.getTamaHistory(i).getDesc() + "\n";
                curr += "Date and Time: " + historylog.getTamaHistory(i).getDateAndTime() + "\n" + "\n";
            }
        }
        textField.setText(curr);
    }

    //Effects: Prints all of the FEED events in the historylog to the GUI
    private void getFeed() {
        HistoryLog historylog = tamaHandler.getHistoryLog();
        String curr = "";
        for (int i = 0; i < historylog.getSize(); i++) {
            if (historylog.getTamaHistory(i).getName().equalsIgnoreCase("FEED")) {
                curr += i + ". " + historylog.getTamaHistory(i).getName() + "\n";
                curr += "Description: " + historylog.getTamaHistory(i).getDesc() + "\n";
                curr += "Date and Time: " + historylog.getTamaHistory(i).getDateAndTime() + "\n" + "\n";
            }
        }
        textField.setText(curr);
    }

    //Effects: Prints all of the events in the historylog to the GUI
    private void getDisplayAll() {
        HistoryLog historylog = tamaHandler.getHistoryLog();
        String curr = "";
        for (int i = 0; i < historylog.getSize(); i++) {
            curr += i + ". " + historylog.getTamaHistory(i).getName() + "\n";
            curr += "Description: " + historylog.getTamaHistory(i).getDesc() + "\n";
            curr += "Date and Time: " + historylog.getTamaHistory(i).getDateAndTime() + "\n" + "\n";
        }
        textField.setText(curr);
    }
}