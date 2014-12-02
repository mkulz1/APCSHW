import java.util.*;
import java.io.*;
public class Driver{
    public static void main(String[] args) {

	int rows = 10;
	int columns = 10;
	boolean fillRandomLetters = true;
	boolean isSeed = false;

	if (args.length == 2){
	}


	WordGrid data = new WordGrid(rows, columns);
	if(isSeed){
	    data.setSeed(Long.valueOf(args[2]));
	}

	System.out.println("WordGrid:");
	System.out.println(data);
	data.addWordFile("WordList.txt",true);	
	
    }
}


