package projects.beginner.GithubUserActivity;

import com.google.gson.Gson;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int option;
        Gson gson = new Gson();
        Scanner sc = new Scanner(System.in);

        System.out.println("Name to search: ");
        String name = sc.nextLine();
        GHManager ghManager = new GHManager();
        ghManager.userLogin();
        ghManager.githubUser(name, gson);
    }
}
