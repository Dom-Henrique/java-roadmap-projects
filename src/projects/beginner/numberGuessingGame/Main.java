package projects.beginner.numberGuessingGame;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int guessingNumber = (int) (Math.random() * 101);
        int option;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n========== MENU ==========\n" +
                    "1 - Start game\n" +
                    "Any key - Exit\n");
            option = sc.nextInt();
            if (option == 1) {
                int difficulty, chances = 0;
                System.out.println("\n========== SELECT DIFFICULTY ==========\n" +
                        "1 - Easy (10 chances)\n" +
                        "2 - Medium (5 chances)\n" +
                        "3 - Hard (3 chances)\n");
                difficulty = sc.nextInt();
                switch (difficulty) {
                    case 1:
                        chances = 10;
                        break;
                    case 2:
                        chances = 5;
                        break;
                    case 3:
                        chances = 3;
                        break;
                }
                int counter = 0, userNumber = 0;
                int high = 100, low = 0;
                while (counter < chances && userNumber != guessingNumber) {
                    System.out.println("A number between " + low + " and " + high + ": ");
                    userNumber = sc.nextInt();
                    counter++;
                    if (userNumber < guessingNumber && low < userNumber) low = userNumber;
                    else if (userNumber > guessingNumber && userNumber < high) high = userNumber;
                    else System.out.println("YOU DIT IT!");
                }
                System.out.println("Rounds: " + counter + "\nGuessing number: " + guessingNumber);
            } else{
                System.out.println("I SEE YOU LATER!\n");
                break;
            }
        }
    }
}
