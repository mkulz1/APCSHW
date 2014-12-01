public class OrderedSuperArray extends SuperArray{
    int currentLength = 0;

    public OrderedSuperArray(){
	super();
    }
    public OrderedSuperArray(int size){
	super(size);
    }

    public void add(String o){
	super.add(o);
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
