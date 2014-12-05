public class Tester{

    public static void main(String[] args){
	SuperArray tester = new SuperArray(100000);
	for(int i = 0; i < 100000; i++){
	    tester.add(i,String.valueOf(i));
	}
	tester.add("hi");
	tester.add("hello");
	tester.add("hola");
	tester.add("greetings");
	tester.add("apple");
	tester.add("zebra");
	tester.add("hola");

	System.out.println(tester);
	System.out.println(tester.find("hola"));

	tester.insertionSort();
	System.out.println(tester);
	System.out.println(tester.find("hola"));
        
    }

}
