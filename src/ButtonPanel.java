import javax.swing.*;

/**
 * 
 * @author Bartek Lukasik
 * @version 2020-05-22
 * Button panel to choose entered numbers
 *
 */

@SuppressWarnings("serial")
public class ButtonPanel extends JPanel
{
	private ButtonGroup numbersGroup;
	private Integer buttonPressed;
	
	ButtonPanel()
	{
		buttonPressed = 1;
		numbersGroup = new ButtonGroup();
		for(int i=1;i<10;i++) createButton(i);
	}

	private void createButton(int label)
	{
		String number = ((Integer) label).toString();
		JRadioButton button = new JRadioButton(number, label==1);
		button.addActionListener(event -> this.buttonPressed = label);
		numbersGroup.add(button);
		add(button);
	}
	
	public Integer getButtonPreseed() {return this.buttonPressed;}
}
