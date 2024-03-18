package application;

public class QueueArray<T> implements InterfaceQueue<T> {
	
	private int sizeMax;
	private Object[] array;
	private int first;
	private int last;
	
	public QueueArray(int size) {
		this.sizeMax = size;
		this.array = new Object[size];
		this.first = -1;
		this.last = -1;
	}

	@Override
	public void add(T item) throws MyException {
		if(isFull()) {
			throw new MyException("A fila está cheia.");
		}
		if(first==-1) {
			first++;
			last++;
			array[first] = item;
		}else {
			last++;
			int var = (last) % sizeMax;
			array[var] = item;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove() throws MyException {
		if(isEmpty()) {
			throw new MyException("A fila está vazia.");
		}
		T removed = (T) array[first];
		if(first==last) {
			first = -1;
			last = -1;
		}else {
			int var = (first+1) % sizeMax;
			first = var;
		}
		return removed;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T peek() throws MyException {
		if(isEmpty()) {
			throw new MyException("A fila está vazia.");
		}	
		return (T) array[first];
	}

	@Override
	public boolean isEmpty() {
		if(first==-1) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isFull() {
		int var = (last+1) % sizeMax;
		if(var==first) {
			return true;
		}
		return false;
	}

	@Override
	public void show() {
		int i = first;
		if(first==-1) {
			return;
		}
		while(i!=last) {
			System.out.println(array[i]);
			i = (i+1) % sizeMax;
		}
		System.out.println(array[last]);
	}

}
