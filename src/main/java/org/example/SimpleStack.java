package org.example;

import java.util.ArrayList;

public class SimpleStack implements Stack {

    private ArrayList<Item> itemStack;

    public SimpleStack() {
        itemStack = new ArrayList<>(10);
    }

    /**
     * Tests if this stack is empty
     */
    @Override
    public boolean isEmpty() {
        return itemStack.size() == 0;
    }

    /**
     * Returns the number of items in this stack.
     */
    @Override
    public int getSize() {
        return itemStack.size();
    }

    /**
     * Pushes an item onto the top of this stack.
     * null item is allowed.
     *
     * @param item an item of the stack
     */
    @Override
    public void push(Item item) {
        itemStack.add(item);
    }

    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     */
    @Override
    public Item peek() throws EmptyStackException {
        return itemStack.get(itemStack.size() - 1);
    }

    /**
     * Removes the object at the top of this stack and returns
     * that object as the value of this function.
     *
     * @throws EmptyStackException if this stack is empty.
     */
    @Override
    public Item pop() throws EmptyStackException {
        if (itemStack.size() > 0) {
            return itemStack.remove(itemStack.size() - 1);
        } else {
            throw new EmptyStackException();
        }
    }
}
