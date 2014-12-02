import java.util.*;
import java.io.*;
public class Driver{
    public static void main(String[] args) {

        String rows = "10";
	String columns = "10";
	boolean fillRandomLetters = true;
	boolean isSeed = false;

	if (args.length == 2){
	    rows = args[0];
	    columns = args[1];
	}else if(args.length == 3){
	    rows = args[0];
	    columns = args[1];
	    isSeed = true;
	}else if(args.length == 4){
	    rows = args[0];
	    columns = args[1];
	    isSeed = true;
	    if (args[3].equals("1")){
		fillRandomLetters = false;
	    }
	}else{
	    System.out.println("To generate a WordSearch:");
	    System.out.println("[rows] & [columns] are your chosen dimensions of the puzzle");
	    System.out.println("[RandomSeed] is a random optional number");
	    System.out.println("[ShowSolution?]--> 1 if you want the answers. Leave blank if you do not.");
	    System.out.println("java Driver [rows] [columns] [RandomSeed] [ShowSolution?]");
	}

	WordGrid data = new WordGrid(Integer.valueOf(rows), Integer.valueOf(columns));
	if(isSeed){
	    data.setSeed(Long.valueOf(args[2]));
	}

	System.out.println("WordGrid:");
	System.out.println(data);
	data.addWordFile("WordList.txt",true);	
	
    }
}


