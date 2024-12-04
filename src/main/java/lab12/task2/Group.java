package lab12.task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Group<T> extends Task<T> {
    public String groupUuid;
    private List<Task<T>> tasks = new ArrayList<>();

    public Group<T> addTask(Task<T> task) {
        checkIfFrozen();
        tasks.add(task);
        return this;
    }

    @Override
    public void freeze() {
        super.freeze();
        groupUuid = UUID.randomUUID().toString();
        for (Task<T> task : tasks) {
            task.freeze();
            task.setHeader("groupUuid", groupUuid);
        }
        tasks = Collections.unmodifiableList(tasks);
    }

    @Override
    public void apply(T arg) {
        this.freeze();
        for (Task<T> task : tasks) {
            try {
                task.apply(arg);
            } catch (Exception e) {
                System.err.println("Error executing task " + task.getId() + ": " + e.getMessage());
            }
        }
    }
}
