package projects.beginner.taskManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Task implements TaskManagment {
    private String taskName;
    private LocalDate taskDate;

    enum tS {
        NOT_STARDED,
        IN_PROGRESS,
        DONE
    }

    private tS taskStatus;

    @Override
    public ArrayList<Task> addTask(ArrayList<Task> tasks, Scanner scanner, DateTimeFormatter formatter) {
        System.out.println("Task name: ");
        String tn = scanner.nextLine();
        System.out.println("Task date: ");
        String td = scanner.nextLine();
        LocalDate tD = LocalDate.parse(td, formatter);
        System.out.println("Task status: ");
        String ts = scanner.nextLine();
        tS tS = Task.tS.NOT_STARDED;
        if (ts.toUpperCase().equals("NOT STARTED")) ;
        else if (ts.toUpperCase().equals("IN PROGRESS")) tS = Task.tS.IN_PROGRESS;
        else if (ts.toUpperCase().equals("DONE")) tS = Task.tS.DONE;
        Task task = new Task(tn, tD, tS);
        tasks.add(task);
        System.out.println("ADDED!\n");
        return tasks;
    }

    @Override
    public ArrayList<Task> removeTask(ArrayList<Task> tasks, Scanner scanner) {
        if (tasks.isEmpty()) {
            System.out.println("EMPTY!\n");
            return tasks;
        }
        System.out.println("Task name: ");
        String taskName = scanner.nextLine();
        for (Task task : tasks) {
            if (task.getTaskName().equals(taskName)) {
                tasks.remove(task);
            }
        }
        return tasks;
    }

    @Override
    public ArrayList<Task> updateTask(ArrayList<Task> tasks, Scanner scanner, DateTimeFormatter formatter) {
        if (tasks.isEmpty()) {
            System.out.println("EMPTY!\n");
            return tasks;
        }
        System.out.println("Task name: ");
        String taskName = scanner.nextLine();
        for (Task task : tasks) {
            if (task.getTaskName().equals(taskName)) {
                System.out.println("Task name: ");
                String tn = scanner.nextLine();
                System.out.println("Task date: ");
                String td = scanner.nextLine();
                LocalDate tD = LocalDate.parse(td, formatter);
                System.out.println("Task status: ");
                String ts = scanner.nextLine();
                tS tS = Task.tS.NOT_STARDED;
                if (ts.toUpperCase().equals("NOT STARTED")) ;
                else if (ts.toUpperCase().equals("IN PROGRESS")) tS = Task.tS.IN_PROGRESS;
                else if (ts.toUpperCase().equals("DONE")) tS = Task.tS.DONE;
                task.setTaskName(tn);
                task.setTaskDate(tD);
                task.setTaskStatus(tS);
            }
        }
        return tasks;
    }

    @Override
    public Gson saveData(Gson gson, ArrayList<Task> tasks) {
        File file = new File("tasks.json");
//        gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter fileWriter = new FileWriter(file)) {
            gson.toJson(tasks, file.getClass());
//            return fileWriter;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gson;
    }

    public Task() {

    }

    public Task(String taskName, LocalDate taskDate, tS taskStatus) {
        this.taskName = taskName;
        this.taskDate = taskDate;
        this.taskStatus = taskStatus;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public LocalDate getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(LocalDate taskDate) {
        this.taskDate = taskDate;
    }

    public tS getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(tS taskStatus) {
        this.taskStatus = taskStatus;
    }
}
