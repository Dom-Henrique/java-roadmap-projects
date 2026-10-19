package projects.beginner.expenseTracker;

import java.util.ArrayList;
import java.util.Scanner;

public interface FinanceIF {
//    ArrayList<Finance> update(String description, String category, String month, float amount, float budget);

    ArrayList<Finance> update(Scanner sc, String description, String category, String month, float amount, float budget, ArrayList<Finance> finances);
    ArrayList<Finance> remove(Scanner sc, ArrayList<Finance> finances);
    void expenseSummary(ArrayList<Finance> finances);
}
