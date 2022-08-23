package duke.core;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 * The UI for Duke. Handles the displaying and formatting of messages.
 */
public class Ui {

    /**
     * The greeting message used when main is loaded.
     */
    private static final String welcomeMessage = "Hello! I'm Duke\nWhat can I do for you?";
    /**
     * The indentation that is displayed with each message.
     */
    private static final String indentation = "    ";
    /**
     * A line that is printed to show text boundaries.
     */
    private static final String line = "____________________________________________________________";

    /**
     * Whether the UI should exit. Meant to be checked after every command.
     */
    private boolean isExit = false;

    /**
     * Scanner used to read user input.
     */
    private Scanner userInput = new Scanner(System.in);

    /**
     * Reads the command from the user.
     * @return The command given by the user.
     */
    public String readCommand() {
        return userInput.nextLine();
    }

    /**
     * Displays the welcome message.
     */
    public void showWelcome() {
        showLine();
        showMessage(welcomeMessage);
        showLine();
    }

    /**
     * Displays a horizontal line.
     */
    public void showLine() {
        showMessage(line);
    }

    /**
     * Shows an error message.
     * @param e DukeException that contains the error message.
     */
    public void showError(DukeException e) {
        showMessage(e.getMessage());
    }

    /**
     * Shows an arbirary message. Separates the message by newlines
     * and formats them accordingly.
     * @param message Message to display.
     */
    public void showMessage(String message) {
        Stream<String> messageLines = message.lines();
        messageLines.forEach(x -> System.out.println(indentation + x));
    }

    public void setIsExit(boolean isExit) {
        this.isExit = isExit;
    }

    public boolean isExit() {
        return isExit;
    }

}
