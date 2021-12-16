package com.sendemail;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.time.LocalDate;
	import java.time.Month;
	import java.time.format.DateTimeFormatter;
	import java.util.Calendar;
	import java.util.Date;
	import java.util.Locale;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

	public class ebillop  {
		Connection c = null;
		int prevr,curr;
		
		//connection
	public Connection getConnection() {
			
			try {
				c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Billing", "root", "Kowsi@7");
			} catch (Exception e) {
			System.out.println(e);
			}
			return c;
			}

		

	//employee
		
		public void Employee() throws SQLException {
			Connection c = getConnection();
			Statement st=c.createStatement();
		
			System.out.println("View all Customers");
			ResultSet rs=st.executeQuery("select*from Customer");
			System.out.println("Id"+"\t\t" +"Name"+"\t\t"+"Previous"+ "\t\t"+"Connection" + "\t\t" +"BillAmount" +"" );
			while(rs.next())
			{
				
				System.out.println(rs.getString(1)+"\t\t" +rs.getString(2)+"\t\t"  + rs.getString(9) + "\t\t\t" + rs.getString(10) + "\t\t\t" + rs.getString(11) + " ");
			}
			
			}
		
		
		//customer	
		
		 public void Customer()throws SQLException{
		   		Connection c = getConnection();
		   		Statement st=c.createStatement();
		   		Scanner sc1 = new Scanner(System.in);
		   		System.out.println("Enter Id:");
		   	       String Id=sc1.next();
		   		System.out.println("View bill");
		   		ResultSet rs=st.executeQuery("select*from Customer where Id='"+Id+"'");
		   		while(rs.next())
		   		{
		   			System.out.println("Your Profile is: " + "\n"+ "Id:"+rs.getString(1) + "\n" +"Name:"+ rs.getString(2) + "\n"
		   					+"Number:"+ rs.getString(3) + "\n"+"Email:"+ rs.getString(4) + "\n" +"Address:"+ rs.getString(5) + "\n" 
		   					 +"Keyvalue::"+ rs.getString(7) + "\n"+"Previous:" + rs.getString(8) + "\n"+"Current:" + rs.getString(9) + "\n"+"Connection:" + rs.getString(10) + "\n" +"BillAmount:" + rs.getString(11) + "\n");
		   		}
		   		
		   		
		   	}
		 
		 
		 
		//electricity 
		 
		public void electicity() {
			try {
				Connection c = getConnection();
				Statement st=c.createStatement();
			double units,amount=0;
			String cno,cname,conn;
			int prevr,curr = 0;
			Scanner input=new Scanner(System.in);
			System.out.println("Enter Customer no:");
			cno=input.next();
			System.out.println("Enter Customer name:");
			cname=input.next();
			System.out.println("Enter prev month reading:");
			prevr=input.nextInt();
			
			System.out.println("Enter Current month reading:");
			prevr = prevr + curr - prevr;
			curr=input.nextInt();
			
	        
			
			
			System.out.println("Enter type of connection(D/C):");
			conn=input.next();
	units=curr-prevr;
	if(conn.equals("D"))
	{
		if(units<=0)
			amount=0;
		else if(units<=100)
			amount=units*2;
		else if(units<=200)
			amount=units*2.5;
		else if(units<=500)
			amount=units*4;
		else 
			amount=units*6;
	}
	else if(conn.equals("C"))
	{
		if(units<=0)
			amount=0;
		else if(units<=100)
			amount=units*3;
		else if(units<=200)
			amount=units*4.5;
		else if(units<=500)
			amount=units*6;
		else 
			amount=units*7;
	}
	double prevb = amount+0;
	System.out.println("Bill amount:" +amount);
	double ch=amount;
	String co=conn;
	ResultSet rs=st.executeQuery("Select * from customer where Id='"+cno+"'");
		while(rs.next())
		{
			ch=rs.getDouble(11);
			co=rs.getString(10);
		}

			
		
		
	
		st.executeUpdate("Update customer set Previous='" + prevr + "',Current= '" + curr + "', Connection='" + conn + "',BillAmount='"+ch+"'where Id='"+cno+"'");
		st.executeUpdate("Update customer set Previous = Current, Current='"+curr+"', Connection='" + conn + "',BillAmount='"+prevb+"'where Id='"+cno+"'");
		
	System.out.println("Data Entered Successfully");


		}
		
		catch(Exception e) {
			System.out.println(e);
		}
		}
		
		
       public void payment() {
			
			
				LocalDate today = LocalDate.now();
				int month = today.getMonthValue();
		
			LocalDate ld = LocalDate.of( 2021 , Month.of(month) , 7 ) ;
			LocalDate MonthsLater = ld.plusMonths( 1 ) ;
			System.out.println("Due date :" +MonthsLater); 
		
			System.out.println("Payment Type");
			System.out.println("1.card or 2.cash");
			Scanner sc1 = new Scanner(System.in);
			int ch1 = sc1.nextInt();
			        	
			  
			
			if (ch1 == 1) {
				System.out.println("Enter Amount:");	        	
				 double  value1 = sc1.nextDouble();
				 System.out.println("Enter CardName:");
				 String CardName1=sc1.next();
				 System.out.println("Enter  ExpirationDate :");
				 String ExpirationDate1 = sc1.next();
				 
				    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy");
				    simpleDateFormat.setLenient(false);
				    Date expiry;
					try {
						expiry = simpleDateFormat.parse(ExpirationDate1);
					
				    boolean expired = expiry.before(new Date());
				    if (expired == true)
				    {
				        System.out.println("This card has already expired");
				        Admin a=new Admin();
						a.payment();
				    }
				   
			       }
					
			          catch (ParseException e) {
				
				         e.printStackTrace();
			         }
				 
			
			System.out.println("Enter CreditCardNumber  :");	 
				 String CreditCardNumber1=sc1.next();
				 while(!(CreditCardNumber1.length() < 10)&&!(CreditCardNumber1.contains("1,2,3,4,5,6,7,8,9,0"))) 
				  {
				     System.out.println("check your CreditCardNumber it is incorrect  Re-enter a valid CreditCardNumber id:");
				     CreditCardNumber1 = sc1.next();
				  }
				 
				 
				 LocalDate date3 = java.time.LocalDate.now();
					System.out.println("you paid on:" + date3);
					
				 System.out.println("Amount paid" + value1);	
			} 
			
			
			
			else if (ch1 == 2) {
				System.out.println("Enter the amount:");
				int Amount = sc1.nextInt();
				LocalDate date1 = java.time.LocalDate.now();
				System.out.println(" you  paid on:" + date1);
				System.out.println("Amount paid" + Amount);		
				
			}
			
			
			
		}
       public static void sendMail(String Email ) {
			 String recipient = Email;
			 String sender = "launchclubmail@gmail.com";
			 String password = "Launchclub@123";
			 String subject = "Electricity Billing";
			 System.out.println("Sending mail from " + sender + " to " + recipient);
		 String body="your payment is successfull";
			String host = "smtp.gmail.com";

			Properties properties = System.getProperties();

			properties.put("mail.smtp.host", host);
			properties.put("mail.smtp.port", "465");
			properties.put("mail.smtp.ssl.enable", "true");
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			properties.put("mail.smtp.auth", "true");

			Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("launchclubmail@gmail.com", "Launchclub@123");
				}

			});

			try {

				MimeMessage message = new MimeMessage(session);

				message.setFrom(new InternetAddress(sender));

				message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

				message.setSubject(subject);
				message.setText(body);

				Transport.send(message);
				System.out.println("Mail sent successfully...");
				System.out.println("you paid the bill");
			} catch (MessagingException mex) {
				mex.printStackTrace();
			}
		}

       
	}


