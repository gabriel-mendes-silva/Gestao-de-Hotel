/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author GABRIEL
 */
public class ConnectionFactory {
    private static final String drive = "com.mysql.jdbc.Driver";
    private static final String banco= "jdbc:mysql://localhost:3306/hotel";
    private static final String usuario = System.getenv("MySQL_USER");
    private static final String senha = System.getenv("MySQL_PASSWORD");
    
    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(banco + "?verifyServerCertificate=false"
                    + "&useSSL=false"
                    + "&requireSSL=false"
                    + "&USER=" + usuario + "&password=" + senha + "&serverTimezone=UTC");
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static void closeConnection(Connection connection){
        try{
            connection.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
  
    }
    
    public static void closeConnection(Connection connection, PreparedStatement pstm){
        try{
            pstm.close();
            connection.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
      public static void closeConnection(Connection connection, PreparedStatement pstm, ResultSet rs){
        try{
            pstm.close();
            rs.close();
            connection.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
