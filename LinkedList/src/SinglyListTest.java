import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class SinglyListTest {

	@Test
	void test() {
		SinglyList l1 = new SinglyList();
		
		l1.addAtFront(5);
		l1.addAtRear(10);
		l1.addAtFront(1);
		l1.addAtRear(20);
		
		int[] expected = { 1,5,10,20};
		assertArrayEquals(l1.getElements(),  expected);
		
		
	}

}
