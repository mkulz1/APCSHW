import java.util.*;
import java.io.*;
import java.util.Random;

public class WordGrid{
    private char[][]data;
    private ArrayList<String> wordsInPuzzle = new ArrayList<String>();
    Random r = new Random();
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    
    /**Initializes the grid to the size specified and fills all of the positions
     *with spaces.
     *@param row is the starting height of the WordGrid
     *@param col is the starting width of the WordGrid
     */
    public WordGrid(int rows,int cols){
	data = new char[rows][cols];
	clear();
    }
    public WordGrid(){
	this(10,10);       // Default makes a 10x10 grid
    }

    /**Set all values in the WordGrid to spaces ' '
     */
    private void clear(){
	for(int rows = 0; rows < data.length; rows++){
	    for(int columns = 0; columns < data[rows].length; columns++){
		data[rows][columns] = ' ';
	    }
	}
    }

    /**Fills the grid with '_' spaces
     */
    public void fill(){
	for(int rows = 0; rows < data.length; rows++){
	    for(int columns = 0; columns < data[rows].length; columns++){
	        if(data[rows][columns] == ' '){
		    data[rows][columns] = '_';
		}
	    }
	}
    }
    
    
    
    /**The proper formatting for a WordGrid is created in the toStrisng.
     *@return a String with each character separated by spaces, and each row
     *separated by newlines.
     */
    public String toString(){
	String result = "";
	for(int rows = 0; rows < data.length; rows++){
	    for(int columns = 0; columns < data[rows].length; columns++){
		result += data[rows][columns] + " ";
	    }
	    result += "\n";
	}
	return result;
    }

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */

    private boolean addWord(String word,int row, int col, int dx, int dy){
	if (wordFits(word, row, col, dx, dy)){
	    for(int i = 0; i < word.length(); i++){
		data[row][col] = word.charAt(i);
		col += dx;
		row += dy;
	    }
	    wordsInPuzzle.add(word);
	    return true;
	}else{
	    return false;
	}
    }

    /**
     *Checks to see whether the word fits at the specified position
     *@param word is the word to be added to WordGrid
     *@param row is the vertical location of the first letter of the word
     *@param col is the horizontal location of the first letter of the word
     *@param dx is an integer between (-1,1) that shows the horizontal direction of the next letter
     *@param dy is an integer between (-1,1) that shows the vertical direction of the next letter
     *@return true if the word fits, false if it does not
     */
    private boolean wordFits(String word, int row, int col, int dx, int dy){
	if ((dx==0 && dy==0) ||
	    row < 0 || col < 0 ||
	    col + dx*word.length() > data[0].length ||
	    col + dy*word.length() > data.length){
	    return false;
	}
	for (int i = 0; i < word.length(); i++){
	    if (data[row][col] != ' ' && data[row][col] != word.charAt(i)){
		return false;
	    }
	    row += dy;
	    col += dx;
	}
	return true;
    }

    /** 
     *Tries to fit a word into the grid.
     *Tries 100 times before it gives up.
     *@param word that's being put in the grid.
     *@return true is the word was successfully fit into the grid, false if it was not.
     */
    public boolean addWordRandomly(String word){
	int tries = 100;
	boolean success;
	do{
	    success = addWord(word, r.nextInt(data.length),  r.nextInt(data[0].length), r.nextInt(3)-1, r.nextInt(3)-1);
	    tries--;
	    
	}while(!success && tries>0);
	return tries != 0;
    }

    /**
     *Imports the file with the list of words for the WordGrid
     *@param String name of file that contains the word list.
     *@param Boolean whether the solution should be shown. If true, solution is not shown. 
     */
    public void addWordFile(String file, boolean fillRandomLetters){

	try{
	    File WordList = new File(file);
	    Scanner in = new Scanner(WordList);
	    ArrayList<String> wordBank = new ArrayList<String>();
	    Random r = new Random();

	    while (in.hasNext()){
		wordBank.add(in.next());
	    }
	    // Fix this part!!!
	    for (int i = 0; i < wordBank.size(); i++){
		String wordi = wordBank.remove(r.nextInt(wordBank.size()));
		data.addWordRandomly(word);
	    }
	    System.out.println(data);
	    if (fillRandomLetters){
		fillUp();
	    }else{
		fill();
	    }

	}catch(FileNotFoundException e){

	    System.out.println("File Does Not Exist");

	}
    }

    public String[] addWordList(String[] wordBank){
	for(int w; i<wordBank.lengthl;i++ ){

	    if(addWordRandomly(w)){
		wordsInPuzzle.add(w);
	    }
	}
    }

    /**
     *Fills the empty spaces in the grid with random letters.
     */
    public void fillUp(){
	for(int rows = 0; rows < data.length; rows++){
	    for(int columns = 0; columns < data[rows].length; columns++){
	        if(data[rows][columns] == ' '){
		    data[rows][columns] = alphabet.charAt(r.nextInt(26));
		}
	    }
	}
    }

    public void setSeed(long s){
	r.setSeed(s);
    }
}

