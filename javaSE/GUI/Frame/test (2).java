import java.awt.*;
public class test
{
	public static void main(String[] args) {
		myFrame f1=new myFrame(100,100,200,200,Color.red);
		myFrame f2=new myFrame(300,100,200,200,Color.blue);
		myFrame f3=new myFrame(100,300,200,200,Color.yellow);
		myFrame f4=new myFrame(300,300,200,200,Color.pink);

	}
}
class myFrame extends Frame{
	static int id=1;
	myFrame(int a,int b,int c,int d,Color color){
		super("MyFrame"+(id++));
		setLocation(a,b);
		setSize(c,d);
		setBackground(color);
		setResizable(false);
		setLayout(null);
		setVisible(true);
	}

}