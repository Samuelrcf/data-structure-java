package application;

public interface InterfaceQueue<T> {

	void add(T item) throws MyException;
    T remove() throws MyException;
    
    T peek() throws MyException;	
    
    boolean isEmpty();
    boolean isFull();
    
    void show(); 
}
