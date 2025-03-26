package ui;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

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
    private Button btnSave; 
    private ArrayList<JButton> blist;
    private ArrayList<JButton> fbList;
    private ArrayList<String> bstrings;
    private ArrayList<String> fbStrings;

    //Modifies: this 
    //Effects Creates a new GUIHandler object and sets up the GUI
    public GuiHandler(TamaHandler tamaHandler) {
        this.tamaHandler = tamaHandler;
        frame = new JFrame("Tama Info");
        panel = new JPanel();
        textField = new JTextArea();
        scroll = new JScrollPane(textField);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        imageIcon = new ImageIcon("./data/image.png");
        image = imageIcon.getImage().getScaledInstance(500, 400, Image.SCALE_SMOOTH);
        resizedIcon = new ImageIcon(image);
        label = new JLabel(resizedIcon);
        panel.add(label);
        frame.getContentPane().add(BorderLayout.SOUTH, label);
        label.setVisible(false);
        blist = new ArrayList<>();
        fbList = new ArrayList<>();
        buttonSetterUpper();
    }

    //Modifies: This
    //Effects: Sets up all of the buttons for the GUI:
    private void buttonSetterUpper() {
        bstrings = new ArrayList<>(Arrays.asList("SAVE", "LOAD", "PLAY", "FEED", "STATS",
                "DISPLAY ALL", "DISPLAY PLAY", "DISPLAY FEED"));
        fbStrings = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5"));
        getScroll();
        for (String curr : bstrings) {
            btnMaker(curr, blist);
        }
        for (String curr : fbStrings) {
            btnMaker(curr, fbList);
        }
        for (JButton curr : fbList) {
            curr.setVisible(false);
        }
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
    //Effects: Creates all of the buttons for the GUI
    private void btnMaker(String type, ArrayList<JButton> temp) {
        JButton btnTemp = new JButton(type);
        btnTemp.setActionCommand(type);
        btnTemp.addActionListener(this);
        panel.add(btnTemp);
        temp.add(btnTemp);
    }


    //Effects: This methods listens for button clicks and responds with the corresponding action
    @SuppressWarnings("methodlength")
    public void actionPerformed(ActionEvent e) {
        label.setVisible(false);
        if (e.getActionCommand().equals("SAVE")) {
            label.setVisible(true);
            textField.setText("TamaPet Saved");
            tamaHandler.saveTamaPet();
        }
        if (e.getActionCommand().equals("LOAD")) {
            textField.setText("TamaPet Loaded");
            tamaHandler.loadTamaPet();
        }
        if (e.getActionCommand().equals("DISPLAY ALL")) {
            getDisplayAll();
        }
        if (e.getActionCommand().equals("DISPLAY FEED")) {
            getFeed();
        }
        if (e.getActionCommand().equals("DISPLAY PLAY")) {
            getPlay();
        }
        if (e.getActionCommand().equals("FEED")) {
            getDisplayFoods();

        }
        if (e.getActionCommand().equals("PLAY")) {
            getPlayAction(); 
        }
        if (e.getActionCommand().equals("STATS")) {
            getStats();
        }
        if (e.getActionCommand().equals("0")) {
            getFeedAction(0);
            resetButtons();
        }
        if (e.getActionCommand().equals("1")) {
            getFeedAction(1);
            resetButtons();
        }
        if (e.getActionCommand().equals("2")) {
            getFeedAction(2);
            resetButtons();
        }
        if (e.getActionCommand().equals("3")) {
            getFeedAction(3);
            resetButtons();
        }
        if (e.getActionCommand().equals("4")) {
            getFeedAction(4);
            resetButtons();
        }
        if (e.getActionCommand().equals("5")) {
            getFeedAction(5);
            resetButtons();
        }
    }

    //Effects: Feeds the tama pet the specified food item
    private void getFeedAction(int index) {
        FoodMenu tempmenu = new FoodMenu();
        tamaHandler.getTamaPet().tamaFeed(tempmenu.getTamaFood(index));
        tamaHandler.getTamaDrawer().clear();
        tamaHandler.getTamaDrawer().printTamaEmotion(tamaHandler.getTamaPet());
        tamaHandler.getTamaPet().getHistoryLog().newTamaHistory("Feed", index);
    }

    //Effects: Displays the TamaPets stats to the GUI
    private void getStats() {
        textField.setText("Satiation: " + tamaHandler.getTamaPet().getSatiation() + " | "
                + "Happiness " + tamaHandler.getTamaPet().getHappieness());
    }

    //Modifies: This
    //Effects: Plays with the tama pet and prints the relevent information
    private void getPlayAction() {
        textField.setText("You Played With The TamaPet");
        boolean curr = tamaHandler.getTamaPet().tamaPlay();
        if (curr) {
            tamaHandler.getTamaPet().getHistoryLog().newTamaHistory("Play", -1);
            tamaHandler.getTamaDrawer().clear();
            tamaHandler.getTamaDrawer().printTamaEmotion(tamaHandler.getTamaPet());
            System.out.println("You sucessfully played with the tama pet");
            textField.setText("You sucessfully played with the tama pet");
        } else if (!curr) {
            tamaHandler.getTamaDrawer().clear();
            tamaHandler.getTamaDrawer().printTamaEmotion(tamaHandler.getTamaPet());
            System.out.println("The TamaPet does not have enough satiation to play");
            textField.setText("The TamaPet does not have enough satiation to play");
        }
    }

    //Modifies: This
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

    //Modifies: This
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

    //Modifies: This
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

    //Modifies: This
    //Effects: Prints all of the events in the historylog to the GUI
    private void getDisplayFoods() {
        FoodMenu foodmenu = new FoodMenu();
        String curr = "";
        for (int i = 0; i < foodmenu.getsize(); i++) {
            curr += i + ". " + foodmenu.getTamaFood(i).getName() + "\n";
            curr += "Happiness: " + foodmenu.getTamaFood(i).getHappieness() + "\n";
            curr += "Nutrition: " + foodmenu.getTamaFood(i).getNutrition() + "\n";
            curr += "\n";
        }
        curr += "Select the number you would like \n";
        textField.setText(curr);
        for (JButton temp : blist) {
            temp.setVisible(false);
        }
        for (JButton temp : fbList) {
            temp.setVisible(true);
        }
    }

    //Modifies: This
    //Effects: Returns the GUI back to the normal buttons after a feedig event
    private void resetButtons() {
        for (JButton temp : fbList) {
            temp.setVisible(false);
        }
        for (JButton temp : blist) {
            temp.setVisible(true);
        }
        textField.setText("You successfully played with a TamaPet");
    }
}