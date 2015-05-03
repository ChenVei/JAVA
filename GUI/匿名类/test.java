import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class test
{
	public static void main(String[] args)
	{
		new MyFrame("xxx");
	}
}
class MyFrame extends Frame
{	
	MyFrame(String s){
		super(s);
		setLayout(null);
		setBackground(new Color(204,204,204));
		setBounds(300,300,400,300);
		setVisible(true);
		addWindowListener(new MyWindowMonitor(){ //Anonymous class
			public void windowClosing(WindowEvent e){
			setVisible(false);
			System.exit(0);
			}
		});
	}

}
/*class MyWindowMonitor extends WindowAdapter{
	public void windowClosing(WindowEvent e){
		setVisible(false);
		System.exit(0);
	}
}
*/