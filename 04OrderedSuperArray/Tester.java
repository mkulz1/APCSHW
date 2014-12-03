public class Tester{

    public static void main(String[] args){
	SuperArray tester = new SuperArray(10);
	tester.add("hi");
	tester.add("hello");
	tester.add("hola");
	tester.add("greetings");
	tester.add("apple");
	tester.add("zebra");
	System.out.println(tester);
	tester.insertionSort();
	System.out.println(tester);
    }

}
