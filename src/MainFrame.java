import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author Bartek Lukasik
 * @version 2020-04-07
 *
 */

@SuppressWarnings("serial")
public class MainFrame extends JFrame
{	
	private BoardToFill game = new BoardToFill();
	private ButtonPanel buttons = new ButtonPanel();
	private SudokuPanel board = new SudokuPanel(game.getBoardToFill());
	private JButton applyButton = new JButton("Apply");
	private int mistakes = 0;		//stores number of mistakes made by the user

	MainFrame()
	{
		setTitle("Sudoku");
		setLayout(new GridBagLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		add(new MenuBar(), new GBC(0,0).setFill(GBC.HORIZONTAL));
		add(board, new GBC(0,1));
		add(buttons, new GBC(0,2));
		applyButton.addActionListener(event -> update());
		add(applyButton, new GBC(0,3).setFill(GBC.HORIZONTAL));
		pack();
		setVisible(true);
	}
	
		
	private void update()		//updates sudoku grid with entered numbers
	{
		if(buttons.getButtonPreseed() != null)
		{
			if(game.getBoardToFill().get(board.getCurrentField()) == null)
			{
				if(buttons.getButtonPreseed() == game.getFullSudokuBoard().get(board.getCurrentField()))
				{
					game.getBoardToFill().set(board.getCurrentField(), buttons.getButtonPreseed());
					repaint();
					buttons.resetButtonPressed();
					if(!game.getBoardToFill().contains(null))	//pops message when board is completed and shows number of mistakes made
					{
						JOptionPane.showMessageDialog(this, "Congratulations! You made: " + ((Integer) mistakes).toString() + " mistakes.", "YOU WON!", JOptionPane.INFORMATION_MESSAGE);
						System.exit(0);
					}
				}
				else		//pops dialog window if entered number is incorrect
				{
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(this, "Wrong number!", "Warning", JOptionPane.WARNING_MESSAGE);
					mistakes++;
				}
			}
			else		//pops dialog window if user tries to amend fixed number
			{
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(this, "You cannot change pre-defined number!", "Warning", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}