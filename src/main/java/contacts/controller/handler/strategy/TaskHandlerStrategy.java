package contacts.controller.handler.strategy;

import contacts.controller.command.Command;

public interface TaskHandlerStrategy {

    public void execute(Command command);
}
