import java.awt.*;
import java.awt.event.*;
public class test
{
	public static void main(String[] args) {
		Frame f=new Frame("ActionEvent~");
		Button b=new Button("Press!");
		Button bb=new Button("OK!");
		f.add(b);
		f.add(bb);
		f.setLayout(new GridLayout(2,1));
		Monitor m=new Monitor();
		b.addActionListener(m);
		bb.addActionListener(m);
		b.setActionCommand("Yes,you are right!");

		f.setSize(400,400);
		f.setVisible(true);
	}
}
class Monitor implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("Hello world~");
		System.out.println(e);
		System.out.println(e.getActionCommand());
	}
}