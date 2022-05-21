package contacts.controller.command;

/**
 * Enum collection of command words
 * @author Patryk Lewczuk
 */

public enum Command {

    EXIT("EXIT"),
    EDIT("EDIT"),
    ADD("ADD"),
    DELETE("DELETE"),
    COUNT("COUNT"),
    LIST("LIST"),
    FEED("FEED"),
    NUMBER("NUMBER"),
    BACK("BACK"),
    AGAIN("AGAIN"),
    MENU("MENU"),
    NAME("NAME"),
    // SURNAME("SURNAME"),
    // BIRTH("BIRTH"),
    // GENDER("GENDER"),
    ADDRESS("ADDRESS"),
    SEARCH("SEARCH");

    private final String command;

    Command(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

}
