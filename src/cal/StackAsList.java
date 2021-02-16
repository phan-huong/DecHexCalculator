package cal;

public class StackAsList<T> implements ADTStack<T> {

	private Node top = null;
	
	private class Node{
		T value;
		Node next;
		
		public Node(T value) {
			this.value = value;
		}
	}
	
	@Override
	public void push(T value) throws Overflow {
		Node node = new Node(value);
		if(this.isEmpty()) {
			top = node;
		} else {
			node.next = this.top;
			this.top = node;
		}
	}

	@Override
	public T pop() throws Underflow {
		if(top == null) {
			throw new Underflow();
		} else {
			T value = this.top.value;
			top = top.next;
			return value;
		}
	}

	@Override
	public T top() throws Underflow {
		if(top == null) {
			throw new Underflow();
		}else {
			return this.top.value;			
		}
	}

	@Override
	public boolean isEmpty() {
		return this.top == null;
	}
	
}
