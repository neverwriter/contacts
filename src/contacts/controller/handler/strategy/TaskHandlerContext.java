package contacts.controller.handler.strategy;

import contacts.controller.command.Command;

public class TaskHandlerContext {

    private TaskHandlerStrategy taskHandlerStrategy;

    public void setTaskHandlerStrategy(TaskHandlerStrategy taskHandlerStrategy) {
        this.taskHandlerStrategy = taskHandlerStrategy;
    }

    public void executeStrategy(Command command){
        taskHandlerStrategy.execute(command);
    }
}
