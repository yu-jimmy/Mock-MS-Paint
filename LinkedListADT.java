public interface LinkedListADT<T> {
 
    // Returns true if the linked list has no nodes, or false otherwise.
    public boolean isEmpty();
    
    // Deletes all of the nodes in the linked list.
    public void clear();
    
    // Returns the number of nodes in the linked list
    public int size();
    
    // Adds a node to the front of the linked list.
    public void addFirst( T element );
    
    // Returns a reference to the data in the first node, or null if the list is empty.
    public T peekFirst();
        
    // Removes a node from the front of the linked list (if there is one).
    // Returns a reference to the data in the first node, or null if the list is empty.
    public T removeFirst();
    
    // Returns true if the linked list contains a certain element, or false otherwise.
    public boolean contains( T key );
    
    // Return String representation of the linked list.
    public String toString();
}