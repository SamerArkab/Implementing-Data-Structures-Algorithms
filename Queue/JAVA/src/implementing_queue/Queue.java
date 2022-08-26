package implementing_queue;

public class Queue {
	private int size;
	private int queue[];
	private int front, rear;

	public Queue(int size) {
		this.size = size;
		queue = new int[size];
		front = -1;
		rear = -1;
	}

	public void enqueue(int newRear) {
		if (isFull()) {
			System.out.println("Queue is full. Can't enqueue new value, " + newRear);
			return;
		}

		if (front == -1)
			front = 0;
		rear++;
		queue[rear] = newRear;
		System.out.println("New element in queue (enqueued): " + queue[rear]);
	}

	public int dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty.");
			return -1;
		}

		int elementToRet = queue[front];
		System.out.println("Front element removed from queue (dequeued): " + queue[front]);
		if (front == rear) { // queue contains one element
			front = -1;
			rear = -1;
		} else
			front++;
		return elementToRet;
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("Queue is empty.");
			return -1;
		}
		return queue[front];
	}

	public boolean isEmpty() {
		return (front == -1) && (rear == -1);
	}

	public boolean isFull() {
		return (front == 0) && (rear == (this.size - 1));
	}

	public void printQueue() {
		if (isEmpty()) {
			System.out.println("Queue is empty.");
			return;
		}
		for (int i = front; i <= rear; i++)
			System.out.print(queue[i] + "	");
		System.out.println();
	}

	public static void main(String[] args) {
		Queue queue = new Queue(3);

		queue.printQueue();

		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);

		queue.enqueue(4);

		queue.printQueue();

		System.out.println(queue.isEmpty());
		System.out.println(queue.isFull());

		queue.dequeue();
		queue.dequeue();

		queue.printQueue();

		System.out.println(queue.peek());

		queue.dequeue();

		queue.printQueue();
		queue.dequeue();

		System.out.println(queue.isEmpty());
		System.out.println(queue.isFull());
	}
}