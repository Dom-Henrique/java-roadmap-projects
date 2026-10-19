package projects.beginner.GithubUserActivity;

import com.google.gson.Gson;
import org.kohsuke.github.GHUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int option = 1;
        Gson gson = new Gson();
        Scanner sc = new Scanner(System.in);
        ArrayList<GHUser> users = new ArrayList<>();
//        GHManager ghManager = new GHManager();
//        ghManager.userLogin();
        while (true){
            System.out.println("\n========== MENU ==========\n" +
                    "1 - Search user by GitHub username\n" +
                    "2 - Show all users data\n" +
                    "Any key - Exit\n\n");
            option = sc.nextInt();
            GHManager ghManager = new GHManager();
            ghManager.userLogin();
            sc.nextLine();
            if (option==1){
                System.out.println("Name to search: ");
                String name = sc.nextLine();
                ghManager.githubUser(name, gson, users);
            }
            else if (option==2) ghManager.readData();
            else break;
        }
//        GHManager ghManager = new GHManager();
//        ghManager.userLogin();
//        System.out.println("Name to search: ");
//        String name = sc.nextLine();
//        ghManager.githubUser(name, gson);
//        ghManager.readData();
    }
}
