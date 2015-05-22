import java.awt.*;
import java.awt.event.*;
public class test
{
	public static void main(String[] args) {
		new TFFrame("1111").launchFrame();
		
	}
}
class TFFrame extends Frame
{
	TextField a,b,c;
	TFFrame(String s)
	{super(s);}
	public void launchFrame()
	{
		a=new TextField(10);b=new TextField(10);c=new TextField(15);
		Label d=new Label("+");
		Button e=new Button("=");
		e.addActionListener(new MyMonitor(this));
		setLayout(new FlowLayout());
		add(a);add(d);add(b);add(e);add(c);
		setLocation(200,200);
		pack();
		setVisible(true);
	}
}
class MyMonitor implements ActionListener{
	TFFrame tf=null;
	MyMonitor(TFFrame tf)
	{this.tf=tf;}
	public void actionPerformed(ActionEvent e)
	{
		int a=Integer.parseInt(tf.a.getText());
		int b=Integer.parseInt(tf.b.getText());
		//tf.c.setText(""+(a+b));
		tf.c.setText(String.valueOf(a+b));
	}
}