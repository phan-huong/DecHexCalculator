package cal;

public interface ADTStack<T> {
	
	public void push(T obj) throws Overflow;
	public T pop() throws Underflow;
	public T top() throws Underflow;
	public boolean isEmpty();
}
