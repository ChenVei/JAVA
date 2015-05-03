import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class test{
	public static void main(String[] args){
		new MyFrame();
	}
}
class MyFrame extends Frame{
	Frame f=new Frame("test");
	Button bt=new Button("fuck!!");
	TextField tf=new TextField(10);
	MyFrame(){
		f.add(bt,BorderLayout.NORTH);
		f.add(tf,BorderLayout.SOUTH);

		bt.addActionListener(new ActionListener(){
			private int i;
			public void actionPerformed(ActionEvent e){
				tf.setText(e.getActionCommand() + ++i);
			}
		});
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(-1);
			}
		});
		f.pack();
		f.setVisible(true);
	} 
}