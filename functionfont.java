package miniproject;

import java.awt.Font;

public class functionfont {

	GUI gui;
	Font arial,comicSansMS,timesNewRoman,Helvetica,Courier,Dialog,SansSerif,Monospaced;
	String selectedFont;
	functionfont(GUI gui){
		this.gui = gui;
	}
	public void wordWrap() {
		if(gui.wordWrapOn==false) {
			gui.wordWrapOn=true;
			gui.textArea.setLineWrap(true);
			gui.textArea.setWrapStyleWord(true);
			gui.iWrap.setText("Word Wrap : on");
		}
		else if(gui.wordWrapOn==true) {
			gui.wordWrapOn=false;
			gui.textArea.setLineWrap(false);
			gui.textArea.setWrapStyleWord(false);
			gui.iWrap.setText("Word Wrap : off");
		}
	}
	void createFont(int FontSize) {
		arial = new Font("Arial", Font.PLAIN,FontSize);
	comicSansMS = new Font("Comic Sans MS", Font.PLAIN,FontSize);
	timesNewRoman = new Font("Times New Roman", Font.PLAIN,FontSize);
	Helvetica = new Font("Helvetica",Font.PLAIN,FontSize);
	Courier = new Font("Courier",Font.PLAIN,FontSize);
	Dialog = new Font("Dialog",Font.PLAIN,FontSize);
	SansSerif = new Font("SansSerif",Font.PLAIN,FontSize);
	Monospaced = new Font("Monospaced",Font.PLAIN,FontSize);
	setFont(selectedFont);
	}
	void setFont(String Font) {
		selectedFont=Font;
		switch(selectedFont) {
		case "Arial": 
			
			gui.textArea.setFont(arial);
			break;
		
		case "Comic Sans MS":
			gui.textArea.setFont(comicSansMS);
			break;
		case "Times New Roman":
			gui.textArea.setFont(timesNewRoman);
			break;
		case "Helvetica":
			gui.textArea.setFont(Helvetica);
			break;
		case "Courier":
			gui.textArea.setFont(Courier);
			break;
		case "SansSerif":
			gui.textArea.setFont(SansSerif);
			break;
			
		case "Dialog":
			gui.textArea.setFont(Dialog);
			break;
		case "Monospaced":
			gui.textArea.setFont(Monospaced);
			break;
			
		}
	}
	
}