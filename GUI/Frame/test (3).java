import java.awt.*;
public class test
{
	public static void main(String[] args) {
		Frame f=new Frame("java with panel~");
		f.setBounds(300,300,500,500);
		f.setLayout(null);
		f.setBackground(new Color(0,0,120));
		Panel p=new Panel(null);
		p.setBounds(50,50,400,400);
		p.setBackground(new Color(204,204,255));
		f.add(p);
		f.setVisible(true);
		MyFrame my=new MyFrame("Hello World~",200,200,400,400);
	}
}
class MyFrame extends Frame{
	MyFrame(String s,int a,int b,int c,int d)
	{
		super(s);
		Panel p1,p2,p3,p4;
		p1=new Panel(null);p2=new Panel(null);p3=new Panel(null);p4=new Panel(null);
		p1.setBounds(0,0,c/2,d/2);p2.setBounds(c/2,0,c/2,d/2);p3.setBounds(0,d/2,c/2,d/2);p4.setBounds(c/2,d/2,c/2,d/2);
		p1.setBackground(Color.green);p2.setBackground(Color.pink);p3.setBackground(Color.black);p4.setBackground(Color.red);
		add(p1);add(p2);add(p3);add(p4);
		setBounds(a,b,c,d);
		setVisible(true);
	}

}