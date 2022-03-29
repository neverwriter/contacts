package contacts.controller.command;

/**
 * Enum collection of command words
 * @author Patryk Lewczuk
 */

public enum Command {

    EXIT("EXIT"),
    EDIT("EDIT"),
    ADD("ADD"),
    REMOVE("REMOVE"),
    COUNT("COUNT"),
    LIST("LIST"),
    FEED("FEED"),
    NUMBER("NUMBER"),
    NAME("NAME"),
    SURNAME("SURNAME");


    private final String command;

    Command(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

}
