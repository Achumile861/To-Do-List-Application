import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Main class for the To-Do List application, extending JavaFX Application
public class ToDoListApp extends Application {
    private TaskManager taskManager; // Instance variable for managing tasks
    private ListView<TaskView> taskListView; // ListView to display tasks

    @Override
    public void start(Stage primaryStage) {
        taskManager = new TaskManager(); // Initialize TaskManager to manage tasks
        taskListView = new ListView<>(); // Initialize ListView to display tasks

        // Populate initial tasks (for demonstration)
        Task task1 = new Task("Task 1", "Description for Task 1", LocalDate.now(), false);
        Task task2 = new Task("Task 2", "Description for Task 2", LocalDate.now().plusDays(1), false);
        taskManager.addTask(task1); // Add tasks to TaskManager
        taskManager.addTask(task2);
        taskListView.getItems().addAll(createTaskViews(task1), createTaskViews(task2)); // Populate ListView with TaskViews

        // Button to add a new task
        Button addButton = new Button("Add Task");
        addButton.setOnAction(e -> {
            Task newTask = new Task("New Task", "Description", LocalDate.now(), false); // Create a new task
            taskManager.addTask(newTask); // Add new task to TaskManager
            taskListView.getItems().add(createTaskViews(newTask)); // Add new task view to ListView
        });

        // Button to edit a selected task
        Button editButton = new Button("Edit Task");
        editButton.setOnAction(e -> {
            TaskView selectedTaskView = taskListView.getSelectionModel().getSelectedItem();
            if (selectedTaskView != null) {
                Task selectedTask = selectedTaskView.getTask();
                // Simulating edit action with new due date (for demonstration)
                selectedTask.setDueDate(LocalDate.now().plusDays(3));
                taskManager.editTask(taskListView.getSelectionModel().getSelectedIndex(), selectedTask);
                taskListView.getItems().set(taskListView.getSelectionModel().getSelectedIndex(), createTaskViews(selectedTask));
            }
        });

        // Button to delete a selected task
        Button deleteButton = new Button("Delete Task");
        deleteButton.setOnAction(e -> {
            int selectedIndex = taskListView.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                taskManager.deleteTask(selectedIndex); // Delete task from TaskManager
                taskListView.getItems().remove(selectedIndex); // Remove task view from ListView
            }
        });

        // Layout VBox containing ListView and buttons
        VBox vbox = new VBox(taskListView, addButton, editButton, deleteButton);
        Scene scene = new Scene(vbox, 300, 400); // Create a scene with VBox as the root node
        primaryStage.setScene(scene); // Set the scene in the primary stage
        primaryStage.setTitle("To-Do List"); // Set the title of the primary stage
        primaryStage.show(); // Display the primary stage
    }

    // Method to create TaskView from Task
    private TaskView createTaskViews(Task task) {
        return new TaskView(task); // Create and return TaskView for a given Task
    }

    // Main method to launch the JavaFX application
    public static void main(String[] args) {
        launch(args); // Launch JavaFX application
    }
}

// Class representing a Task
class Task {
    private String title; // Title of the task
    private String description; // Description of the task
    private LocalDate dueDate; // Due date of the task
    private boolean isCompleted; // Completion status of the task

    // Constructor to initialize Task with given values
    public Task(String title, String description, LocalDate dueDate, boolean isCompleted) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.isCompleted = isCompleted;
    }

    // Getters and setters for Task attributes
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

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    // Override toString method to represent Task as a string
    @Override
    public String toString() {
        return title + " (Due: " + dueDate + ")";
    }
}

// Class managing a list of tasks
class TaskManager {
    private List<Task> taskList; // List to store tasks

    // Constructor to initialize TaskManager with an empty list
    public TaskManager() {
        taskList = new ArrayList<>();
    }

    // Method to add a task to the task list
    public void addTask(Task task) {
        taskList.add(task);
    }

    // Method to edit a task at a specified index in the task list
    public void editTask(int index, Task task) {
        taskList.set(index, task);
    }

    // Method to delete a task at a specified index from the task list
    public void deleteTask(int index) {
        taskList.remove(index);
    }

    // Method to retrieve the list of tasks
    public List<Task> getTasks() {
        return taskList;
    }
}

// Custom JavaFX component to represent a Task view
class TaskView extends VBox {
    private Task task; // Task associated with the TaskView

    // Constructor to initialize TaskView with a given Task
    public TaskView(Task task) {
        this.task = task;
        Label titleLabel = new Label(task.getTitle()); // Label to display task title
        Label dueDateLabel = new Label(task.getDueDate().toString()); // Label to display task due date
        getChildren().addAll(titleLabel, dueDateLabel); // Add labels to TaskView
    }

    // Getter method to retrieve the Task associated with TaskView
    public Task getTask() {
        return task;
    }
}
