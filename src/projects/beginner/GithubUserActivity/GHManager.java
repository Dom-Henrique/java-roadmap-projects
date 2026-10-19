package projects.beginner.GithubUserActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.kohsuke.github.GHUser;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitUser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GHManager implements GHManagerInterface {
    protected GitHub github;

    // funcao para login
    @Override
    public void userLogin() throws IOException {
        github = GitHub.connectAnonymously();
    }

    @Override
    public String githubUser(String name, Gson gson, ArrayList<GHUser> users) throws IOException {
        GHUser ghuser = github.getUser(name);
        String userData = "Name: " + ghuser.getName()
                + "\nEmail: " + ghuser.getEmail()
                + "\nCompany: " + ghuser.getCompany();
        users.add(ghuser);
        try (FileWriter fileWriter = new FileWriter("src/projects/beginner/GithubUserActivity/userDatas/data.JSON")) {
            gson.toJson(users, fileWriter);
        }

        return userData;
    }

    @Override
    public void readData() throws IOException {
        try (FileReader reader = new FileReader("src/projects/beginner/GithubUserActivity/userDatas/data.JSON")) {
            JsonElement json = JsonParser.parseReader(reader);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println(gson.toJson(json));
        }
    }
}
