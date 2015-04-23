import java.awt.*;
public class test
{
	public static void main(String[] args) {
		Frame f=new Frame("BorderLayout~");
		Button b1=new Button("1");Button b2=new Button("2");Button b3=new Button("3");
		Button b4=new Button("4");Button b5=new Button("5");
		f.setLayout(new GridLayout(3,2));

		f.add(b1);f.add(b2);f.add(b3);f.add(b4);f.add(b5);
		f.setVisible(true);
		try{
		Thread.sleep(1000);}
		catch(Exception e){};
		f.setSize(400,400);

	}
}
