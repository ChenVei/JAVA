import java.awt.*;
public class test
{
	public static void main(String[] args) {
		Frame f=new Frame("Mixed-Layout~");
		Button[] bb=new Button[10];
		for (int i=0;i<10 ;i++ ) {
			bb[i]=new Button("but"+(i+1));
		}
		f.setLayout(new GridLayout(2,1));

		Panel p1=new Panel(new BorderLayout()),p2=new Panel(new BorderLayout()),p3=new Panel(new GridLayout(2,2));
		Panel p4=new Panel(new GridLayout(2,1));
		f.add(p1);f.add(p2);
		p1.add(bb[0],BorderLayout.EAST);p1.add(bb[1],BorderLayout.WEST);
		p4.add(bb[2]);p4.add(bb[3]);
		p1.add(p4,BorderLayout.CENTER);
		
		p2.add(bb[4],BorderLayout.EAST);p2.add(bb[5],BorderLayout.WEST);
		p2.add(p3,BorderLayout.CENTER);
		for (int i=6;i<10 ;i++ ) {
			p3.add(bb[i]);
		}
		
		f.setSize(400,400);
		f.setVisible(true);
	}
}
