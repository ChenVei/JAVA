import java.awt.*;
import java.awt.event.*;
public class test
{
	public static void main(String[] args) {
		TFFrame f=new TFFrame("TestField");
		
	}
}
class TFFrame extends Frame
{
	TFFrame(String s)
	{
	super(s);
	TextField tf=new TextField();
	add(tf);
	tf.addActionListener(new TFActionListener());
	pack();
	tf.setEchoChar('*');
	setVisible(true);
	}
}
class TFActionListener implements ActionListener{
	public void actionPerformed(ActionEvent e)
	{
		TextField tf=(TextField)e.getSource();
		System.out.println(tf.getText());
		tf.setText("");
	}
}