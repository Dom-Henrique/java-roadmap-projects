package projects.beginner.taskManager;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public interface TaskManagment {
    ArrayList<Task> addTask(ArrayList<Task> tasks, Scanner scanner, DateTimeFormatter formatter);

    ArrayList<Task> removeTask(ArrayList<Task> tasks, Scanner scanner);

    ArrayList<Task> updateTask(ArrayList<Task> tasks, Scanner scanner, DateTimeFormatter formatter);


    Gson saveData(Gson jsonObject, ArrayList<Task> tasks);

}
