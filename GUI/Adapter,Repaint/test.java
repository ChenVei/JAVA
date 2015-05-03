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
	ArrayList<Point> points = null;
	MyFrame(String s){
		super(s);
		points=new ArrayList<Point>();
		setLayout(null);
		setBackground(new Color(204,204,204));
		setBounds(300,300,400,300);
		setVisible(true);
		addMouseListener(new Monitor());
	}

	public void paint(Graphics g) 
	{
		Iterator<Point> i=points.iterator();
		while(i.hasNext()){
			Point p=i.next();
			g.setColor(Color.YELLOW);
			g.fillOval(p.x,p.y,10,10);
		}
	}
	public void addPoint(Point p){
		points.add(p);
	}
}
class Monitor extends MouseAdapter{
	public void mousePressed(MouseEvent e){
		MyFrame f = (MyFrame)e.getSource();
		f.addPoint(new Point(e.getX(),e.getY()));
		f.repaint();
	}

}