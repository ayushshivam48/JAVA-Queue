package Queue;

public class CircularQueueUsingArray {
    private int[] queue;  // Array to store queue elements
    private int front;    // Points to the front of the queue
    private int rear;     // Points to the rear of the queue
    private int size;     // Maximum size of the queue

    // Constructor to initialize the circular queue
    public CircularQueueUsingArray(int size) {
        this.size = size;
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    // Check if the queue is full
    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == -1;
    }

    // Enqueue operation (add an element to the queue)
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full.");
            return;
        }
        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % size;  // Move rear forward in circular manner
        queue[rear] = data;
        System.out.println(data + " enqueued to queue.");
    }

    // Dequeue operation (remove an element from the queue)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        int data = queue[front];
        if (front == rear) { // Only one element left, reset queue
            front = rear = -1;
        } else {
            front = (front + 1) % size;  // Move front forward in circular manner
        }
        System.out.println(data + " dequeued from queue.");
        return data;
    }

    // Peek operation (view the front element without removing it)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return queue[front];
    }

    // Display the queue elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue elements: ");
        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear) break;
            i = (i + 1) % size;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueueUsingArray cq = new CircularQueueUsingArray(5);

        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.enqueue(50);

        cq.display();  // Output: Queue elements: 10 20 30 40 50

        cq.dequeue();
        cq.dequeue();

        cq.display();  // Output: Queue elements: 30 40 50

        cq.enqueue(60);
        cq.enqueue(70);

        cq.display();  // Output: Queue elements: 30 40 50 60 70
    }
}
