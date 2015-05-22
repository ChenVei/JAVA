import java.awt.*;
public class test
{
	public static void main(String[] args) {
		Frame f=new Frame("BorderLayout~");
		Button b1=new Button("1");Button b2=new Button("2");Button b3=new Button("3");
		Button b4=new Button("4");Button b5=new Button("5");
		f.add(b1,BorderLayout.NORTH);f.add(b2,BorderLayout.SOUTH);f.add(b3,BorderLayout.WEST);
		f.add(b4,BorderLayout.EAST);f.add(b5,BorderLayout.CENTER);
		//f.setLayout(new FlowLayout(FlowLayout.RIGHT));


		f.setVisible(true);
		try{
		Thread.sleep(1000);}
		catch(Exception e){};
		f.setSize(400,400);

	}
}
