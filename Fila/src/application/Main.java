package application;

public class Main {

	public static void main(String[] args) throws MyException {
		QueueLinked<Integer> myQueue = new QueueLinked<>(5);
		
		myQueue.add(1);
		
		System.out.println("-----------------------------");
		
		myQueue.show();
		
		myQueue.add(2);
		myQueue.add(3);
		myQueue.add(4);
		myQueue.add(5);
		
		System.out.println(myQueue.remove());
		
		System.out.println("-----------------------------");
		
		myQueue.show();
		
		System.out.println(myQueue.peek());

		System.out.println(myQueue.getSize());
	}

}
