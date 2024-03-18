package application;

public class StackArray<T> implements InterfaceStack<T> {
	
	private int sizeMax;
	private Object[] array;
	private int top;
	
	public StackArray(int size) {
		this.sizeMax = size;
		this.array = new Object[size];
		this.top = -1;
	}

	@Override
	public void push(T item) throws MyException {
		if(isFull()) {
			throw new MyException("A pilha está cheia.");
		}
		top++;
		array[top] = item;
	}

	@Override
	public T pop() throws MyException {
		if(isEmpty()) {
			throw new MyException("A pilha está vazia.");
		}
		T var = peek();
		top--;
		return var;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T peek() throws MyException {
		if(isEmpty()) {
			System.out.println("A pilha está vazia.");
		}
		return (T) array[top];
	}

	@Override
	public boolean isEmpty() {
		if(top==-1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if(top+1==sizeMax) {
			return true;
		}
		return false;
	}

	@Override
	public void show() {
		if(top==-1) {
			System.out.println("A pilha está vazia.");
		}else {
			for(int i = 0; i<=top; i++) {
				System.out.println(array[i]);
			}
		}
	}

}
