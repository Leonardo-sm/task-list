package org.example.commands;

import org.example.core.domain.Task;
import org.example.core.Command;
import org.example.core.TaskState;

import java.util.List;
import java.util.Map;

public class CheckCommand implements Command {
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
        for (Map.Entry<String, List<Task>> project : TaskState.tasks.entrySet()) {
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
