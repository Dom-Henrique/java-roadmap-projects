package projects.beginner.GithubUserActivity;

import com.google.gson.Gson;
import org.kohsuke.github.GHUser;
import org.kohsuke.github.GitHub;

import java.io.IOException;

public interface GHManagerInterface {
    void userLogin() throws IOException;
    String githubUser(String name, Gson gson) throws IOException;
//    Gson saveData(String name);
}
