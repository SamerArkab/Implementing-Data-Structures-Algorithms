package implementing_queue;

public class IntegerCircularQueue {
	private int size;
	private int Cqueue[];
	private int front, rear;

	public IntegerCircularQueue(int size) {
		this.size = size;
		Cqueue = new int[size];
		front = -1;
		rear = -1;
	}

	public void enqueue(int newElement) {
		if (isFull()) {
			System.out.println("Queue is full. Can't enqueue new value, " + newElement);
			return;
		}

		if (front == -1)
			front = 0;
		rear = (rear + 1) % size; // increase rear using modulo
		Cqueue[rear] = newElement;
		System.out.println("New element in queue (enqueued): " + Cqueue[rear]);
	}

	public int dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty.");
			return -1;
		}

		int elementToRet = Cqueue[front];
		System.out.println("Front element removed from queue (dequeued): " + Cqueue[front]);
		if (front == rear) {
			front = -1;
			rear = -1;
		} else
			front = (front + 1) % size; // increase front using modulo
		return elementToRet;
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("Queue is empty.");
			return -1;
		}
		return Cqueue[front];
	}

	public boolean isEmpty() {
		return (front == -1) && (rear == -1);
	}

	public boolean isFull() {
		if (front == 0 && rear == size - 1) // "normal" full queue
			return true;
		else if (front == rear + 1) // queue is full through a circular insertion
			return true;
		return false;
	}

	public void printCQueue() {
		if (isEmpty()) {
			System.out.println("Queue is empty.");
			return;
		}
		int i;
		for (i = front; i != rear; i = (i + 1) % size)
			System.out.print(Cqueue[i] + "	");
		System.out.println(Cqueue[i]);
	}

	public static void main(String[] args) {
		IntegerCircularQueue cQueue = new IntegerCircularQueue(3);

		cQueue.printCQueue();

		cQueue.enqueue(1);
		cQueue.enqueue(2);
		cQueue.enqueue(3);
		cQueue.enqueue(4);

		System.out.println(cQueue.peek());
		cQueue.printCQueue();

		cQueue.dequeue();
		cQueue.enqueue(4);
		cQueue.enqueue(5);

		cQueue.printCQueue();
	}
}