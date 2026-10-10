import java.util.Scanner;

public class QueueArray {
    static int[] queue = new int[5];
    static int front = 0;
    static int rear = -1;
    static int count = 0;

    static void enqueue(int token) {
        if (count == queue.length) {
            System.out.println("Waiting line is full!");
        } else {
            rear = (rear + 1) % queue.length;
            queue[rear] = token;
            count++;
            System.out.println("Student with token " + token +
                               " joined the library line.");
        }
    }

    static void dequeue() {
        if (count == 0) {
            System.out.println("No students are waiting.");
        } else {
            System.out.println("Student with token " +
                               queue[front] + " has been served.");
            front = (front + 1) % queue.length;
            count--;
        }
    }

    static void display() {
        if (count == 0) {
            System.out.println("The waiting line is empty.");
            return;
        }

        System.out.println("Library waiting line (Front to Rear):");
        for (int i = 0; i < count; i++) {
            int index = (front + i) % queue.length;
            System.out.println("Student Token: " + queue[index]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n--- LIBRARY LINE: QUEUE USING ARRAY ---");
            System.out.println("1. Add student (Enqueue)");
            System.out.println("2. Serve student (Dequeue)");
            System.out.println("3. Display waiting line");
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
                    System.out.println("Leaving the library line.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
