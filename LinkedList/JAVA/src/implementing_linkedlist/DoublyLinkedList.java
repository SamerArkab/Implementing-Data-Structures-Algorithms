package implementing_linkedlist;

public class DoublyLinkedList {
	Node head;

	class Node {
		int data;
		Node next;
		Node prev;

		Node(int data) {
			this.data = data;
			next = null;
			prev = null;
		}
	}

	public void insertHead(int newData) {
		if (head == null) {
			head = new Node(newData);
			return;
		}

		Node newHead = new Node(newData);
		newHead.next = head;
		if (head != null)
			head.prev = newHead;
		head = newHead;
	}

	public void insertTail(int newData) {
		Node newTail = new Node(newData);

		if (head == null) { // there's no head node, create it using the new data
			head = new Node(newData);
			return;
		}

		newTail.next = null;
		Node last = head; // iterate to the tail of the existing LL
		while (last.next != null)
			last = last.next;
		last.next = newTail;
		newTail.prev = last;
	}

	public void insertAfter(Node toInsertAfter, int newData) {
		if (toInsertAfter == null) {
			System.out.println("Node to insert new data after cannot be null.");
			return;
		}

		Node newNode = new Node(newData);
		newNode.next = toInsertAfter.next; // prevNode -> newNode -> nextNode
		toInsertAfter.next = newNode;
		newNode.prev = toInsertAfter;

		if (newNode.next != null)
			newNode.next.prev = newNode;
	}

	public void deleteByPosition(int position) {
		if (head == null) {
			System.out.println("Can't delete a non existant LL.");
			return;
		}

		Node iterHead = head;

		if (position == 0) {
			head = iterHead.next; // iterate to the next node, meaning to delete first (head) node
			head.prev = null;
			return;
		}

		for (int i = 0; i < position - 1 && iterHead != null; i++)
			iterHead = iterHead.next;

		if (iterHead == null || iterHead.next == null) {
			System.out.println("Node isn't in LL.");
			return;
		}

		Node temp = iterHead;

		// iterHead.next != null
		iterHead.next = temp.next.next;

		// now iterHead.next == previously iterHead.next.next
		if (iterHead.next != null)
			iterHead.next.prev = temp.prev;
	}

	public boolean search(Node head, int data) {
		Node iterHead = head;
		while (iterHead != null) {
			if (iterHead.data == data)
				return true;
			iterHead = iterHead.next;
		}
		return false;
	}

	// Use Merge-Sort:
	public Node getMid(Node head) {
		if (head == null)
			return head;

		Node slow = head;
		Node fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public Node sortMergeLL(Node head) {
		if (head == null || head.next == null)
			return head;

		Node mid = getMid(head);
		Node nextMid = mid.next;

		mid.next = null;

		Node left = sortMergeLL(head);
		Node right = sortMergeLL(nextMid);

		Node sortedLL = merge(left, right);
		return sortedLL;
	}

	public Node merge(Node a, Node b) { // merge left and right lists
		Node merged = null;

		if (a == null)
			return b;
		if (b == null)
			return a;

		if (a.data <= b.data) {
			merged = a;
			merged.next = merge(a.next, b);
		} else {
			merged = b;
			merged.next = merge(a, b.next);
		}

		return merged;
	}

	public void printLL() {
		Node iterHead = head;
		while (iterHead != null) {
			System.out.print(iterHead.data + "	");
			iterHead = iterHead.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		DoublyLinkedList linkedList = new DoublyLinkedList();

		linkedList.insertHead(5);
		linkedList.insertAfter(linkedList.head, 1);
		linkedList.insertTail(0);
		linkedList.insertAfter(linkedList.head.next, 7);
		linkedList.insertAfter(linkedList.head.next.next, 10);

		linkedList.printLL();

		linkedList.deleteByPosition(1);

		linkedList.printLL();

		Node sortedHead = linkedList.sortMergeLL(linkedList.head);
		linkedList.head = sortedHead;
		linkedList.printLL();
	}
}