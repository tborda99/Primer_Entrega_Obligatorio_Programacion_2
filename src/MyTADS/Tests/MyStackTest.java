package MyTADS.Tests;


import MyTADS.Exceptions.EmptyStackException;
import MyTADS.Interfaces.MyStack;
import MyTADS.Entities.MyLinkedListImp;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyStackTest {

    @Test
    public void push() {
        MyStack<Integer> stack = new MyLinkedListImp<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.size());
    }

    @Test
    public void pop() throws EmptyStackException {
        MyStack<Integer> stack = new MyLinkedListImp<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        int poppedElement = stack.pop();
        assertEquals(3, poppedElement);
        assertEquals(2, stack.size());
    }

    @Test
    public void peek() throws EmptyStackException {
        MyStack<Integer> stack = new MyLinkedListImp<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        int topElement = stack.peek();
        assertEquals(3, topElement);
        assertEquals(3, stack.size());
    }
}
