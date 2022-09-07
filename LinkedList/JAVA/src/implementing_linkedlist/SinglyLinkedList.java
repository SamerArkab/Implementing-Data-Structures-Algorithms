package implementing_linkedlist;

public class SinglyLinkedList {
	Node head;

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public void insertHead(int newData) {
		if (head == null) {
			head = new Node(newData);
			return;
		}

		Node newHead = new Node(newData);
		newHead.next = head;
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
	}

	public void insertAfter(Node toInsertAfter, int newData) {
		if (toInsertAfter == null) {
			System.out.println("Node to insert new data after cannot be null.");
			return;
		}

		Node newNode = new Node(newData);
		newNode.next = toInsertAfter.next; // prevNode -> newNode -> nextNode
		toInsertAfter.next = newNode;
	}

	public void deleteByPosition(int position) {
		if (head == null) {
			System.out.println("Can't delete a non existent LL.");
			return;
		}

		Node iterHead = head;

		if (position == 0) {
			head = iterHead.next; // iterate to the next node, meaning to delete first (head) node
			return;
		}

		for (int i = 0; i < position - 1 && iterHead != null; i++)
			iterHead = iterHead.next;

		if (iterHead == null || iterHead.next == null) { // .next is the node to be deleted
			System.out.println("Node isn't in LL.");
			return;
		}

		Node next = iterHead.next.next; // "skip" (to delete) the node the user wants to delete
		iterHead.next = next;
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
		SinglyLinkedList linkedList = new SinglyLinkedList();

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