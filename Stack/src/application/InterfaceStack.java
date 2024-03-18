package application;

public interface InterfaceStack<T> {

	void push(T item) throws MyException;
	T pop() throws MyException;
	
	T peek() throws MyException;
	
	boolean isEmpty();
	boolean isFull();
	
	void show();
}
