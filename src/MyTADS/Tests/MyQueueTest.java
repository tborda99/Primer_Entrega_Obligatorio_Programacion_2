package MyTADS.Tests;

import MyTADS.Exceptions.EmptyQueueException;
import MyTADS.Interfaces.MyQueue;
import MyTADS.Entities.MyLinkedListImp;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyQueueTest {

    @Test
    public void enqueue() {
        MyQueue<String> queue = new MyLinkedListImp<>();

        // Enqueue elements
        queue.enqueue("Apple");
        queue.enqueue("Banana");
        queue.enqueue("Cherry");

        // Check size after enqueue
        assertEquals(3, queue.size());
    }

    @Test
    public void dequeue() throws EmptyQueueException {
        MyQueue<String> queue = new MyLinkedListImp<>();

        // Enqueue elements
        queue.enqueue("Apple");
        queue.enqueue("Banana");
        queue.enqueue("Cherry");

        // Dequeue elements
        assertEquals("Apple", queue.dequeue());
        assertEquals("Banana", queue.dequeue());

        // Check size after dequeue
        assertEquals(1, queue.size());

        // Dequeue the last element
        assertEquals("Cherry", queue.dequeue());

        // Check size after dequeueing the last element
        assertEquals(0, queue.size());

        // Try dequeue on an empty queue
        try {
            queue.dequeue();
            fail("Expected EmptyQueueException to be thrown");
        } catch (EmptyQueueException e) {
            // Exception is expected
        }
    }
}