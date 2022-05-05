package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {
	

	 // Kết nối vào MySQL.
	 public static Connection getMySQLConnection() throws SQLException,
	         ClassNotFoundException {
	     String hostName = "localhost";

	     String dbName = "javaproject";
	     String userName = "root";
	     String password = "";

	     return getMySQLConnection(hostName, dbName, userName, password);
	 }

	 public static Connection getMySQLConnection(String hostName, String dbName,
	         String userName, String password) throws SQLException,
	         ClassNotFoundException {
	     // Khai bĂ¡o class Driver cho DB MySQL
	     // Viá»‡c nĂ y cáº§n thiáº¿t vá»›i Java 5
	     // Java6 tá»± Ä‘á»™ng tĂ¬m kiáº¿m Driver thĂ­ch há»£p.
	     // Náº¿u báº¡n dĂ¹ng Java6, thĂ¬ ko cáº§n dĂ²ng nĂ y cÅ©ng Ä‘Æ°á»£c.
	     Class.forName("com.mysql.cj.jdbc.Driver");

	     // Cáº¥u trĂºc URL Connection dĂ nh cho Oracle
	     // VĂ­ dá»¥: jdbc:mysql://localhost:3306/simplehr
	     String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

	     Connection conn = DriverManager.getConnection(connectionURL, userName,
	             password);
	     return conn;
	 }
	}
