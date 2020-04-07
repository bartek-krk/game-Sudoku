import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.*;

/**
 * 
 * @author Bartek Lukasik
 * @version 2020-04-07
 * Graphic panel to be filled in with numbers
 *
 */

@SuppressWarnings("serial")
public class SudokuPanel extends JComponent
{
	private ArrayList<Rectangle2D> grid = new ArrayList<Rectangle2D>();
	private int currentField = 0;
	private ArrayList<Integer> boardtoDraw;

	SudokuPanel(ArrayList<Integer> board)
	{
		this.boardtoDraw = board;
		addMouseMotionListener(new MouseMotionHandler());
		addMouseListener(new MouseHandler());
		for(int y=10;y<450;y+=50) for(int x=10;x<150;x+=50) grid.add(new Rectangle2D.Double(x, y, 50, 50));		//loops adding cells to grid
		for(int y=10;y<450;y+=50) for(int x=160;x<300;x+=50) grid.add(new Rectangle2D.Double(x, y, 50, 50));
		for(int y=10;y<450;y+=50) for(int x=310;x<450;x+=50) grid.add(new Rectangle2D.Double(x, y, 50, 50));
	}
	
	public int getCurrentField() {return this.currentField;}
	
	@Override
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		for(Rectangle2D rect : grid) g2.draw(rect);
		g2.setStroke(new BasicStroke(6f));
		for(int x=10;x<450;x+=150) for(int y=10;y<450;y+=150) g2.draw(new Rectangle2D.Double(x,y,150,150));
		g2.setColor(Color.LIGHT_GRAY);
		g2.fill(grid.get(currentField));
		g.setColor(Color.BLACK);
		g.setFont(new Font("SansSerif",Font.PLAIN,55));
		for(int i=0;i<grid.size();i++)
		{
			if(this.boardtoDraw.get(i) != null) g.drawString(this.boardtoDraw.get(i).toString(), (int) grid.get(i).getX()+7, (int) grid.get(i).getY()+45);
		}
	}
	
	@Override
	public Dimension getPreferredSize() {return new Dimension(470,470);}
	
	public Rectangle2D whereIs(Point2D location)
	{
		for(Rectangle2D rect : grid)
		{
			if(rect.contains(location)) return rect;
		}
		return null;
	}
	
	private class MouseMotionHandler implements MouseMotionListener		//mouse motion listener
	{
		public void mouseMoved(MouseEvent event)
		{
			if(whereIs(event.getPoint()) == null) setCursor(Cursor.getDefaultCursor());
			if(whereIs(event.getPoint()) != null)
			{
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		}
		public void mouseDragged(MouseEvent event) {}
	}
	
	public class MouseHandler extends MouseAdapter		//mouse click listener
	{
		public void mouseClicked(MouseEvent event)
		{
			if(event.getClickCount() > 0)
			{
				currentField = grid.indexOf(whereIs(event.getPoint()));
				repaint();
			}
		}
	}
	
}
