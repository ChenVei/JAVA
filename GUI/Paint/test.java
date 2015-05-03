import java.awt.*;
public class test
{
	public static void main(String[] args)
	{
		new MyFrame().launchFrame();
	}
}
class MyFrame extends Frame
{
	public void launchFrame()
	{
		setBounds(150,150,400,400);
		setVisible(true);
	}
	public void paint(Graphics g) //lowcase
	{
		Color c=g.getColor();
		g.setColor(Color.PINK);
		g.fillRect(20,20,30,30);
		g.fillOval(40,40,50,50);
		g.setColor(c);
	}
}