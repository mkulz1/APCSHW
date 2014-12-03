public class OrderedSuperArray extends SuperArray{
    int currentLength = 0;

    public OrderedSuperArray(){
	super();
    }
    public OrderedSuperArray(int size){
	super(size);
    }

    public void add(String o){
	int rightIndex = data.length;
	while( rightIndex>0 && get(rightIndex-1).compareTo(o) > 0 ){
	    rightIndex--;
	}
	// Find the right index, and then add it there.
	super.add(rightIndex,o);
    }

    public void add(int index, String o){
	add(o);
    }

    public String set(int index, String o){
	String s = get(index);
	remove(index);
	add(o);
	return s;
    }

    public static void main(String[] args){
	OrderedSuperArray byes = new OrderedSuperArray(4);
	byes.add("bye");
	byes.add("good day");
	byes.add("good bye");
	byes.add("adios");
	//	byes.add("see ya");
	System.out.println("Inside the array...");
	System.out.println(byes);
    }
}
