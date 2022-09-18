package implementing_queue;

import java.util.PriorityQueue;

public class PriorityQueueHeap {
	public static void main(String[] args) {
		PriorityQueue<Integer> myPQH = new PriorityQueue<Integer>();
		myPQH.add(5);
		myPQH.add(0);
		myPQH.add(10);
		myPQH.add(15);

		System.out.println(myPQH.peek());
		myPQH.remove();
		System.out.println(myPQH.toString());
	}
}