package com.Utilities;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtility {
	
	public void sendEmail(int num, String... emailDetails) {
		//String to = "dodomdos@gmail.com";// change accordingly
		//get the variable arguments
		String to="",from="",setSubject="",firstName="",lastName="",exceptionState="";
		
		for(int s = 0;s < emailDetails.length ;s++)
		{
			//first parameter is fromemailId
			//second parameter set subject
			//third parameter first name
			//fourth parameter second name
			//fifth parameter toemailId
			
			if(s==1)
				from = emailDetails[1];// change accordingly
			else if(s==2)
				setSubject = emailDetails[2];
			else if(s==3)
				firstName= emailDetails[3];
			else if(s==4)
				lastName = emailDetails[4];
			else if(s == 0)
				to = emailDetails[0];
			else
				exceptionState = emailDetails[s];
		}
		
		final String username = "dodomdos";// change accordingly
		final String password = "dodomdos12";// change accordingly

		// Assuming you are sending email through relay.jangosmtp.net
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// Set Subject: header field
			message.setSubject(setSubject);

			// Now set the actual message
			if (num == 1) {
				message.setText("Can you please reset the password for " + from);
			}else if(num == 2) {
				String testIs = "Can you add the user with the details : First Name : " 
						+ firstName + "\t Last Name : "+ lastName + 
						" \t email the password to " + from ;
				message.setText(testIs);
			}else {
				message.setText("Message from unknown functionality");
			}
			// Send message
			Transport.send(message);

			System.out.println("Sent message successfully....");
			
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
