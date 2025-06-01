package org.example.commands;

import org.example.core.annotations.Command;
import org.example.core.domain.CommandBase;
import org.example.core.domain.Task;
import org.example.core.domain.TaskList;

import java.util.Map;

@Command(name = "check")
public class CheckCommand extends CommandBase {
    private String id;

    public CheckCommand(String id) {
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
                    task.setDone(!task.isDone());
                    return;
                }
            }
        }
        System.out.printf("Could not find a task with an ID of %d.", id);
        System.out.println();
    }
}
