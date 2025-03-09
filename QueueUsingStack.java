package Queue;

import java.util.Stack;

public class QueueUsingStack {
    static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        // Check if the queue is empty
        public static boolean isEmpty() {
            return s1.isEmpty() && s2.isEmpty();
        }

        // Enqueue operation (add an element to the queue)
        public static void add(int data) {
            // Push the new element onto s1
            s1.push(data);
        }

        // Dequeue operation (remove an element from the queue)
        public static int remove() {
            // If both stacks are empty, return an error value
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            // Transfer elements from s1 to s2 if s2 is empty
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            // Return the top element of s2
            return s2.pop();
        }

        // Peek operation (get the front element without removing it)
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            // Transfer elements from s1 to s2 if s2 is empty
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            // Return the top element of s2
            return s2.peek();
        }
    }

    public static void main(String[] args) {
        
        Queue.add(1);
        Queue.add(2);
        Queue.add(3);

        while (!Queue.isEmpty()) {
            System.out.println(Queue.peek());
            Queue.remove();
        }
    }
}
