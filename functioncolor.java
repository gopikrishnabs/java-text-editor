package miniproject;


import java.awt.Color;
import java.util.Random;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public  class functioncolor {
	GUI gui;
	JFrame frame = new JFrame();
	JFrame frame1 = new JFrame();
	JPanel jpanel1;
	JPanel jpanel;
	JColorChooser jcc;
	JColorChooser jcc1;

	
public functioncolor(GUI gui){
	this.gui =gui;
}
public int random(){
	Random r = new Random();
	int x = 50*r.nextInt(5); 
	return x;
}

public void changeColor(String color) {
	switch(color) {
	case "White": gui.window.getContentPane().setBackground(Color.white);
	gui.textArea.setBackground(Color.white);
	gui.textArea.setForeground(Color.black);
		break;
	case "Black": gui.window.getContentPane().setBackground(Color.black);
	gui.textArea.setBackground(Color.black);
	gui.textArea.setForeground(Color.white);
		break;
	case "Random": 
		gui.window.getContentPane().setBackground(new Color(random(),random(),random()));
	gui.textArea.setBackground(new Color(random(),random(),random()));
	gui.textArea.setForeground(new Color(random(),random(),random()));
		break;
	case"Background colorchooser":{
		
		 Backgroundcolor b=new Backgroundcolor();
		 b.jcolorchooser();
	}break;
	case"Text colorchooser":{
		
		Foregroundcolor c= new Foregroundcolor();
		c.jcolorchooser();
	}break;		
	
	}	
	

	

}


class Foregroundcolor implements ChangeListener {
	 Color getColor;
 public void jcolorchooser() {
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.setSize(630,270);
	jpanel = new JPanel();
	frame.getContentPane().setBackground(Color.BLACK);
	jcc= new JColorChooser();
	jcc.getSelectionModel().addChangeListener(this);
	jcc.setPreviewPanel(new JPanel());
	jpanel.setBounds(50,50,50,50);
	jpanel.setBackground(Color.white);
	frame.add(jpanel);
	jpanel.add(jcc);
	frame.setVisible(true);

}
 
 public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
	
			  getColor = jcc.getColor(); 
			 gui.textArea.setForeground(getColor);
		 
	}
}
 

class Backgroundcolor implements ChangeListener {
	 
public void jcolorchooser() {
	
	frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame1.setSize(630,270);
	jpanel1 = new JPanel();
	frame1.getContentPane().setBackground(Color.BLACK);
	jcc1= new JColorChooser();
	jcc1.getSelectionModel().addChangeListener(this);
	jcc1.setPreviewPanel(new JPanel());
	jpanel1.setBounds(50,50,50,50);
	jpanel1.setBackground(Color.white);
	frame1.add(jpanel1);
	jpanel1.add(jcc1);
	frame1.setVisible(true);

}

public void stateChanged(ChangeEvent e) {
	// TODO Auto-generated method stub
 Color getColor;
	  getColor = jcc1.getColor(); 
	  gui.textArea.setBackground((getColor));
}


}

}


