import java.util.Scanner;

public class QueueLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node front = null;
    static Node rear = null;

    static void enqueue(int token) {
        Node newNode = new Node(token);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println("Customer with token " + token +
                           " joined the service line.");
    }

    static void dequeue() {
        if (front == null) {
            System.out.println("No customers are waiting.");
            return;
        }

        System.out.println("Customer with token " +
                           front.data + " is being served.");

        front = front.next;

        if (front == null) {
            rear = null;
        }
    }

    static void display() {
        if (front == null) {
            System.out.println("The service line is empty.");
            return;
        }

        System.out.println("Customers (Front to Rear):");
        Node current = front;

        while (current != null) {
            System.out.println("Customer Token: " + current.data);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n--- CUSTOMER LINE: QUEUE LINKED LIST ---");
            System.out.println("1. Add customer (Enqueue)");
            System.out.println("2. Serve customer (Dequeue)");
            System.out.println("3. Display customers");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter integer token number: ");
                    int token = sc.nextInt();
                    enqueue(token);
                    break;
                case 2:
                    dequeue();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    System.out.println("Leaving the service line.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
