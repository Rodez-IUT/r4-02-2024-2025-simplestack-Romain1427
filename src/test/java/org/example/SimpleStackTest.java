package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test behaviour of a SimpleStack")
class SimpleStackTest {

    @Test
    @DisplayName("Test the state of a newly created slack")
    public void testCreateEmptyStack() { // Test case

        // When a freshly stack is created
        Stack stack = new SimpleStack();

        // Then… (oracle)
        assertTrue(stack.isEmpty(), "A new stack must be empty");
        assertEquals( 0, stack.getSize(), "A new stack has no element");
    }

    @Test
    @DisplayName("Test the push of items")
    public void testPush() throws EmptyStackException {

        // Given an empty stack and an item
        Stack stack = new SimpleStack();
        Item item = new SimpleItem();

        // When the item is pushed in the stack
        stack.push(item);

        // Then…
        assertFalse(stack.isEmpty(), "The stack must not be empty");
        assertEquals(1, stack.getSize(),"The stack must constain 1 item");
        assertSame( item, stack.peek(),"The pushed item must be is on top of the stack");

        // Given a new item to add
        Item item2 = new SimpleItem();

        // When we add the new item
        stack.push(item2);

        // then...
        assertFalse(stack.isEmpty(), "The stack must be not empty");
        assertEquals(2, stack.getSize(),"The stack must constain 2 items");
        assertSame( item2, stack.peek(),"The pushed item must be on top of the stack");
    }

    @Test
    @DisplayName("Test when you take a look at the last item")
    public void testPeeking() throws EmptyStackException {

        // Given an empty stack
        Stack stack = new SimpleStack();

        // When we peek at the empty stack, Then should throws an EmptyStackException
        assertThrows(EmptyStackException.class, stack::peek, "EmptyStackException not thrown");

        // Given a bunch of pushed items in the empty stack
        stack.push(new SimpleItem());
        stack.push(new SimpleItem());
        SimpleItem lastPushedItem = new SimpleItem();
        stack.push(lastPushedItem);

        // When we peek at the last item, it gives us the lastPushedItem
        assertSame(lastPushedItem, stack.peek());
    }

    @Test
    // @Disabled
    @DisplayName("Test limit when trying to pop an empty stack")
    public void testPopOnEmptyStack()  {
        // Given an empty stack
        Stack stack = new SimpleStack();

        // When we "pop" the stack, should throws an EmptyStackException.
        //assertThrows(EmptyStackException.class, ()->stack.pop(), "EmptyStackException not thrown");
        assertThrows(EmptyStackException.class, stack::pop, "EmptyStackException not thrown");
    }

    @Test
    @DisplayName("Test limit when trying to pop an non-empty stack")
    public void testPopOnStack() throws EmptyStackException {
        // Given an stack
        Stack stack = new SimpleStack();
        SimpleItem item = new SimpleItem();
        stack.push(item);

        // When we pop the stack
        SimpleItem poppedItem = (SimpleItem) stack.pop();

        // Then it should empty the stack and give the last inserted element
        assertTrue(stack.isEmpty(), "The stack should be empty");
        assertSame(item, poppedItem);
    }
}
