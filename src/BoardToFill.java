import java.util.*;

/**
 * 
 * @author Bartek Lukasik
 * @version 2020-03-06
 * Sudoku board with blanked cells
 *
 */

public class BoardToFill extends SudokuBoard
{
	private ArrayList<Integer> sudokuToFill;		//blanked sudoku grid
	
	@SuppressWarnings("unchecked")		//casting is safe due to fixed input type
	BoardToFill() {sudokuToFill = deleteNumbers((ArrayList<Integer>) super.getFullSudokuBoard().clone());}
	
	public ArrayList<Integer> getBoardToFill() {return this.sudokuToFill;}		//allows access to blanked grid
	
	private ArrayList<Integer> deleteNumbers(ArrayList<Integer> inputList) 		//sets chosen numbers to null
	{
		for(int i : chooseRandomGrid()) inputList.set(i, null);
		return inputList;
	}
	
	private ArrayList<Integer> chooseRandomGrid()		//chooses random sudoku fields to blank
	{
		ArrayList<Integer> returnList = new ArrayList<Integer>();		//buffer
		while(returnList.size() < 31)
		{
			int nextNumber = new Random().nextInt(80);
			if(!returnList.contains(nextNumber)) returnList.add(nextNumber);
		}
		return returnList;
	}
}
