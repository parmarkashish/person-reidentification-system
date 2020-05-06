package com.personreidentification.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.GroupGrantee;
import com.amazonaws.services.s3.model.Permission;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.personreidentification.dao.LoginDAO;
import com.personreidentification.service.RegisterService;
import com.personreidentification.service.VideoService;

public class BaseMethod {
	
	final static String ACCESSKEY = "";
	final static String SECRETKEY = "";
	final static String BUCKETNAME = "";
	@Autowired
	LoginDAO loginDAO;
	
	
	
	public static String getDate(){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
	    return formatter.format(date);
	}
	
	
	public static File convertToFile(MultipartFile file,String path) throws IOException {		
		byte[] bytes=file.getBytes();
		String fileName=file.getOriginalFilename();
		File folder=new File(path,"files");
		if(!folder.exists()){
			folder.mkdir();
		}		
		File temp=new File(folder,fileName);
		FileOutputStream fileOutputStream=new FileOutputStream(temp);		
		fileOutputStream.write(bytes);		
		fileOutputStream.close();		
		return temp;
	}
	public static String getUserName(){		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().
				getPrincipal();
		return user.getUsername();
	}

	public static String saveToS3(File temp,String s3Folder) {
		String key = s3Folder+"/"+temp.getName();
		BasicAWSCredentials awsCredentials = new BasicAWSCredentials(ACCESSKEY, SECRETKEY);
		AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new StaticCredentialsProvider(awsCredentials)).withRegion(Regions.US_EAST_2).build();
		PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKETNAME,key,temp);
		AccessControlList acl=new AccessControlList();
		acl.grantPermission(GroupGrantee.AllUsers, Permission.Read);
		putObjectRequest.setAccessControlList(acl);		
		s3.putObject(putObjectRequest);
		String link = s3.getUrl(BUCKETNAME, key).toString();
		return link;		
	}
	
	public static String generatePassword() {
		int n = 8;
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz"; 
        StringBuilder sb = new StringBuilder(n); 
        for (int i = 0; i < n; i++) { 
            int index  = (int)(AlphaNumericString.length()* Math.random()); 
            sb.append(AlphaNumericString.charAt(index)); 
        } 
        return sb.toString(); 
	}
	
	public static void sendMail(String receiver,String securityKey,String userName){

		final String from = "noreply.personreidentification@gmail.com";
		final String username = "";
		final String password = "2020@BE$";

		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		props.put("mails.smtp.ssl.trust","smtp.gmail.com");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(receiver));
			message.setSubject("Approve ");
			
			
			/*
			 * int num = 0; String pass = ""; for (int i = 0; i < 4;
			 * i++) { num = (int) (Math.random() * 10); pass += num; }
			 * 
			 * System.out.println(pass);
			 * 
			 * s.setAttribute("password", pass);
			 */

			message.setText("Hello ,  " + userName + " your password is " + securityKey 
					 );

			Transport.send(message);

			System.out.println("Sent message successfully....");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	
	

}
