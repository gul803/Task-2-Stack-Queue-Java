import java.util.Scanner;

public class StackArray {
    static int[] stack = new int[5];
    static int top = -1;

    static void push(int bookNumber) {
        if (top == stack.length - 1) {
            System.out.println("Shelf is full! No space for a new book.");
        } else {
            stack[++top] = bookNumber;
            System.out.println("Book " + bookNumber +
                               " placed on top of the shelf.");
        }
    }

    static void pop() {
        if (top == -1) {
            System.out.println("Shelf is empty! No book to remove.");
        } else {
            System.out.println("Book " + stack[top] +
                               " removed from the top of the shelf.");
            top--;
        }
    }

    static void display() {
        if (top == -1) {
            System.out.println("The bookshelf is empty.");
            return;
        }

        System.out.println("Books on the shelf (Top to Bottom):");
        for (int i = top; i >= 0; i--) {
            System.out.println("Book Number: " + stack[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n--- BOOKSHELF: STACK USING ARRAY ---");
            System.out.println("1. Add a book (Push)");
            System.out.println("2. Remove top book (Pop)");
            System.out.println("3. Display books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter integer book number: ");
                    int book = sc.nextInt();
                    push(book);
                    break;
                case 2:
                    pop();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    System.out.println("Leaving the bookshelf.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}