package implementing_queue;

public class PriorityQueueLinkedList {
	class Node {
		int data;
		int priority;
		Node next;
	}

	public Node newNode(int d, int p) {
		Node tp = new Node();
		tp.data = d;
		tp.priority = p;
		tp.next = null;

		return tp;
	}

	// Return the value at head
	public int peek(Node head) {
		return head.data;
	}

	// Delete the element with the highest priority
	public Node delete(Node head) {
		head = head.next;
		return head;
	}

	public Node insert(Node head, int d, int p) {
		Node start = head;

		// Create new Node
		Node tp = newNode(d, p);
		if (head.priority > p) {
			// Insert New Node before head
			tp.next = head;
			head = tp;
		} else {
			while (start.next != null && start.next.priority < p)
				start = start.next;
			tp.next = start.next;
			start.next = tp;
		}
		return head;
	}

	public boolean isEmpty(Node head) {
		return (head == null) ? true : false;
	}

	public static void main(String args[]) {
		PriorityQueueLinkedList myPQLL = new PriorityQueueLinkedList();
		Node pq = myPQLL.newNode(4, 1);
		pq = myPQLL.insert(pq, 3, 3);
		pq = myPQLL.insert(pq, 2, 0);
		pq = myPQLL.insert(pq, 1, 0);

		while (!myPQLL.isEmpty(pq)) {
			System.out.print(myPQLL.peek(pq) + " ");
			pq = myPQLL.delete(pq);
		}
	}
}