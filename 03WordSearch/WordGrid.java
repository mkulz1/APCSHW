public class WordGrid{
    private char[][]data;

    /**Initialize the grid to the size specified and fill all of the positions
     *with spaces.
     *@param row is the starting height of the WordGrid
     *@param col is the starting width of the WordGrid
     */
    public WordGrid(int rows,int cols){
	data = new char[rows][cols];
	clear();
    }
    public WordGrid(){
	this(6,6);       // Default makes a 6x6 grid
    }

    /**Set all values in the WordGrid to spaces ' '*/
    private void clear(){
	for(int rows = 0; rows < data.length; rows++){
	    for(int columns = 0; columns < data[rows].length; columns++){
		data[rows][columns] = ' ';
	    }
	}
    }
    private void fill(){
	for(int rows = 0; rows < data.length; rows++){
	    for(int columns = 0; columns < data[rows].length; columns++){
		data[rows][columns] = '_';
	    }
	}
    }

    /**The proper formatting for a WordGrid is created in the toString.
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
    public boolean addWordHorizontal(String word,int row, int col){
	return true;
    }

    //vertical + diagonal should be implemented as well.

    public static void main(String[] args) {
	WordGrid data = new WordGrid(6,6);
	System.out.println(data);
	data.fill();
	System.out.println(data);
    }
}

