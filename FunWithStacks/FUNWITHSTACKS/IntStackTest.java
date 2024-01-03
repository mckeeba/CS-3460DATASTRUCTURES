package FUNWITHSTACKS;


import java.util.Scanner;

public class IntStackTest 
{

    public static void main(String[] args) {
        IntStack stack = new IntStack();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Quit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter an integer to push onto the stack: ");
                    int valueToPush = scanner.nextInt();
                    stack.push(valueToPush);
                    System.out.println("Pushed: " + valueToPush);
                    break;

                case 2:
                    int popped = stack.pop();
                    if (popped == -1) {
                        System.out.println("Stack is empty. Cannot pop.");
                    } else {
                        System.out.println("Popped: " + popped);
                    }
                    break;

                case 3:
                    scanner.close();
                    System.out.println("Exiting the program.");
                    return;

                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        }
    }
}

    
