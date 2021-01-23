package Mini_project;
import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;
public class Database 
{  Connection con;
   PreparedStatement pst,stmt1;
   ResultSet rs;
   public static String user,occup;
   public static int age;
   
   Database()
   {   try
	   {  con=DriverManager.getConnection("jdbc:Mysql://localhost:3306/db","root","mohan@1234");
	     
          
        
       }
   
       catch (Exception e) 
       {  System.out.println(e); }
   }
   
   public Boolean checkLogin(String uname,String pwd)
   {  
	   user=uname;
	   try 
       { 
		   pst=con.prepareStatement("select uname,password from account where uname=? and password=?");  
		  pst.setString(1, uname); 
         pst.setString(2, pwd);    
           
         rs=pst.executeQuery();
         if(rs.next())
           { 
             con.close();
             return true;
           }
         else
           { con.close();
             return false; }
         
        } 
   
        catch (Exception e) 
        {  System.out.println("error while validating"+e);
           return false;
        }
   }
   
   public void insert(String u,String p,int a,String o,String s)
   { 
	  
	   
	   try 
    { 
	  stmt1=con.prepareStatement("select * from account where uname=?");
	  stmt1.setString(1,u);
	  rs=stmt1.executeQuery();
	  if(rs.next())
	  {
		  JOptionPane.showMessageDialog(null, "Username Already Exists!!","Error",JOptionPane.ERROR_MESSAGE);
	  }
	  else
	  {
	   String sql1="insert into account(uname,password,age,occupation,state) values (?,?,?,?,?)";
       stmt1=con.prepareStatement(sql1); 
	   stmt1.setString(1,u);  
       stmt1.setString(2,p);
       stmt1.setInt(3,a);
       stmt1.setString(4,o);
       stmt1.setString(5,s); 
       stmt1.executeUpdate();
       con.close();
	  }    
	 }
    catch (Exception e) 
    {  System.out.println("error while validating"+e); }
   }
   

   public void display(JTable table)
   {
	   try {
		   stmt1=con.prepareStatement("select occupation ,age from account where uname=?");
		   //System.out.print(user);
		stmt1.setString(1,user);
		   rs=stmt1.executeQuery();
		   if(rs.next())
		   {
		    occup=rs.getString("occupation");
			  
		     age=rs.getInt("age");
		   
		
		 
		   //System.out.print(occup);
		   //System.out.print(age);
		   if(age>=65)
		   {
			   String sql2="select scheme from senior";
		       stmt1=con.prepareStatement(sql2);
		       rs=stmt1.executeQuery();
		    
		       table.setModel(DbUtils.resultSetToTableModel(rs)); 
		   }
		   if(occup.equals("Student"))
		   {
			   
			   String sql2="select scheme from student";
		       stmt1=con.prepareStatement(sql2);
		       rs=stmt1.executeQuery();
		    
		       table.setModel(DbUtils.resultSetToTableModel(rs)); 
		   }
		   if(occup.equals("Business"))
		   {
			   String sql2="select scheme from business";
		       stmt1=con.prepareStatement(sql2);
		       rs=stmt1.executeQuery();
		    
		       table.setModel(DbUtils.resultSetToTableModel(rs)); 
		   }
		   if(occup.equals("Other"))
		   {
			   String sql2="select scheme from other";
		       stmt1=con.prepareStatement(sql2);
		       rs=stmt1.executeQuery();
		    
		       table.setModel(DbUtils.resultSetToTableModel(rs)); 
		   }
		   if(occup.equals("Agriculture"))
		   {
			   String sql2="select scheme from agriculture";
		       stmt1=con.prepareStatement(sql2);
		       rs=stmt1.executeQuery();
		    
		       table.setModel(DbUtils.resultSetToTableModel(rs)); 
		   }
		   
		   } 
	 
	   }
	   catch(Exception e)
	   {
		   System.out.print("error in displaying database contents!"+e);
	   }
   } 
	   
	   public void profcheck(JTextField text1,JTextField text2,JTextField text3,JTextField text4,JTextField text5)
	   {  
		   //System.out.print(user);
		   try 
	       { 
			   stmt1=con.prepareStatement("select * from account where uname=?");
			   stmt1.setString(1,user);
			   rs=stmt1.executeQuery();
			   while(rs.next())
			   {
				  text1.setText(rs.getString("uname"));
				  text2.setText(rs.getString("password"));
				  text3.setText(rs.getString("age"));   
				  text4.setText(rs.getString("occupation"));
				  text5.setText(rs.getString("state"));
				}
			 
	         
	        } 
	   
	        catch (Exception e) 
	        {  
	        	System.out.println("error while validating"+e);
	           
	        }
	   }
	   
	   public void updateinfo(String u,String p,int a,String o,String s)
	   { 
		   try 
	    { 
		  
	      stmt1=con.prepareStatement("update account set uname=?,password=?,age=?,occupation=?,state=? where uname=?"); 
		  stmt1.setString(6,user);
	      stmt1.setString(1,u);  
	      stmt1.setString(2,p);
	      stmt1.setInt(3,a);
	      stmt1.setString(4,o);
	      stmt1.setString(5,s); 
	      stmt1.executeUpdate();
	      con.close();
	    }
	    catch (Exception e) 
	    {  System.out.println("error while validating"+e); }
	   }
		
       public void register(String s)
       {
    	   try 
    	   {
    	   stmt1=con.prepareStatement("select * from schemereg where uname=? and scheme=?");
    	   stmt1.setString(1,user);
    	   stmt1.setString(2,s);
    	   rs=stmt1.executeQuery();
    	   if(rs.next()==false)
    	   {
    	   stmt1=con.prepareStatement("insert into schemereg(uname,scheme) values (?,?)"); 
    	   stmt1.setString(1,user);  
           stmt1.setString(2,s);
           stmt1.executeUpdate();
           JOptionPane.showMessageDialog(null, "REGISTERED SUCCESSFULL !!","Message",JOptionPane.INFORMATION_MESSAGE); 
    	   }
    	   else
    	   {
    		   JOptionPane.showMessageDialog(null, "ALREADY REGISTERED !!","Message",JOptionPane.INFORMATION_MESSAGE); 
				
    	   }
    	   }
    	   
    	   catch(Exception e) 
   	    {  System.out.println("error while validating"+e); }
       }
   
       public void regdisplay(JTable table)
       {
    	   try 
    	   {
    	   stmt1=con.prepareStatement("select scheme from schemereg where uname=?"); 
    	   stmt1.setString(1,user);  
           rs=stmt1.executeQuery();
           table.setModel(DbUtils.resultSetToTableModel(rs)); 
    	   }
    	   
    	   catch(Exception e) 
   	    {  System.out.println("error while validating"+e); }
       }
   
}