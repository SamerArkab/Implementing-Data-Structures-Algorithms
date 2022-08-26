package implementing_stack;

public class IntegerStack {
	private int top;
	private int size;
	private int stack[];

	IntegerStack(int size) {
		this.size = size; // stack's wanted size
		this.stack = new int[this.size];
		top = -1; // initialized to -1 in order to check whether the stack is empty or not
	}

	public void push(int newTop) {
		if (isFull()) {
			System.out.println("Stack is full. Overflow error!");
			System.exit(1);
			;
		}

		stack[++top] = newTop; // increase top by one then add newTop to stack[top]
		System.out.println("The new top integer is " + stack[top]);
	}

	public int pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty. System exit!");
			System.exit(1);
			;
		}

		System.out.println("Pop and return top integer: " + stack[top] + "\nNew top integer is: " + stack[top - 1]);
		return stack[top--]; // return the top integer then reduce top by one
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("Stack is empty. System exit!");
			System.exit(1);
			;
		}

		System.out.println("Top integer is: " + stack[top]);
		return stack[top];
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == (size - 1);
	}

	public void printStack() {
		System.out.println("Printing stack: ");
		for (int i = 0; i <= top; i++)
			System.out.println(stack[i]);
	}

	public static void main(String[] args) {
		IntegerStack stack = new IntegerStack(3);

		stack.push(1);
		stack.push(2);
		stack.push(3);

		stack.pop();

		stack.printStack();

		stack.peek();

		stack.push(3);
		stack.push(4);
	}
}