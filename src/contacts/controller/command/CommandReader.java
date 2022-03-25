package contacts.controller.command;

import java.util.Scanner;

/**
 * Class to read user command from console
 * @author Patryk Lewczuk
 */

public class CommandReader {



    /**
     *
     * @return In case of String which is representation of command input by user.
     */
    public static String readCommand() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int readNumberOfContact() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
