package application;

public class StackLinked<T> implements InterfaceStack<T> {

	class Node{
		private T data;
		private Node next;
		
		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}
	
	private Node head;
	private Node tail;
	private long size;
	private long capacity;
	
	public StackLinked(long capacity) {
		this.head = null; 
		this.tail = null;
		this.size = 0;
		this.capacity = capacity;
	}

	@Override
	public void push(T item) throws MyException {
		if(isFull()) {
			throw new MyException("A pilha está cheia.");
		}
		Node newNode = new Node(item);
		if(isEmpty()) {
			head = newNode;
			tail = newNode;
		}else {
			tail.next = newNode;
			tail = newNode; 
		}
		size++;
	}

	@Override
	public T pop() throws MyException {
		if(isEmpty()) {
			throw new MyException("A pilha está vazia.");
		}
		Node node = head;
		
		Node node2 = tail;
		T var = node2.data;
		
		if(head==tail) {
			head = null;
			tail = null;
		}else {
			while(node.next!=tail) {
				node = node.next;
			}
			node.next = null;
			tail = null;
			tail = node;
		}
		size--;
		return var;
	}

	@Override
	public T peek() throws MyException {
		if(isEmpty()) {
			throw new MyException("A pilha está vazia.");
		}
		T var = tail.data;
		return var;
	}

	@Override
	public boolean isEmpty() {
		if(head==null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if(size==capacity) {
			return true;
		}
		return false;
	}

	@Override
	public void show() {
		if(isEmpty()) {
			return;
		}
		Node node = head;
		while(node!=null) {
			System.out.println(node.data);
			node = node.next;
		}
	}

}
