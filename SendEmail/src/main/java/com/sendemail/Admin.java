package com.sendemail;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Base64;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

	
	public class Admin  extends ebillop {	
		Connection c = null;
		String out2 = "";
		String out = "";
		String out1 = "";
		String out3 = "";
		String out4 = "";
		String out5 = "";
		String out6 = "";
		//connection
		public  Connection getConnection() {
			try {
				c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Billing", "root", "Kowsi@7");
				Statement st = c.createStatement();
			} catch (Exception e) {
			System.out.println(e);
			}
			return c;
			}
			
	//signup	
	       public void signup() throws SQLException {
	    	   Connection c = getConnection();
	    	   Statement st = c.createStatement();
	        	Scanner s = new Scanner(System.in);
	        	System.out.println("Enter user-id:");
	        	String Id = s.next();
	        	
	        	ResultSet rs1 = st.executeQuery("Select * from employee where Id='" + Id + "' ");
			       while (rs1.next()) {
			        out5= rs1.getString(1);
			      
			       }

			       if (out5.contains(Id)) {
			       System.out.println( "Already you have been registered");
			       signup();
			       }
			       ResultSet rs3 = st.executeQuery("Select * from customer where Id='" + Id + "' ");
			       while (rs3.next()) {
			        out6= rs3.getString(1);
			      
			       }

			       if (out6.contains(Id)) {
			       System.out.println( "Already you have been registered");
			       signup();
			       }
	        	System.out.println("Enter user-name:");
	        	String Name = s.next();
	        	System.out.println("Enter Number:");
	        	int Number = s.nextInt();
	        	
	        	System.out.println("Enter Email:");
	        	String Email = s.next();
	        
				    while(!(Email.length() > 10)&&!(Email.contains("@gmail.com"))) 
					  {
					     System.out.println("check your email it is incorrect \n Re-enter a valid email id:");
					     Email = s.next();
					  }
				    
				    
	        	System.out.println("Enter Address:");
	        	String Address = s.next();
	        	System.out.println("Enter Password:");
	        	String Password = s.next();
	        	String encodedInput = Base64.getEncoder().encodeToString(Password.getBytes());
	        	
	        	byte[] output = Base64.getDecoder().decode(encodedInput);
	        	String decodedResult = new String(output);
	        	


	        	   while (!(Password.matches(".*[a-z]{1,}.*") && Password.matches(".*[A-Z]{1,}.*") && Password.matches(".*[0-9]{1,}.*")
	        			&& Password.matches(".*[@#$()!~%^&|*?.,]{1,}.*") && (Password.length() <= 10) && (!Password.contains(" "))))
	        	    {
	        		   System.out.println("please use a strong password(uppercase,lowercase,special characters,numbers) \n Re-enter a valid Password :");
					   Password = s.next();
	        	     }
	        	  

	        	
	        	System.out.println("Enter the key:");
	        	Scanner sc2 = new Scanner(System.in);
	        	String key = sc2.next();
	        	
	        	ResultSet rs2 = st.executeQuery("Select * from employee where Email='" + Email + "' ");
	        	    while (rs2.next()) {
	        	         out = rs2.getString(4);
	        	    if (out.contains(Email)) {
	        	         System.out.println("MailId already exists ");       	
	        	        }
	        	      }       	
	        	    if (key.equals("employee"))
	        	      {        		
	        	        st.executeUpdate("Insert into employee(Id,Name,Number,Email,Address,Password,keyvalue) values('" + Id + "','" + Name + "','" + Number + "','" + Email + "','" + Address + "','" + encodedInput + "','employee')");
	        	        System.out.println("Data Entered Successfully");
	        	      }       	
	        	    else if(key.equals("customer")) {
	        	        st.executeUpdate("Insert into customer(Id,Name,Number,Email,Address,Password,keyvalue) values('" + Id + "','" + Name + "','" + Number + "','" + Email + "','" + Address + "','" + encodedInput + "','customer')");
	        	        System.out.println("Data Entered Successfully");
	        	      }
	        	    else
	        	       {
	        	        System.out.println("Invalid key");
	        	       }
	        	}
			      
	  //signin      	
		
	       public void signin() throws SQLException
	       {
	       	Connection c=getConnection();
	       int count=0;
	       Statement st=c.createStatement();
	       Scanner sc=new Scanner(System.in);
	       System.out.println("Enter Email:");
	       String Email=sc.next();
	       System.out.println("Enter Password:");
	       String Password = sc.next();
	       String encodedInput = Base64.getEncoder().encodeToString(Password.getBytes());
	       
	    	   Scanner sc2=new Scanner(System.in);
	       System.out.println("Enter the key:");
	       String key = sc2.next();
	     //employee login  
	       ResultSet rs1 = st.executeQuery("Select * from employee where Email='" + Email + "' ");
	       while (rs1.next()) {
	       out3 = rs1.getString(4);
	       out4=rs1.getString(6);
	       }
	       if (key.equals("employee"))   
	       if (out3.contains(Email)&& (out4.equals(encodedInput))) {
	       System.out.println("You are an Employee Login Successful");
	       Admin a= new Admin();
	       a.Employee();
	       a.electicity();
	      
	       }
	       else
	       {
	       System.out.println(" User not found");

	       }
	  //customer login
	       ResultSet rs = st.executeQuery("Select * from Customer where Email='" + Email + "' ");

	       while (rs.next()) {
	       out1 = rs.getString(4);
	       out2 = rs.getString(6);
	       }      
	       if (key.equals("customer"))
	       if (out1.equals(Email) && (out2.equals(encodedInput))) {
	       System.out.println("You are an Customer Login Successful ");
	       Admin a= new Admin();
	       a.Customer();
	       a.payment();
	       a.sendMail(Email);
	       }
	       else
	       {
	       System.out.println(" User not found");
	       }
	 }
	
	  //Main Method    
	    
	       public static void main(String args[]) throws SQLException {
	    	   Admin k = new Admin();
	    	   System.out.println(" Choose an option \n");
	    	   System.out.println("1. Signup \n 2. Signin");
	    	  
	    	   Scanner sc = new Scanner(System.in);
	    	   int ch = sc.nextInt();
	    	   int count = 0;
	    	   if (ch == 1) {
	    	   k.signup();
	    	   } else
	    	   k.signin();
	    	   }    	       	      
	}
		



