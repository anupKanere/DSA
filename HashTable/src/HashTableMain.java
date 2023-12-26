import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

class HashTable {
	static class Pair {
		private int key;// key
		private String value;// value--- can make student as whole object

		public Pair(int key, String value) {
			super();
			this.key = key;
			this.value = value;
		}

		public Pair() {
			key = 0;
			value = "";
		}

		@Override
		public String toString() {
			return "pair [key=" + key + ", value=" + value + "]";
		}

	}

	private static final int SLOTS = 10;
	private LinkedList<Pair> table[];

	public HashTable() {
		table = new LinkedList[SLOTS];
		for (int i = 0; i < SLOTS; i++)
			table[i] = new LinkedList<>();

	}

	public void put(int key, String value) {
		int slot = hash(key);
		LinkedList<Pair> bucket= table[slot];
		for (Pair pair : bucket) {
			if(key == pair.key) {
				pair.value = value;
				return;
			}
		}
		
		Pair pair = new Pair(key, value);
		bucket.add(pair);

	}

	public String get(int key) {
		int slot = hash(key);
		LinkedList<Pair> bucket = table[slot];
		for (Pair pair : bucket) {
			if (key == pair.key)
				return pair.value;
		}
		return null;
	}

	public int hash(int key) {

		return key % SLOTS;
	}

}

public class HashTableMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		HashTable ht = new HashTable();

		ht.put(1, "AB");
		ht.put(2, "AC");
		ht.put(3, "AD");
		ht.put(4, "AE");
		ht.put(5, "AF");
		ht.put(6, "AG");
		ht.put(7, "AH");
		ht.put(8, "AH");
		ht.put(9, "AH");
		ht.put(10, "AH");
		ht.put(11, "11");
		ht.put(11, "11-1");

		System.out.println("Enter roll no to find ");
		int rollNo = sc.nextInt();
		String name = ht.get(rollNo);
		System.out.println("Name found : " + name);
		
		
		sc.close();
	}

}
