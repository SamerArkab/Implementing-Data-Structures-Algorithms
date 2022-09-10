package implementing_hashtable;

import java.util.Hashtable;

// Use of an instance of Hash Table class in JAVA
public class HashTableUse {
	public static void main(String[] args) {
		Hashtable<Integer, Integer> myHt = new Hashtable<Integer, Integer>();
		int key = 0;
		
		System.out.println(myHt.isEmpty());
		
		while (key != 5) {
			myHt.put(key, key*2);
			key++;
		}
		
		//Some examples of Hashtable methods:
		System.out.println(myHt.isEmpty());
		System.out.println(myHt.toString());
		System.out.println(myHt.hashCode());
		System.out.println(myHt.containsValue(4));
		System.out.println(myHt.size());
		myHt.clear();
		System.out.println(myHt.isEmpty() + " " + myHt.size());
	}
}