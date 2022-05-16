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
    INFO("INFO"),
    FEED("FEED"),
    NUMBER("NUMBER"),
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
