import java.util.*;

/**
 * 
 * @author Bartek Lukasik
 * @version 2020-04-06
 * Complete sudoku board with randomly generated digits
 *
 */


public class SudokuBoard
{
	private ArrayList<Integer> initBox;		//initializes 3x3 box with random values
	private ArrayList<Integer> nextBox;		//buffer for remaining 3x3 boxes
	private ArrayList<Integer> completeBoard;		//complete, usable sudoku board with all digits filled in
	
	SudokuBoard()
	{
		initBox = makeInitBox();
		completeBoard = initBox;
		for(int i=1;i<9;i++)		//joins boxes in full sudoku board
		{
			nextBox = makeNextBox(initBox,i);
			for(int j=0;j<9;j++) completeBoard.add(nextBox.get(j));
		}
		nextBox = null;
	}
	
	private ArrayList<Integer> makeInitBox()		//returns 3x3 box of random digits
	{
		ArrayList<Integer> returnList = new ArrayList<Integer>();	//buffer
		ArrayList<Integer> possibleNumbers = new ArrayList<Integer>();	//container for remaining possible digits (single sampling)
		
		for(int i=1;i<=9;i++) possibleNumbers.add(i);	//fills container with [1,9] ints
		
		while(!possibleNumbers.isEmpty())		//terminates single sampling when container is empty
		{
			int index = new Random().nextInt(possibleNumbers.size());	//chooses available index in container
			returnList.add(possibleNumbers.get(index));
			possibleNumbers.remove(index);		//removes used digit from container (single sampling)
		}
		
		return returnList;
	}
	
	private ArrayList<Integer> makeNextBox(ArrayList<Integer> parentBox, int tail)
	{
		ArrayList<Integer> returnBox = new ArrayList<Integer>();	//buffer
		
		for(int i=9-tail;i<9;i++) returnBox.add(parentBox.get(i));		//adds digits to next box (see: readme)
		for(int i=0;i<9-tail;i++) returnBox.add(parentBox.get(i));
		return returnBox;
	}
	
	
	public ArrayList<Integer> getFullSudokuBoard() {return completeBoard;}		//access method for completed board
}
