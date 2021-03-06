import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * 
 * @author Bartek Lukasik
 * @version 2020-04-07
 * GridBagConstrain constructor generator
 * 
 */

@SuppressWarnings("serial")
public class GBC extends GridBagConstraints
{
	GBC(int gridx, int gridy)
	{
		this.gridx = gridx;
		this.gridy = gridy;
	}
	
	GBC(int gridx, int gridy, int gridwidth, int gridheight)
	{
		this.gridx = gridx;
		this.gridy = gridy;
		this.gridwidth = gridwidth;
		this.gridheight = gridheight;
	}
	
	public GBC setAnchor(int anchor)
	{
		this.anchor = anchor;
		return this;
	}
	
	public GBC setFill(int fill)
	{
		this.fill = fill;
		return this;
	}
	
	public GBC setWeight(int weightx, int weighty)
	{
		this.weightx = weightx;
		this.weighty = weighty;
		return this;
	}
	
	public GBC setInsets(int distance)
	{
		this.insets = new Insets(distance,distance,distance,distance);
		return this;
	}
	
	public GBC setInsets(int top, int left, int bottom, int right)
	{
		this.insets = new Insets(top,left,bottom,right);
		return this;
	}
	
	public GBC setIpad(int ipadx, int ipady)
	{
		this.ipadx = ipadx;
		this.ipady = ipady;
		return this;
	}
}
