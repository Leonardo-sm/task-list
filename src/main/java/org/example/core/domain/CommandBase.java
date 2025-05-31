package org.example.core.domain;

import org.example.core.TaskState;

public abstract class CommandBase implements ICommand {
     protected TaskState taskState() {
         return TaskState.getInstance();
     }
}
