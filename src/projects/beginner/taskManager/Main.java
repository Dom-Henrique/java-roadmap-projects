package projects.beginner.taskManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import netscape.javascript.JSException;
import netscape.javascript.JSObject;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        int option;
        Task task = new Task();
        ArrayList<Task> tasks = new ArrayList<>();
        while (true) {
            System.out.println("\n========== MENU ==========\n" +
                    "1 - Add Task\n" +
                    "2 - Update Task\n" +
                    "3 - Delete Task\n" +
                    "4 - Save data\n" +
                    "Any ket - Exist\n\n");
            option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1) {
                task.addTask(tasks, scanner, formatter);
            } else if (option == 2) {
                task.updateTask(tasks, scanner, formatter);
            } else if (option == 3) {
                task.updateTask(tasks, scanner, formatter);
            } else if (option == 4) {
                task.saveData(gson, tasks);
            } else {
                System.exit(0);
            }
        }
    }
}
