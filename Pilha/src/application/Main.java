package application;

public class Main {

	public static void main(String[] args) throws MyException {
		
		StackLinked<Integer> mystack = new StackLinked<>(5);
		
		System.out.println(mystack.isEmpty());
		
		mystack.push(10);
		
		System.out.println(mystack.isEmpty());
		
		System.out.println(mystack.peek());

		System.out.println(mystack.pop());
		
		mystack.push(15);

		System.out.println(mystack.peek());
		
		mystack.push(10);
		mystack.push(18);
		mystack.push(19);
		mystack.push(16);

		System.out.println(mystack.isFull());
		
		System.out.println(mystack.peek());
		
		System.out.println(mystack.pop());

		System.out.println(mystack.peek());
		
		System.out.println("Função show: ");
		
		mystack.show();
		
		System.out.println("-----------------------------------");
		
		System.out.println(mystack.pop());
		System.out.println(mystack.pop());
		System.out.println(mystack.pop());
		System.out.println(mystack.pop());
		
		System.out.println(mystack.isEmpty());


	}

}
