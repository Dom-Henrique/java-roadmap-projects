package projects.beginner.expenseTracker;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int option;
        Scanner sc = new Scanner(System.in);
        ArrayList<Finance> finances = new ArrayList<>();
        Finance finance = new Finance();
        while (true) {
            System.out.println("\n========== MENU ==========\n" +
                    "1 - Add expense\n" +
                    "2 - Update expense\n" +
                    "3 - Delete expense\n" +
                    "4 - View expense\n" +
                    "5 - Summary of expenses\n" +
                    "6 - Summary per month\n" +
                    "Any key - exit\n\n");
            option = sc.nextInt();
            sc.nextLine();
            if (option == 1) {
                System.out.println("Amount: ");
                float amount = sc.nextFloat();
                System.out.println("Budget: ");
                float budget = sc.nextFloat();
                System.out.println("Description: ");
                String description = sc.nextLine();
                sc.nextLine();
                System.out.println("Category: ");
                String category = sc.nextLine();
                System.out.printf("Month: ");
                String month = sc.nextLine();
                finance = new Finance(description, category, month, amount, budget);
                finances.add(finance);
                System.out.println("ADDED!\n");
            } else if (option == 2) {
                if (finances.isEmpty()) System.out.println("EMPTY!\n");
                else{
                    System.out.println("Amount: ");
                    float amount = sc.nextFloat();
                    System.out.println("Budget: ");
                    float budget = sc.nextFloat();
                    System.out.println("Description: ");
                    String description = sc.nextLine();
                    sc.nextLine();
                    System.out.println("Category: ");
                    String category = sc.nextLine();
                    System.out.printf("Month: ");
                    String month = sc.nextLine();
                    finance.update(sc, description, category, month, amount, budget, finances);
                }
            } else if (option == 3){
                finance.remove(sc, finances);
            } else if (option == 5){
                finance.expenseSummary(finances);
            }
        }
    }
}
