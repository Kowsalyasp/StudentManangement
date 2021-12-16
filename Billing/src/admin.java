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
import java.util.Scanner;

public class admin  {
	Connection c = null;
	int prevr,curr;
	
	//connection
public Connection getConnection() {
		
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Billing", "root", "Kowsilucky@7");
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
			
			System.out.println(rs.getString(1)+"\t\t" +rs.getString(2)+"\t\t"  + rs.getString(9) + "\t\t" + rs.getString(10) + "\t\t" + rs.getString(11) + "\t\t");
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
ResultSet rs=st.executeQuery("Select * from electricity where Id='"+cno+"'");
	while(rs.next())
	{
		ch=rs.getDouble(6);
	}

		
	st.executeUpdate("Update electricity set Previous = Current, Current='"+curr+"'where Id='"+cno+"'");
		
	st.executeUpdate("Update electricity set BillAmount='"+prevb+"'where Id='"+cno+"'");
	st.executeUpdate("Update customer set Previous, Current='"+curr+"'Connection='"+conn+"'where Id='"+cno+"'");
	
st.executeUpdate("Insert into electricity(Id,Name,Previous,Current,Connection,BillAmount) values('" + cno + "','" + cname + "','" + prevr + "','" + curr + "','" + conn + "','"+ch+"')");
System.out.println("Data Entered Successfully");


	}
	
	catch(Exception e) {
		System.out.println(e);
	}
	}
	//payment
	public void payment() {
		
		/* String datee="2022/01/20";
		
		DateTimeFormatter df = DateTimeFormatter .ofPattern("yyyy/MM/DD");
		
		LocalDate futureDate = LocalDate.parse(datee,df).plusMonths(1);
		
		  System.out.println("Due date:" +futureDate); */
		/*java.time.LocalDate.of( yyyy , MONTH , 7 )
	    .plusMonths( 6 )
	    .toString();*/
		 
			//Month currentMonth = date.getMonth();
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
			        admin a=new admin();
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
		admin a= new admin();
	     //  a.inputEmail();
		
	}

	/*public void inputEmail(){
		System.out.println("Please enter your email address ex:xyz@gmail.com");
		 Scanner name = new Scanner(System.in); 
        String emailaddress=name.nextLine();

        String email_regex = "[A-Z]+[a-zA-Z_]+@\b([a-zA-Z]+.){2}\b?.[a-zA-Z]+";
        String testString = emailaddress;
        Boolean b = testString.matches(email_regex);
        if(b){
            System.out.println("Valid email");
          } else {
            System.out.println("InValid email");
             inputEmail();
         }
        System.out.println("String: " + testString + " :Valid = " + b);
        System.out.println("Email address is " +emailaddress);
       }*/

	
}
