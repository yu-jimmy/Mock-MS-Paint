public interface StackADT<T> {
    // Adds one element to the top of the stack.
    public void push(T element);
    
    // Removes and returns a reference to the top element from the stack.
    public T pop();
    
    // Returns a reference to the top element, without removing it from the stack.
    public T peek();
    
    // Returns true if the stack contains no elements, false otherwise.
    public boolean isEmpty();
    
    // Returns the number of elements in the stack.
    public int size();
    
    // Clears all elements from the stack
    public void clear();
    
    // Returns a String representation of the stack.
    public String toString();
}