import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ToDoListApp extends Application {
    private TaskManager taskManager;

    @Override
    public void start(Stage primaryStage) {
        taskManager = new TaskManager();
        ListView<Task> taskListView = new ListView<>();

        Button addButton = new Button("Add Task");
        addButton.setOnAction(e -> {
            Task newTask = new Task("New Task", "Description", LocalDate.now(), false);
            taskManager.addTask(newTask);
            taskListView.getItems().add(newTask);
        });

        VBox vbox = new VBox(taskListView, addButton);
        Scene scene = new Scene(vbox, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("To-Do List");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class Task {
    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean isCompleted;

    public Task(String title, String description, LocalDate dueDate, boolean isCompleted) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.isCompleted = isCompleted;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    @Override
    public String toString() {
        return title + " (Due: " + dueDate + ")";
    }
}

class TaskManager {
    private List<Task> taskList;

    public TaskManager() {
        taskList = new ArrayList<>();
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void editTask(int index, Task task) {
        taskList.set(index, task);
    }

    public void deleteTask(int index) {
        taskList.remove(index);
    }

    public List<Task> getTasks() {
        return taskList;
    }
}

class TaskView extends VBox {
    private Task task;

    public TaskView(Task task) {
        this.task = task;
        Label titleLabel = new Label(task.getTitle());
        Label dueDateLabel = new Label(task.getDueDate().toString());
        getChildren().addAll(titleLabel, dueDateLabel);
    }
}
