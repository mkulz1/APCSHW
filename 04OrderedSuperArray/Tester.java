public class Tester{

    public static void main(String[] args){
	SuperArray tester = new SuperArray(10);
	tester.add("hi");
	tester.add("hello");
	tester.add("hola");
	tester.add("greetings");
	tester.add("apple");
	tester.add("zebra");
	tester.add("hola");
	System.out.println(tester);
	System.out.println(tester.find("hola"));
	//	long startTime = System.nanoTime();
	tester.insertionSort();
	System.out.println(tester);
	System.out.println(tester.find("hola"));
	/*	long endTime = System.nanoTime();
	System.out.println(tester);
	System.out.println();
	System.out.println(endTime - startTime);
	startTime = System.nanoTime();
	tester.badInsertionSort();
	endTime = System.nanoTime();
	System.out.println(endTime - startTime);*/

    }

}
