package Queue;

public class QueueUsingLL {
    class Node {
        int data;
        Node next;

        // Constructor to create a new node
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front, rear; // Front and rear pointers for the queue

    // Constructor to initialize the queue
    public QueueUsingLL() {
        this.front = this.rear = null;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Enqueue operation (add an element to the queue)
    public void enqueue(int data) {
        // Create a new node
        Node newNode = new Node(data);

        // If the queue is empty, both front and rear are the new node
        if (rear == null) {
            front = rear = newNode;
            System.out.println(data + " enqueued to queue.");
            return;
        }

        // Add the new node at the end and update rear
        rear.next = newNode;
        rear = newNode;
        System.out.println(data + " enqueued to queue.");
    }

    // Dequeue operation (remove an element from the queue)
    public int dequeue() {
        // If the queue is empty, return -1
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }

        // Move the front to the next node
        int data = front.data;
        front = front.next;

        // If front becomes null, set rear to null (queue becomes empty)
        if (front == null) {
            rear = null;
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
        return front.data;
    }

    // Display the queue elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        Node temp = front;
        System.out.print("Queue elements: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueUsingLL queue = new QueueUsingLL();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        queue.display(); // Output: Queue elements: 10 20 30 40

        queue.dequeue();
        queue.dequeue();

        queue.display(); // Output: Queue elements: 30 40

        System.out.println("Front element is: " + queue.peek()); // Output: Front element is: 30
    }
}
