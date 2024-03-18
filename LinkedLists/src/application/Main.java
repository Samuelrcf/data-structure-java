package application;

public class Main {

	public static void main(String[] args) {

		MyLinkedListDouble<Integer> list = new MyLinkedListDouble<>();
		
		list.addLast(7);
		list.addFirst(6);
		list.addFirst(5);
		list.addFirst(4);
		list.addFirst(2);
		
		list.addAfter(3, 2);
		
		System.out.println(list.peekFirst());
		
		list.addAfter(8, 7);
		
		System.out.println(list.peekLast());
		
		System.out.println("-----------------------------");
		
		list.show();
		
		System.out.println("-----------------------------");

		list.showReverse();
		
		System.out.println("-----------------------------");
		
		list.removeFirst();
		
		System.out.println("-----------------------------");
		
		list.show();
		
		list.removeLast();
		
		System.out.println("-----------------------------");
		
		list.show();
		
		list.remove(5);
		
		System.out.println("-----------------------------");
		
		list.show();
		
		System.out.println("-----------------------------");

		list.showReverse();
		
		System.out.println("-----------------------------");
		
		System.out.println(list.peekLast());
		System.out.println(list.peekFirst());
	}

}
