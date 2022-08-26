package implementing_queue;

public class DequeCircularQueue {
	private int deque[];
	private int size;
	private int front, rear;

	public DequeCircularQueue(int size) {
		this.size = size;
		deque = new int[size];
		front = -1;
		rear = -1;
	}

	public void enqueueFront(int newElement) {
		if (isFull()) {
			System.out.println("Queue is full. Can't enqueue new value, " + newElement);
			return;
		}

		if (front == -1) {
			front = 0;
			rear = 0;
		} else if (front == 0) // front is at first index of queue
			front = size - 1;
		else
			front--;
		deque[front] = newElement;
		System.out.println("New element in queue (enqueued front): " + deque[front]);
	}

	public void enqueueRear(int newElement) {
		if (isFull()) {
			System.out.println("Queue is full. Can't enqueue new value, " + newElement);
			return;
		}

		if (front == -1) {
			front = 0;
			rear = 0;
		} else if (rear == size - 1) // meaning rear is at the last position of the queue
			rear = 0;
		else
			rear++;
		deque[rear] = newElement;
		System.out.println("New element in queue (enqueued rear): " + deque[rear]);
	}

	public int dequeueFront() {
		if (isEmpty()) {
			System.out.println("Queue is empty.");
			return -1;
		}

		int elementToRet = deque[front];
		System.out.println("Front element removed from queue (dequeued): " + deque[front]);
		if (front == rear) {// only one element in queue
			front = -1;
			rear = -1;
		} else if (front == size - 1)
			front = 0;
		else
			front++;

		return elementToRet;
	}

	public int dequeueRear() {
		if (isEmpty()) {
			System.out.println("Queue is empty.");
			return -1;
		}

		int elementToRet = deque[rear];
		System.out.println("Rear element removed from queue (dequeued): " + deque[rear]);
		if (front == rear) {
			front = -1;
			rear = -1;
		} else if (rear == 0)
			rear = size - 1;
		else
			rear--;

		return elementToRet;
	}

	public int peekFront() {
		if (isEmpty()) {
			System.out.println("Queue is empty.");
			return -1;
		}
		return deque[front];
	}

	public int peekRear() {
		if (isEmpty()) {
			System.out.println("Queue is empty.");
			return -1;
		}
		return deque[rear];
	}

	public boolean isEmpty() {
		return front == -1;
	}

	public boolean isFull() {
		return ((front == 0 && rear == size - 1) || (front == rear + 1));
	}

	public void printDeque() {
		if (isEmpty()) {
			System.out.println("Queue is empty.");
			return;
		}
		int i;
		for (i = front; i != rear; i = (i + 1) % size)
			System.out.print(deque[i] + "	");
		System.out.println(deque[i]);
	}

	public static void main(String[] args) {
		DequeCircularQueue deque = new DequeCircularQueue(3);

		deque.printDeque();

		deque.enqueueFront(1);
		deque.enqueueFront(2);
		deque.enqueueRear(3);
		deque.enqueueRear(4);

		System.out.println(deque.peekFront());
		System.out.println(deque.peekRear());
		deque.printDeque();

		deque.dequeueRear();
		deque.enqueueFront(4);
		deque.enqueueRear(5);

		deque.printDeque();
		System.out.println(deque.isFull());
		deque.dequeueRear();
		deque.printDeque();
		System.out.println(deque.isFull());
		System.out.println(deque.isEmpty());
	}
}