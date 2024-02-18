package com.cjc.bms.serviceimplementation;
import com.cjc.bms.Model.Account;
import com.cjc.bms.service.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class Sbi implements Rbi {
      static Scanner sc = new Scanner(System.in);
      static Account a = new Account();
      List<Account> list = new ArrayList<>();
	
	//public static void main(String args[]) throws Exception
	
	public void createAccount() throws SQLException
	{
     Connection con = jdbcHelper.getData();
	   //String sql = "Create table Account(accno bigint primary key,name varchar(30),mobno bigint, aadharno varchar(12), age int,gender varchar(10),balance double)";
	  String sql2 = "insert into Account values(?,?,?,?,?,?,?)";
	   // Statement st = con.createStatement();
	  // st.execute(sql);
	   for(int i =0;i<2;i++)
	   {
		PreparedStatement ps = con.prepareStatement(sql2);
		System.out.println("Enter Account Number ");
		a.setAccno(sc.nextInt());
		System.out.println("Enter Account Holder's Name ");
		a.setName(sc.next()+sc.nextLine());
		System.out.println("Enter Mobile Number ");
		a.setMobno(sc.nextLong());
		System.out.println("Enter Aadhar Number ");
		a.setAadharno(sc.next());
		System.out.println("Enter Age");
		a.setAge(sc.nextInt());
		System.out.println("Enter Gender ");
		a.setGender(sc.next());
		System.out.println("Enter Bank Balance");
		a.setBalance(sc.nextDouble());
		ps.setInt(1,a.getAccno());
		ps.setString(2, a.getName());
		ps.setLong(3,a.getMobno());
		ps.setString(4,a.getAadharno());
		ps.setInt(5,a.getAge());
		ps.setString(6,a.getGender());
		ps.setDouble(7, a.getBalance());
		int val = ps.executeUpdate();
		System.out.println(val);
		}
		con.close();
	
		System.out.println("Table Created");
			
	}
    @Override
	public void displayAllDetails() throws SQLException {
    	Connection con = jdbcHelper.getData();
    	String sql ="Select * from Account";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			 Account a = new Account();
			a.setAccno(rs.getInt(1));
			a.setName(rs.getString(2));
			a.setMobno(rs.getLong(3));
			a.setAadharno(rs.getString(4));
			a.setAge(rs.getInt(5));
			a.setGender(rs.getString(6));
			a.setBalance(rs.getDouble(7));
			list.add(a);
		}
		for(Account a2:list)
		{
			System.out.println("Account No "+a2.getAccno());
			System.out.println("Accountant Name "+a2.getName());
			System.out.println("Accountant Mobno "+a2.getMobno());
			System.out.println("Accountant AadharNo "+a2.getAadharno());
			System.out.println("Accountant Age "+a2.getAge());
			System.out.println("Account Gender "+ a2.getGender());
			System.out.println("Accountnt Balance "+a2.getBalance());
			System.out.println();
		}
		
	}

	@Override
	public void depositeMoney() throws SQLException {
		Connection con = jdbcHelper.getData();
		System.out.println("Enter Account No");
		long x =sc.nextLong();
		System.out.println("Enter Amount of Deposite");
		double y =sc.nextDouble();
		String sql = "update Account set balance = balance+? where accno =?"; 
		PreparedStatement ps =con.prepareStatement(sql);
		ps.setDouble(1, y);
		ps.setLong(2, x);
		double z = a.getBalance()+y;
		int val=ps.executeUpdate();
		System.out.println(val);
		System.out.println("Your account is Credited by "+y + "Account balance" +z );
		
	
		
	}

	@Override
	public void withDrawal() throws SQLException {
		Connection con = jdbcHelper.getData();
		System.out.println("Enter Account No");
		long x =sc.nextLong();
		System.out.println("Enter Amount of WithDrawl");
		double y =sc.nextDouble();
		String sql ="update Account set balance = balance-? where accno =?"; 
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setDouble(1,y);
		ps.setLong(2, x);
		ps.executeUpdate();
		//String sql1 = "Select balance from Account";
		//PreparedStatement ps1 = con.prepareStatement(sql1);
		// ResultSet rs = ps1.executeQuery();
        System.out.println("Your account is debited by "+y ); //"Account balance" +getDouble(1) );

		
		
					
	}

	@Override
	public void balanceCheck() throws SQLException {
		Connection con = jdbcHelper.getData();
		System.out.println("Enter Account No");
		long x =sc.nextLong();
		String sql ="Select balance from Account where accno =?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1,x);
		ResultSet rs =st.executeQuery();
		while(rs.next())
		{
			System.out.println("Account balance is "+rs.getDouble(1));
		}
		st.close();
		
		
	}
}
