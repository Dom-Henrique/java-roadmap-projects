package projects.beginner.GithubUserActivity;

import com.google.gson.Gson;
import org.kohsuke.github.GHUser;
import org.kohsuke.github.GitHub;

import java.io.FileWriter;
import java.io.IOException;

public class GHManager implements GHManagerInterface{
    protected GitHub github;
    // funcao para login
    @Override
    public void userLogin() throws IOException {
        github = GitHub.connectAnonymously();
    }
    @Override
    public String githubUser(String name, Gson gson) throws IOException {
        GHUser ghuser = github.getUser(name);
        String userData = "Name: " + ghuser.getName() + "\nEmail: " + ghuser.getEmail() + "\nCompany: " + ghuser.getCompany();
        FileWriter fileWriter = new FileWriter("data.JSON");
        gson.toJson(ghuser, fileWriter);
        return userData;
    }
//    @Override
//    Gson saveData(String name) throws IOException {
//        GHUser ghuser = github.getUser(name);
//
//    }
}
