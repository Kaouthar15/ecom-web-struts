package utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DatabaseUtil {

    private static Connection connexion;

    
    static {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/catalogue", "root", "123456"); 
    	}catch (SQLException ex) {
            System.err.println("Server/DB Not found or Incorrect Request");
        } catch (ClassNotFoundException e) {
        	 System.err.println("Driver Not found or Incorrect Request");
			e.printStackTrace();
		}
    }
    public static  Connection getConnection() { 
    	System.out.println("Attempting to connect to the database...");
    	return connexion; 
    }
}