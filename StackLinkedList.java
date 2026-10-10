import java.util.Scanner;

public class StackLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node top = null;

    static void push(int boxNumber) {
        Node newNode = new Node(boxNumber);
        newNode.next = top;
        top = newNode;

        System.out.println("Box " + boxNumber +
                           " placed on top of the stack.");
    }

    static void pop() {
        if (top == null) {
            System.out.println("No boxes are available to remove.");
        } else {
            System.out.println("Box " + top.data +
                               " removed from the top.");
            top = top.next;
        }
    }

    static void display() {
        if (top == null) {
            System.out.println("The box stack is empty.");
            return;
        }

        System.out.println("Boxes (Top to Bottom):");
        Node current = top;

        while (current != null) {
            System.out.println("Box Number: " + current.data);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n--- BOX STACK: LINKED LIST ---");
            System.out.println("1. Add box (Push)");
            System.out.println("2. Remove top box (Pop)");
            System.out.println("3. Display boxes");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter integer box number: ");
                    int box = sc.nextInt();
                    push(box);
                    break;
                case 2:
                    pop();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    System.out.println("Leaving the box stack.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}

