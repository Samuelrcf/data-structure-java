package application;

public class MyLinkedListSingly<T> implements MyInterfaceList<T> {

	class Node {
		T data;
		Node next;

		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}
	
    private Node head;
    private Node tail;
    private int size;
    
    public MyLinkedListSingly() {
    	head = null;
    	tail = null;
    	size = 0;
    }

	@Override
	public void addFirst(T value) {
		Node newNode = new Node(value); 
		if(head == null) {
			head = newNode;
			tail = newNode;
		}else {
			newNode.next = head;
			head = newNode;
		}
		size++;
	}

	@Override
	public void addLast(T value) {
		Node newNode = new Node(value); 
		if(tail == null) {
			head = newNode;
			tail = newNode;
		}else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean addAfter(T dado, T crit) { 
		Node newNode = new Node(dado); 
		Node node = (Node) search(crit);
		if(node==null) {
			return false;
		}else {
			if(node.next==null) {
				tail = newNode;
			}
			newNode.next = node.next;
			node.next = newNode;
			size++;
			return true;
		}
	}

	@Override
	public T peekFirst() {
		if(head == null) {
			System.out.println("A lista está vazia.");
			return null;
		}
		return head.data;
	}

	@Override
	public T peekLast() {
		if(tail == null) {
			System.out.println("A lista está vazia.");
			return null;
		}
		return tail.data;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T search(T crit) {
	    Node node = head; 
	    
	    while(node != null) {
	        if(node.data.equals(crit)) {
	            return (T) node;
	        }
	        node = node.next; 
	    }
	    return null; 
	}


	@Override
	public T removeFirst() {
		if(head == null) {
			System.out.println("A lista está vazia.");
			return null;
		}
		Node node = head; 
		if(head == tail) {
			head = null;
			tail = null;
		}else {
			head = head.next;
			node.next = null;
		}
		size--;
		return node.data;
	}

	@Override
	public T removeLast() {
		if(tail == null) {
			System.out.println("A lista está vazia.");
			return null;
		}
		Node node = head; 
		T var = tail.data;
		if(head == tail) {
			head = null;
			tail = null;
		}else {
			while(node.next!=tail) {
				node = node.next;
			}
			tail = node;
			tail.next = null;
		}
		size--;
		return var;
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
		T var = node.data;
		if(head==tail){
			head = null;
			tail = null;
			size--;
		}else if(node==head) {
			removeFirst();
		}else if(node==tail) {
			removeLast();
		}else {
			Node newNode = head;
			while(newNode.next!=node) {
				newNode = newNode.next;
			}
			newNode.next = node.next;
			node = null;
			size--;
		}
		return var;
	}

	@Override
	public void show() {
		if(head==null) {
			System.out.println("A lista está vazia.");
		}else if(head==tail) {
			System.out.println(head.data); 
		}else {
			Node node = head;
			while(node.next!=null) {
				System.out.println(node.data);
				node = node.next;
			}
			System.out.println(node.data);
		}
	}

	@Override
	public void showReverse() {
	    if (head == null) {
	        System.out.println("A lista está vazia.");
	        return;
	    }

	    Node prev = null;
	    Node current = head;
	    Node nextNode;

	    while (current != null) {
	        nextNode = current.next;
	        current.next = prev;
	        prev = current;
	        current = nextNode;
	    }

	    head = prev;

	    Node temp = head;
	    while (temp != null) {
	        System.out.println(temp.data);
	        temp = temp.next;
	    }
	}




}
