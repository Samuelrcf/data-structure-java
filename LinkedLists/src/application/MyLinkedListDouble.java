package application;

public class MyLinkedListDouble<T> implements MyInterfaceList<T> {

	class Node {
		T data;
		Node next;
		Node prev;

		public Node(T data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}
	
    private Node head;    
    private Node tail;
    private int size;
	
	public MyLinkedListDouble() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	@Override
	public void addFirst(T value) {
		Node newNode = new Node(value);
		if(head==null) {
			head = newNode;
			tail = newNode;
		}else {
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
		}
		size++;
	}

	@Override
	public void addLast(T value) {
		Node newNode = new Node(value);
		if(tail==null) {
			head = newNode;
			tail = newNode;
		}else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		size++;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean addAfter(T dado, T crit) {
		Node node = (Node) search(crit);
		Node newNode = new Node(dado);
		if(node==null) {
			return false;
		}
		if(node.equals(tail)) {
			tail.next = newNode;
			newNode.prev = tail;
			newNode.next = null;
			tail = newNode;
		}else {
			newNode.next = node.next;
			node.next.prev = newNode;
			node.next = newNode;
			newNode.prev = node;
		}
		size++;
		return true;
	}

	@Override
	public T peekFirst() {
		if(head==null) {
			return null;
		}
		return head.data;
	}

	@Override
	public T peekLast() {
		if(tail==null) {
			return null;
		}
		return tail.data;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T search(T crit) {
		Node node = head;
		while(node!=null) {
			if(node.data.equals(crit)) {
				return (T) node;
			}
			node = node.next;
		}
		return null;
	}

	@Override
	public T removeFirst() {
		Node node = head;
		if(head==null) {
			return null;
		}
		if(head==tail) {
			head = null;
			tail = null;
		}else {
			head = head.next;
			node.next = null;
			head.prev = null;
		}
		size--;
		return node.data;
	}

	@Override
	public T removeLast() {
		Node node = tail;
		if(tail==null) {
			return null;
		}
		if(head==tail) {
			head = null;
			tail = null;
		}else {
			tail = tail.prev;
			node.prev = null;
			tail.next = null;
		}
		size--;
		return node.data;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove(T crit) {
		if(head==null) {
			System.out.println("A lista está vazia.");
			return null;
		}
		Node node = (Node) search(crit);
		if(node==null) {
			System.out.println("Elemento não encontrado.");
			return null;
		}
		Node n = head.next;
		T var = node.data;
		if(head==tail) {
			head = null;
			tail = null;
			size--;
		}
		else if(node==head) {
			removeFirst();
		}else if(node==tail) {
			removeLast();
		}else {
			while(!n.data.equals(crit)) {
				n = n.next;
			}
			n.prev.next = n.next;
			n.next.prev = n.prev;
			n = null;
			size--;
		}
		return var;
	}

	@Override
	public void show() {
		if(head==null) {
			System.out.println("A lista está vazia.");
		}
		Node node = head;
		while(node!=null) {
			System.out.println(node.data);
			node = node.next;
		}
	}

	@Override
	public void showReverse() {
		if(head==null) {
			System.out.println("A lista está vazia.");
		}
		Node node = tail;
		while(node!=null) {
			System.out.println(node.data);
			node = node.prev;
		}
		
	}
}
