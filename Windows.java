package miniproject;

import java.awt.event.ActionListener;
import java.util.Properties;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.swing.JColorChooser;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.awt.Panel;
import  java.awt.event.ActionEvent;
import javax.activation.*;
import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.TextAction;
import javax.swing.undo.UndoManager;



  class GUI extends JFrame implements ActionListener {
	  
	JFrame window;
	//text area
	JTextArea textArea; 
	int i=1;
	JScrollPane scrollPane;
	boolean wordWrapOn = false;
	//menu
	JMenuBar menubar;
	JMenu menufile,menuedit,menuformat,menucolor,chooser,Share;
	// file menu
	JMenuItem inew,iopen,isave,isaveas,iexit,inewwindow;
	//format menu
	
	JMenuItem iWrap,iFontArial,iFontCSMS,iFontTNR,iFontSize8,iFontSize12,iFontSize16,iFontSize20,iFontSize24,iFontSize28;
	JMenuItem ihel,icour,idia,imono,iSans;
	JMenu menuFont, menuFontSize,files;
	// color menu
	JMenuItem icolor1,icolor2,icolor3,icolor4,icolor5,icolor6,Email;
	// edit menu
	JMenuItem iundo,iredo,copy,paste,cut;
	// recent 
	JMenuItem f1,f2,f3,f4,f5,f6,f7,f8,f9,f10;
	
	
		
	Function file = new Function(this);
	functionfont format = new functionfont(this);
	functioncolor color = new functioncolor(this);
	Fdit edit = new Fdit(this);
	UndoManager um = new UndoManager();
	email mail = new email(this);
	
	
 
	public GUI() {
		createWindow();
		createtextArea();
		createMenuBar();
		createFileMenu();
		createFormatMenu();
		createColorMenu();
		createEditMenu();
		colorchooser();
		Share();
		
		
		format.selectedFont = "Arial";
		format.createFont(16);
		format.wordWrap();
		color.changeColor("White");
		

		window.setVisible(true);
		
	}
	  
	
	public void createWindow() {
		window = new JFrame("Text Editor");
	    window.setSize(800,600);
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //window.getContentPane().setLayout(null);
	  /*  JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);
	    tab.setBounds(0,0,700,580);
	    window.getContentPane().add(tab);
	    Panel p1=new Panel();
	    tab.addTab("Tab 1", p1);
	    p1.setLayout(null);
	    JTextArea text1 = new JTextArea();
	    JScrollPane Scrollpane1 = new JScrollPane(text1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    p1.add(Scrollpane1);
	    Panel p2= new Panel();
	    tab.addTab("Tab 2", p2);
	    p2.setLayout(null);
	    JTextArea text2 = new JTextArea();
	    JScrollPane Scrollpane2 = new JScrollPane(text2,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    p2.add(Scrollpane2);
	    Panel p3 = new Panel();
	    tab.addTab("Tab 3", p3);
	    p3.setLayout(null);
	    JTextArea text = new JTextArea();
	    JScrollPane Scrollpane = new JScrollPane(text,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    p3.add(Scrollpane);
	*/  }

	

	public void createtextArea() {
		textArea = new JTextArea();
		textArea.getDocument().addUndoableEditListener(
				new UndoableEditListener() {
					public void undoableEditHappened(UndoableEditEvent e) {
						um.addEdit(e.getEdit());
					
 }			
				}); 
	
		
		scrollPane  = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		window.add(scrollPane);
	
	}
	
	
	private void addAction(TextAction action, int key, String text) {
	      action.putValue(AbstractAction.ACCELERATOR_KEY,
	              KeyStroke.getKeyStroke(key, InputEvent.CTRL_DOWN_MASK));
	      action.putValue(AbstractAction.NAME, text);
	      menuedit.add(new JMenuItem(action));
	      
	} 
	public void createMenuBar() {
		menubar = new JMenuBar();
		window.setJMenuBar(menubar);
		menufile = new JMenu("File");
		menubar.add(menufile);
		menuedit = new JMenu("Edit");
		menubar.add(menuedit);
		menuformat = new JMenu("Format");
		menubar.add(menuformat);
		menucolor = new JMenu("Color");
		menubar.add(menucolor);
		chooser = new JMenu("Color Chooser");
		menucolor.add(chooser);
		Share = new JMenu("Share");
		menubar.add(Share);
	}
	public void createFileMenu() {
		inew = new JMenuItem("New");
		inew.addActionListener(this);
	
		inew.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		inew.setActionCommand("New");
		menufile.add(inew);
		//inewwindow = new JMenuItem("New window");
		//inewwindow.addActionListener(this);
		//inewwindow.setActionCommand("New window");
		//menufile.add(inewwindow);
		iopen = new JMenuItem("Open");
		iopen.addActionListener(this);
		iopen.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		iopen.setActionCommand("Open");
		menufile.add(iopen);
		isave = new JMenuItem("Save");
		isave.addActionListener(this);
		isave.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		isave.setActionCommand("Save");
		menufile.add(isave);
		isaveas = new JMenuItem("Saveas");
		isaveas.addActionListener(this);
		isaveas.setActionCommand("Saveas");
		menufile.add(isaveas);
		iexit = new JMenuItem("Exit");
		iexit.addActionListener(this);
		iexit.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
		iexit.setActionCommand("exit");
		menufile.add(iexit);
		files = new JMenu("files...");
		files.addActionListener(this);
		files.setActionCommand("files");
		menufile.add(files);
		f1 = new JMenuItem("file1");
		f1.addActionListener(this);
		f1.setActionCommand("1");
		files.add(f1);
		f2 = new JMenuItem("file2");
		f2.addActionListener(this);
	
		f2.setActionCommand("2");
		files.add(f2);
		f3 = new JMenuItem("file3");
		f3.addActionListener(this);
        f3.setActionCommand("3");
		files.add(f3);
		f4 = new JMenuItem("file4");
		f4.addActionListener(this);
		
		f4.setActionCommand("4");
		files.add(f4);
		f5 = new JMenuItem("file5");
		f5.addActionListener(this);
	
		f5.setActionCommand("5");
		files.add(f5);
		f6 = new JMenuItem("file6");
		f6.addActionListener(this);
	f6.setActionCommand("6");
		files.add(f6);
		f7 = new JMenuItem("file7");
		f7.addActionListener(this);
	f7.setActionCommand("7");
		files.add(f7);
		f8 = new JMenuItem("file8");
		f8.addActionListener(this);f8.setActionCommand("8");
		files.add(f8);
		f9 = new JMenuItem("file9");
		f9.addActionListener(this); f9.setActionCommand("9");
		files.add(f9);
		f10 = new JMenuItem("file10");
		f10.addActionListener(this);
	
		f10.setActionCommand("10");
		files.add(f10);
		
		
	}
	public void createFormatMenu() {
		iWrap = new JMenuItem("Word wrap : off");
		iWrap.addActionListener(this);
		iWrap.setActionCommand("Word Wrap");
		menuformat.add(iWrap);
		
		menuFont = new JMenu("Font");
		menuformat.add(menuFont);
		menuFontSize = new JMenu("Font Size");
		menuformat.add(menuFontSize);
		iFontArial = new JMenuItem("Arial");
		iFontArial.addActionListener(this);
		iFontArial.setActionCommand("Arial");
		menuFont.add(iFontArial);
		
		iFontCSMS = new JMenuItem("Comic Sans MS");
		iFontCSMS.addActionListener(this);
		iFontCSMS.setActionCommand("Comic Sans MS");
		menuFont.add(iFontCSMS);
		
		iFontTNR = new JMenuItem("Times New Roman");
		iFontTNR.addActionListener(this);
		iFontTNR.setActionCommand("Times New Roman");
		menuFont.add(iFontTNR);
		
		ihel = new JMenuItem("Helvetica");
		ihel.addActionListener(this);
		ihel.setActionCommand("Helvetica");
	    menuFont.add(ihel);
	    
	   
	    icour = new JMenuItem("Courier");
		icour.addActionListener(this);
		icour.setActionCommand("Courier");
	    menuFont.add(icour);
	    
	    idia = new JMenuItem("Dialog");
		idia.addActionListener(this);
		idia.setActionCommand("Dialog");
	    menuFont.add(idia);
	    
	    iSans = new JMenuItem("SansSerif");
		iSans.addActionListener(this);
		iSans.setActionCommand("SansSerif");
	    menuFont.add(iSans);
	    
	    imono = new JMenuItem("Monospaced");
		imono.addActionListener(this);
		imono.setActionCommand("Monospaced");
	    menuFont.add(imono);
	    
 

	
	iFontSize8 = new JMenuItem("8");
	iFontSize8.addActionListener(this);
	iFontSize8.setActionCommand("size8");
	menuFontSize.add(iFontSize8);
	
	iFontSize12 = new JMenuItem("12");
	iFontSize12.addActionListener(this);
	iFontSize12.setActionCommand("size12");
	menuFontSize.add(iFontSize12);
	
	iFontSize16 = new JMenuItem("16");
	iFontSize16.addActionListener(this);
	iFontSize16.setActionCommand("size16");
	menuFontSize.add(iFontSize16);
	
	iFontSize20 = new JMenuItem("20");
	iFontSize20.addActionListener(this);
	iFontSize20.setActionCommand("size20");
	menuFontSize.add(iFontSize20);
	
	iFontSize24 = new JMenuItem("24");
	iFontSize24.addActionListener(this);
	iFontSize24.setActionCommand("size24");
	menuFontSize.add(iFontSize24);
	
	iFontSize28 = new JMenuItem("28");
	iFontSize28.addActionListener(this);
	iFontSize28.setActionCommand("size28");
	menuFontSize.add(iFontSize28);

	}
	public void createColorMenu() {
		icolor1 = new JMenuItem("White");
		icolor1.addActionListener(this);
		icolor1.setActionCommand("White");
		menucolor.add(icolor1);
		icolor2 = new JMenuItem("Black");
		icolor2.addActionListener(this);
		icolor2.setActionCommand("Black");
		menucolor.add(icolor2);
		icolor3 = new JMenuItem("Random");
		icolor3.addActionListener(this);
		icolor3.setActionCommand("Random");
		menucolor.add(icolor3);
		
	} public void colorchooser() {	
		icolor5 = new JMenuItem("Background colorchooser");
		icolor5.addActionListener(this);
		icolor5.setActionCommand("Background colorchooser");
		chooser.add(icolor5);
		
		icolor6 = new JMenuItem("Text colorchooser");
		icolor6.addActionListener(this);
		icolor6.setActionCommand("Text colorchooser");
		chooser.add(icolor6);
		menucolor.add(chooser);
	}
	public void createEditMenu() {
		iundo = new JMenuItem("Undo");
		iundo.addActionListener(this);
		iundo.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
		iundo.setActionCommand("Undo");
		menuedit.add(iundo);
		iredo = new JMenuItem("Redo");
		iredo.addActionListener(this);
		iredo.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		iredo.setActionCommand("Redo");
		menuedit.add(iredo);
		addAction(new DefaultEditorKit.CopyAction(), KeyEvent.VK_C, "Copy" );
		addAction(new DefaultEditorKit.CutAction(), KeyEvent.VK_X, "Cut" );
	     addAction(new DefaultEditorKit.PasteAction(), KeyEvent.VK_V, "Paste");

	}
	public void Share() {
		
		Email = new JMenuItem("Email");
		Email.addActionListener(this);
		Email.setActionCommand("Email");
		Share.add(Email);
	}


	
	public void actionPerformed(ActionEvent e) {
		String command  = e.getActionCommand();
		switch(command) {
		case "New": {
			int yesrno = JOptionPane.showConfirmDialog(null,"Do u need to a new window.","Confirm",JOptionPane.YES_NO_OPTION);
			if(yesrno == 0) {
				file.newfile();
			}
		}
			
	 break;
	/*	case "New window": {
			i++;
			new CreateTab();
			break;
		}
	*/
		case "Open": {
			int yesrno = JOptionPane.showConfirmDialog(null,"Do u need to open a file.","Confirm",JOptionPane.YES_NO_OPTION);
			if(yesrno == 0) {
				file.open();
			} break;
		}
		case "Save":  {
			int yesrno = JOptionPane.showConfirmDialog(null,"Do u need to a save the file.","Confirm",JOptionPane.YES_NO_OPTION);
			if(yesrno == 0) {
				file.save();
			}
			break;
		}
		case "Saveas":{
			int yesrno = JOptionPane.showConfirmDialog(null,"file already saved do u need to save again.","Confirm",JOptionPane.YES_NO_OPTION);
			if(yesrno == 0) {
				file.saveas();
			} break;
		}
	    case "exit":{
	    	int yesrno = JOptionPane.showConfirmDialog(null,"Do u need to exit.","Confirm",JOptionPane.YES_NO_OPTION);
			if(yesrno == 0) {
				file.exit();
			}break;
	    }
	    case "Undo": {edit.undo();
	     JOptionPane.showMessageDialog(null,"undo operation performed.");
			break;
	    }
	    case "Redo": {
	    	edit.redo();
		     JOptionPane.showMessageDialog(null,"redo operation performed.");
				break;
	    }
	    case "Word Wrap": {
	    	int yesrno = JOptionPane.showConfirmDialog(null,"Do u need to wrap a word.","Confirm",JOptionPane.YES_NO_OPTION);
			if(yesrno == 0) {
		
			format.wordWrap(); 
			}break;
	    }
	    case "size8":{
	    	format.createFont(8);
		    
	    }
	    case "size12": {
	    	
			format.createFont(12); 
			
	    }
	    case "size16": {
	
			
			format.createFont(16); 
		
	    }
	    case "size20": {
	    	
				
			format.createFont(20); 
	   
	    }
	    case "size24": {
	    	format.createFont(24);
	    }
	    case "size28": {
	    	format.createFont(28);
	    }
	    case "Arial": {
	    	format.setFont(command);
	    	break
		;
	    }
	    case "Comic Sans MS": {
	    	format.setFont(command);
	    }break;
	    case "Times New Roman": {
	    	format.setFont(command);
	    }break;
	    case "Helvetica": {
	    	format.setFont(command);
	    }break;
	    case "Dialog": {
	    	format.setFont(command);
	    }break;
	    case "Courier": {
	    	format.setFont(command);
	    }break;
	    case "SansSerif": {
	    		color.changeColor(command);
	    }break;
	    case "Monospaced": {
	    
	    	color.changeColor(command);
	    }break;
	    case "White":{
	    	color.changeColor(command);
	    }break;
	    case "Black":{
	    	color.changeColor(command);
	    }break;
	    case "Random":{
	    	color.changeColor(command);
	    }break;
	    case "Background colorchooser":{
	    	color.changeColor(command);
	    }
	    break;
	    case "Text colorchooser":{
	    	color.changeColor(command);
	    }
	    break;
	    case "1":Function.display(command); break;
	    case "2":Function.display(command); break;
	    case "3":Function.display(command); break;
	    case "4":Function.display(command); break;
	    case "5":Function.display(command); break;
	    case "6":Function.display(command); break;
	    case "7":Function.display(command); break;
	    case "8":Function.display(command); break;
	    case "9":Function.display(command); break;
	    case "10":Function.display(command); break;
	    case "Email": mail.Email();
	    
	}}
	

	


	
}