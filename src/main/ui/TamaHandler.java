package ui;

import model.*;
import persistance.*;
import java.util.Scanner;

import java.io.FileNotFoundException;
import java.io.IOException;

// The TamaHandler class will handle all input coming from the console and allow the 
public class TamaHandler {

    private GuiHandler gui;
    private static final String JSON_STORE = "./data/tamaPetData.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private boolean isRunning;
    private TamaDrawer tamaDrawer;
    private TamaPet tamaPet;
    private Scanner input;
    private String commands;

    //Modifies: this
    //Effects: Creates a new instance of the TamaHander class
    public TamaHandler() throws FileNotFoundException {
        isRunning = true;
        tamaDrawer = new TamaDrawer();
        input = new Scanner(System.in);
        input.useDelimiter("\r?\n|\r");
        tamaDrawer.clear();
        System.out.println("What would you like to name your TamaPet?");
        String name = null;
        name = input.next();
        gui = new GuiHandler(this);
        tamaPet = new TamaPet(name);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        tamaRunner();
    }

    //Modifies: this
    //Effects: Runs the main loop of the TamaProgram
    public void tamaRunner() {
        tamaDrawer.tamaDefault(tamaPet);

        while (isRunning) {
            commands = input.next();
            commands = commands.toLowerCase();
            processCommands(commands);
        }
    }

    //Modifies: this
    //Effects: handles when the feed input call is made 
    public void functionfeed() {
        tamaDrawer.clear();
        FoodMenu tempmenu = new FoodMenu();
        tamaDrawer.printFoodMenu(tempmenu);
        int index = -1;
        boolean loopindex = true;
        while (loopindex) {
            index = validinput();

            if ((index > tempmenu.getsize() - 1) || (index < 0)) {
                System.out.println("Invalid selection try again");
                continue;
            } else {
                loopindex = false;
            }
        }
        tamaPet.tamaFeed(tempmenu.getTamaFood(index));
        tamaDrawer.clear();
        tamaDrawer.printTamaEmotion(tamaPet);
        tamaPet.addTamaHistory("Feed", index);
    }

    //Modifies: this
    //Effects: handles when the play input call is made
    public void functionPlay() {
        boolean curr = tamaPet.tamaPlay();
        if (curr) {
            tamaPet.addTamaHistory("Play", 0);
            tamaDrawer.clear();
            tamaDrawer.printTamaEmotion(tamaPet);
            System.out.println("You sucessfully played with the tama pet");
        } else if (!curr) {
            tamaDrawer.clear();
            tamaDrawer.printTamaEmotion(tamaPet);
            System.out.println("The TamaPet does not have enough satiation to play");
        } 
    }

    //Effects: handles when the history input call is made
    public void functionHistory() {
        tamaDrawer.clear();
        tamaDrawer.printHistoryLog(tamaPet.getHistoryLog());
        input.next();
        tamaDrawer.printTamaEmotion(tamaPet);
    }

    //Effects; handles printing the stats of the TamaPet
    public void functionStats() {
        tamaDrawer.tamaStats(tamaPet);
        input.next();
        tamaDrawer.clear();
        tamaDrawer.printTamaEmotion(tamaPet);
    }

    //Modifies: this
    //Effects: Processes the incoming command and outputs the desired menu
    private void processCommands(String command) {
        if (command.equals("feed")) {
            functionfeed();
        } else if (command.equals("play")) {
            functionPlay();
        } else if (command.equals("history")) {
            functionHistory();
        } else if (command.equals("save")) {
            saveTamaPet();
        } else if (command.equals("load")) {
            loadTamaPet();
        } else if (command.equals("quit")) {
            tamaDrawer.printLoggedEvents();
            isRunning = false;
            System.exit(0);
        } else if (command.equals("stats")) {
            functionStats();
        } else {
            System.out.println("Please Try Another Command (Feed | Play | History | Stats | Save | Load | Quit)");
            commands = input.next();
            commands = commands.toLowerCase();
            processCommands(commands);
        }
    }

    // EFFECTS: saves the TamaPet to a file
    public void saveTamaPet() {
        try {
            jsonWriter.open();
            jsonWriter.write(tamaPet);
            jsonWriter.close();
            System.out.println("Saved " + tamaPet.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads a Tamapet from a file
    public void loadTamaPet() {
        try {
            tamaPet = jsonReader.read();
            tamaDrawer.clear();
            tamaDrawer.printTamaEmotion(tamaPet);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    //Effects: Decides the input is a valid int 
    public int validinput() {
        int index = -1; 
        boolean validInput = false;

        while (!validInput) {
            if (input.hasNextInt()) {
                index = input.nextInt();
                validInput = true;
            } else {
                System.out.println("Invalid selection try again");
                input.next();
            }
        }
        return index; 
    }

    //Effects: Getter for the history log
    public HistoryLog getHistoryLog() {
        return tamaPet.getHistoryLog();
    }

    //Effects: Getter for the TamaPet
    public TamaPet getTamaPet() {
        return tamaPet;
    }

    //Effects: Getter for the TamaDrawer
    public TamaDrawer getTamaDrawer() {
        return tamaDrawer;
    }
}
