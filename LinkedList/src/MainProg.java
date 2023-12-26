import java.util.Arrays;

public class MainProg {
	public static void main(String[] args)
	{
		SinglyList l1 = new SinglyList();
		
		l1.addAtFront(5);
		l1.addAtRear(10);
		l1.addAtFront(1);
		l1.addAtRear(20);
		
		System.out.println(Arrays.toString(l1.getElements()));
	}
	
}
