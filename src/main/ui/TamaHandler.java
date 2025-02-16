package ui;

import model.*;
import java.util.Scanner;

// The TamaHandler class will handle all input coming from the console and allow the 
public class TamaHandler {

    private boolean isRunning;
    private TamaDrawer tamaDrawer;
    private TamaPet tamaPet;
    private Scanner input;
    private String commands;

    //Modifies: this
    //Effects: Creates a new instance of the TamaHander class
    public TamaHandler() {
        isRunning = true;
        tamaDrawer = new TamaDrawer();
        input = new Scanner(System.in);
        input.useDelimiter("\r?\n|\r");
        tamaDrawer.clear();
        System.out.println("What would you like to name your TamaPet?");
        String name = null;
        name = input.next();
        tamaPet = new TamaPet(name);
        tamaRunner();
    }

    //Modifies: this
    //Effects: Runs the main loop of the TamaProgram
    public void tamaRunner() {
        tamaDrawer.tamaDefault(tamaPet);

        while (isRunning) {
            commands = input.next();
            commands = commands.toUpperCase();
            processCommands(commands);
        }
    }

    //Modifies: this
    //Effects: Processes the incoming command and outputs the desired menu
    private void processCommands(String command) {
        if (command == "FEED") {

        } else if (command == "PLAY") {

        } else if (command == "HISTORY") {

        } else if (command == "QUIT") {

        } else {
            System.out.println("Please Try Another Command (Feed | Play | History | Quit)");
            commands = input.next();
            commands = commands.toUpperCase();
            processCommands(commands);
        }
    }
}
