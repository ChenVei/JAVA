import java.awt.*;
public class test
{
	public static void main(String[] args) {
		Frame f=new Frame("FlowLayout~");
		Button b1=new Button("one");Button b2=new Button("one");Button b3=new Button("one");
		f.add(b1);f.add(b2);f.add(b3);
		f.setLayout(new FlowLayout(FlowLayout.RIGHT));
		f.setVisible(true);
		f.setSize(400,400);

		Frame f2=new Frame("test");
		f2.setBounds(100,100,400,400);
		FlowLayout l=new FlowLayout(FlowLayout.CENTER,20,40);
		f2.setLayout(l);
		for (int i=0;i<10 ;i++ ) {
			f2.add(new Button("but"+i));
		}
		f2.setVisible(true);
	}
}
