package application;

public class QueueLinked<T> implements InterfaceQueue<T> {
	
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
    
	public QueueLinked(long capacity) {
		this.head = null;
		this.tail = null;
		this.size = 0;
		this.capacity = capacity;
	}
	
	public long getSize() {
		return size;
	}
	
	public long getCapacity() {
		return capacity;
	}

	@Override
	public void add(T item) throws MyException {
		if(isFull()) {
			throw new MyException("A fila está cheia.");
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
	public T remove() throws MyException {
		if(isEmpty()) {
			throw new MyException("A fila está vazia.");
		}
		Node node = head;
		T var = node.data;
		if(head==tail) {
			head = null;
			tail = null;
		}else {
			head = head.next;
			node = null;
		}
		size--;
		return var;
	}

	@Override
	public T peek() throws MyException {
		if(isEmpty()) {
			throw new MyException("A fila está vazia.");
		}
		T var = head.data;
		return var;
	}

	@Override
	public boolean isEmpty() {
		if(size==0) {
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
