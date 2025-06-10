package org.example.commands;

import org.example.core.annotations.Command;
import org.example.core.domain.CommandBase;
import org.example.core.domain.Task;
import org.example.core.domain.TaskList;

import java.util.Map;

@Command(name = "uncheck", description = "uncheck <task ID>")
public class UncheckCommand extends CommandBase {
    private final String id;

    public UncheckCommand(String id) {
        this.id = id;
    }

    @Override
    public void execute() {
        setDone(id);
    }

    private void setDone(String idString) {
        int id = Integer.parseInt(idString);
        for (Map.Entry<String, TaskList> project : taskState().getTasks().entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId() == id) {
                    task.setDone(Boolean.FALSE);
                    return;
                }
            }
        }
        System.out.printf("Could not find a task with an ID of %d.", id);
        System.out.println();
    }
}
