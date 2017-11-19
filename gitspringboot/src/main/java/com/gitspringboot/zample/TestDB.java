/* Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/test","root","");
        Statement st= con.createStatement();
        ResultSet rs = st.executeQuery(qry);

        // Sending table
        PrintWriter pw;
        pw = res.getWriter();

*/

package com.gitspringboot.zample;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.OracleTypes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDB {
	public static final String SOME_NAME = "{call   root.GetEmpPckg.GetEmp(?,?)}"; // Change the schema name,packagename,and procedure name.


	public static void main(String args[]) {
	     try {
			Connection con = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//step2 create  the connection object  
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "root", "root");
			//step3 create the statement object  
			Statement stmt = con.createStatement();
			//step4 execute query  
			ResultSet rs = stmt.executeQuery("select * from AUDIT_LOG");
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			//step5 close the connection object  
			con.close();
		} catch (Exception e) {
			System.out.println("edp="+e);
		}  
	     
	     System.out.println("--------------------");
	    // callPackage();
	  callPackage2();
	  //callPackage3();//with joins
	   }
	public static void callPackage3(){ //
		Connection conn = null;
		CallableStatement stmt = null;
		ResultSet rset = null;

		try {
		        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "root", "root");
		        stmt = conn.prepareCall("{call   root.GetCertPckg2.GetCertDetails2(?,?,?,?)}");//We have declared this at the very top
		        stmt.setString(1, "pol");//Passing CompanyID here
		        stmt.setString(2, "30-Nov-17");
		        stmt.setString(3, "31-Dec-17");
		        stmt.registerOutParameter(4, OracleTypes.CURSOR);//Refcursor selects the row based upon query results provided in Package.
		        stmt.execute();
		        rset = (ResultSet) stmt.getObject(4);

		        while (rset.next()) {
		            String Client_ID=rset.getString("Client_ID");
		            String CLIENT_NAME=rset.getString("CLIENT_NAME"); 
		            String Cert_name=rset.getString("Cert_name"); 
		            String Exp_date=rset.getString("Exp_date"); 
		            // When using refcursor easy to get the value just by using Column name     
		            
		            // Some Logic based what do you want to do with the data returned back from query
		            System.out.println(Client_ID+ "  " +CLIENT_NAME+"  "+Cert_name+ "  " +Exp_date);
					
		        }
		} catch (Exception e) {
			System.out.println("edp="+e);
		} finally {
		       
		}
	}
	public static void callPackage2(){
		Connection conn = null;
		CallableStatement stmt = null;
		ResultSet rset = null;

		try {
		        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "root", "root");
		        stmt = conn.prepareCall("{call   root.GetCertPckg.GetAllCertDetails(?)}");//We have declared this at the very top
		        //stmt.setString(1, "vir");//Passing CompanyID here
		        //stmt.setString(2, "30-Nov-17");
		        //stmt.setString(3, "31-Dec-17");
		        stmt.registerOutParameter(1, OracleTypes.CURSOR);//Refcursor selects the row based upon query results provided in Package.
		        stmt.execute();
		        rset = (ResultSet) stmt.getObject(1);

		        while (rset.next()) {
		            String orgId=rset.getString("cert_NAME"); 
		            // When using refcursor easy to get the value just by using Column name     
		            String orgName=rset.getString("exp_date");    
		            // Some Logic based what do you want to do with the data returned back from query
		            System.out.println(orgId+ "  " +orgName);
					
		        }
		} catch (Exception e) {
			System.out.println("edp="+e);
		} finally {
		       
		}
	}
	public static void callPackage(){
		Connection conn = null;
		CallableStatement stmt = null;
		ResultSet rset = null;

		try {
		        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "root", "root");
		        stmt = conn.prepareCall(SOME_NAME);//We have declared this at the very top
		        stmt.setInt(1, 121);//Passing CompanyID here
		        stmt.registerOutParameter(2, OracleTypes.CURSOR);//Refcursor selects the row based upon query results provided in Package.
		        stmt.execute();
		        rset = (ResultSet) stmt.getObject(2);

		        while (rset.next()) {
		            String orgId=rset.getString("AUDIT_ID"); 
		            // When using refcursor easy to get the value just by using Column name     
		            String orgName=rset.getString("EVENT_NAME");    
		            // Some Logic based what do you want to do with the data returned back from query
		            System.out.println(orgId+ "  " +orgName);
					
		        }
		} catch (Exception e) {
			System.out.println("edp="+e);
		} finally {
		       
		}
	}

}