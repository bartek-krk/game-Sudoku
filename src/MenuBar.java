import javax.swing.*;
import java.awt.event.*;

/**
 * 
 * @author Bartek Lukasik
 * @version 2020-04-07
 * Menu bar class
 *
 */

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar
{
	private JMenu moreMenu;
	
	MenuBar()
	{
		moreMenu = new JMenu("More");
		moreMenu.add(new About());
		moreMenu.add(new Author());
		add(moreMenu);
	}
	
	private class About extends AbstractAction
	{
		About()
		{
			putValue(Action.NAME, "About game");
			putValue(Action.SHORT_DESCRIPTION, "Game rules");
		}
		
		public void actionPerformed(ActionEvent event)
		{
			JOptionPane.showMessageDialog(getTopLevelAncestor(), "<html><font size=\"4\">Rules:</font><ol><li>No duplicates in each row</li><li>No duplicates in each column</li><li>No duplicates in each 3x3 square</li></ol></html>", "About game", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	private class Author extends AbstractAction
	{
		Author()
		{
			putValue(Action.NAME, "Author");
			putValue(Action.SHORT_DESCRIPTION, "Author's details and contact information");
		}
		
		public void actionPerformed(ActionEvent event)
		{
			JOptionPane.showMessageDialog(getTopLevelAncestor(), "<html>Author: Bartek Lukasik<br>Current version: 2020-04-07<br>Any enquiries: <a href=\"github.com/bartek-krk/\">github.com/bartek-krk/</a></html>", "Author", JOptionPane.PLAIN_MESSAGE);
		}
	}
}
