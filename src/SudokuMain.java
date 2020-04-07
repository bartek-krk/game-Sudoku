import java.awt.EventQueue;

/**
 * 
 * @author Bartek Lukasik
 * @version 2020-04-07
 * Program's main method
 *
 */

public class SudokuMain
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(() ->{
			new MainFrame();
		});
	}

}
