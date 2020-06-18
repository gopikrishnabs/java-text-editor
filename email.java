package miniproject;

import java.awt.FileDialog;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
class email {
	static GUI gui;
	String filename,fileaddress;
	File temp;
	public static void main(String args[])  {	
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
	 new GUI();
	}});
	}
	public email(GUI gui) {
		email.gui = gui;
	}
	
	
	public void Email() {
		
		if(gui.textArea.getText()!=null) {
		send(Function.sendAddress());
		}
		else {
		FileDialog fd = new FileDialog(gui.window,"Select File",FileDialog.LOAD);
		fd.setVisible(true);
		if(fd.getFile()!=null) {
			filename = fd.getFile();
			fileaddress = fd.getDirectory();
		}
		fd.setTitle("Select File...");
		send(fileaddress+filename);
		}
	}
public void send(String temp) {
	
	String fromemail = "gk776040@gmail.com";
	String toemail = "gk776040@gmail.com";
	String password = "Gk77604091@2";

		Properties properties = new Properties();
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.starttls.enable","true");
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.port",587);
		try{
			Session session = Session.getDefaultInstance(properties,
				new javax.mail.Authenticator()
		{
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromemail,password);
			} 
		});
		MimeMessage msg = new MimeMessage(session);
		
		
			
		
			msg.setFrom(new InternetAddress(fromemail));
			msg.addRecipient(Message.RecipientType.TO,new InternetAddress(toemail));
			msg.setSubject("Mail from Text Editor");
			msg.setText("Hello");
		Multipart emailContent = new MimeMultipart();
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText("Greetings..");
			MimeBodyPart pdfattachment = new MimeBodyPart();
		try {
			pdfattachment.attachFile(temp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			emailContent.addBodyPart(textBodyPart);
			emailContent.addBodyPart(pdfattachment);
			msg.setContent(emailContent);
			Transport.send(msg);
			JOptionPane.showMessageDialog(null,"Shared succesfully.");
		}catch(MessagingException e) {
			e.printStackTrace();}
		
	} 
}
