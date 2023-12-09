package com.login.utilities;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {
	public static void main(String[] args) {

        // Set up mail server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Set up the session
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // Replace "your_email@gmail.com" with your Gmail email address
                // Replace "your_password" with your Gmail password
                return new PasswordAuthentication("", "");
            }
        });

        try {
            // Create a default MimeMessage object
            Message message = new MimeMessage(session);

            // Set From: header field of the header
            message.setFrom(new InternetAddress(""));

            // Set To: header field of the header
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(""));

            // Set Subject: header field
            message.setSubject("Testing JavaMail API");

            // Now set the actual message
            message.setText("Hello, this is a test email from JavaMail API!");

            // Send the message
            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

