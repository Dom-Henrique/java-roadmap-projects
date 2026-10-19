package projects.beginner.expenseTracker;

import java.util.ArrayList;
import java.util.Scanner;

public class Finance implements FinanceIF{
    private String description, category, month;
    private float amount, budget;
    Long id = (long) (Math.random() * 10);

    public Finance(){}
    public Finance(String description, String category, String month, float amount, float budget) {
        this.description = description;
        this.category = category;
        this.amount = amount;
        this.budget = budget;
        this.month = month.toUpperCase();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month.toUpperCase();
    }

    public Long getId() {
        return id;
    }

    @Override
    public ArrayList<Finance> update(Scanner sc, String description, String category, String month, float amount, float budget, ArrayList<Finance> finances) {
        System.out.println("ID: ");
        long id = sc.nextLong(10);
        for (Finance f : finances){
            if (f.getId()==id){
                f.setDescription(description);
                f.setAmount(amount);
                f.setBudget(budget);
                f.setCategory(category);
                f.setMonth(month);
            }
        }
        System.out.println("UPDATED!\n");
        return finances;
    }

    @Override
    public ArrayList<Finance> remove(Scanner sc, ArrayList<Finance> finances) {
        System.out.println("ID: ");
        long id = sc.nextLong(10);
        for (Finance f : finances){
            if (f.getId() == id){
                finances.remove(f);
            }
        }
        System.out.println("REMOVED!\n");
        return finances;
    }

    @Override
    public void expenseSummary(ArrayList<Finance> finances) {
        float totalAmount = 0, totalBudget = 0;
        for (Finance f : finances){
            totalAmount += f.getAmount();
            totalBudget += f.getBudget();
        }
        System.out.println("Total amount: " + totalAmount + "\nTotal budget: " + totalBudget + "\n\n");;
    }
}
