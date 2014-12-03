import java.util.*;
import java.io.*;
public class Driver{
    public static void main(String[] args) {

        String rows = "20";
	String columns = "20";
	boolean fillRandomLetters = true;
	boolean isSeed = false;

	if (args.length == 2){
	    rows = args[0];
	    columns = args[1];
	}else if (args.length == 3){
	    rows = args[0];
	    columns = args[1];
	    isSeed = true;
	}else if (args.length == 4){
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

	WordGrid wordGrid = new WordGrid(Integer.valueOf(rows), Integer.valueOf(columns));
	if(isSeed){
	    wordGrid.setSeed(Long.valueOf(args[2]));
	}
	boolean check = false;
	do{
	    System.out.println("\nWelcome to MKULZ Word Search Generator!");
	    System.out.println("Choose a theme:");
	    System.out.println("a : Cities of the World");
	    System.out.println("b : Car Brands");
	    System.out.println("c : Animals");
	    Scanner start = new Scanner(System.in);
	    String theStart = start.nextLine();
	    
	    if(theStart.equals("a")){
		wordGrid.loadWordsFromFile("Cities.txt",fillRandomLetters);
		check = true;
	    }else if(theStart.equals("b")){
		wordGrid.loadWordsFromFile("Cars.txt",fillRandomLetters);
		check = true;
	    }else if(theStart.equals("c")){
		wordGrid.loadWordsFromFile("Animals.txt",fillRandomLetters);
		check = true;
	    }else{
		System.out.println("Please choose again!");
	    }
	}while(!check);
  
	System.out.println("\nFind the following words:");
	System.out.println(wordGrid.wordsInPuzzle() + "\n"); 
	System.out.println(wordGrid);		
    }
}


