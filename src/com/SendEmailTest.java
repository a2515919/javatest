package com;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class SendEmailTest {

    public static void main(String[] args)throws GeneralSecurityException {
        //receiver's email address
        String receiver ="1021501992@qq.com";
        //sender's email address
        String sender ="41241622@qq.com";
        //the email host
        String host="smtp.qq.com";
        //get the system's properties
        Properties properties=System.getProperties();
        //set email server
        properties.setProperty("mail.smtp.host",host);
        properties.put("mail.smtp.auth","true");
        MailSSLSocketFactory sslf=new MailSSLSocketFactory();
        sslf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.ssl.socketFactory",sslf);
        Session session= Session.getDefaultInstance(properties, new Authenticator() {

            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("41241622@qq.com","biecjbwaydfgbhci");
            }
        });
        try{
            //create the object of MimeMessage
            MimeMessage message=new MimeMessage((session));
            //Set the head field
            message.setFrom(new InternetAddress(sender));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(receiver));
            //SET THE TITLE
            message.setSubject("THIS IS THE SUBJECT LINE!");
            //SET THE TEXT BODY
            message.setText("this email is send by zhou to test java email api!"
            );

            Transport.send(message);

            System.out.println("This is the email from java email test by Zhou!" +
                    "hello  email");



        }catch (MessagingException mex){
            mex.printStackTrace();
        }


    }
}
