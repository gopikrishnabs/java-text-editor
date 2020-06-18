package miniproject;

import java.awt.FileDialog;
import java.io.*;
import java.io.FileReader;
import java.io.BufferedReader;
import javax.swing.*;

 public class Function{
	static GUI gui;
	static String fileName;
	static String fileAddress;
	private static String s[]= new String [10];
	int f=0,r=0,capacity=10;
	
public Function(GUI gui) {
	Function.gui=gui;
}
public void newfile() {
	gui.textArea.setText("");
	gui.window.setTitle("New");

	 fileName = null;
	fileAddress = null;
}

public void open() {
	FileDialog fd = new FileDialog(gui.window,"Open",FileDialog.LOAD);
	fd.setVisible(true);
	
	if(fd.getFile()!= null) {
		fileName=fd.getFile();
		fileAddress = fd.getDirectory();
	
  stackimplement(fileAddress+fileName);
		gui.window.setTitle(fileName);
	}
	
	try { System.out.println(fileName+fileAddress);
		BufferedReader br = new BufferedReader(new FileReader(fileAddress+fileName)); // you need a address to read a file.
		gui.textArea.setText("");
		String line = null;
		while((line = br.readLine())!=null) {
			gui.textArea.append(line+"\n");
		}
		br.close();
		}catch(Exception e) {
		System.out.println("File not opened");	
		}
	
	
}
public static String sendAddress() {
	return fileAddress+fileName;
}

public void save() {
	if(fileName==null) {
		saveas();
	}
	else {
		try {		
			System.out.println(fileName+fileAddress);
			FileWriter fw= new FileWriter(fileAddress + fileName);
			
		fw.write(gui.textArea.getText()); 
		gui.window.setTitle(fileName);
		fw.close();
		
			
		}catch(Exception e) {
			System.out.println("someting went wrong");
		}
	}
}
public void saveas() {
	
	FileDialog fd= new FileDialog(gui.window,"Save",FileDialog.SAVE);
	fd.setVisible(true);
	if(fd.getFile()!=null) {
		fileName = fd.getFile();
		fileAddress = fd.getDirectory();
		gui.window.setTitle(fileName);
	stackimplement(fileAddress+fileName);
	System.out.println(fileName+fileAddress);
	}
	try {
		
		FileWriter fw= new FileWriter(fileAddress + fileName);
		fw.write(gui.textArea.getText());
		fw.close();
	}catch(Exception e) {
		System.out.println("someting went wrong");
	}
}
public void exit() {
 System.exit(0);
} 
public  void stackimplement(String file) {
	if(r==capacity) {f++;
	
		r++;
	}
	else {
		s[r]=file; 
		r++;
	}
}



public static void display(String e) {
	 int i=Integer.parseInt(e);
	 String fA=s[i-1];
	
	 try {
		 System.out.println(fA);
		 BufferedReader br = new BufferedReader(new FileReader(fA)); // you need a address to read a file.
			gui.textArea.setText("");
			String line = null;
			while((line = br.readLine())!=null) {
				gui.textArea.append(line+"\n");
			}
			br.close();
	
	
		}catch(Exception c) {
			System.out.println("someting went wrong");
		}

	
}
}
