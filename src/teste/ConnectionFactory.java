/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
    
    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String URL = "jdbc:sqlite:db/db_quiz_academy.db";
    
    public static Connection getConnection(){
        
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão: ", ex);
        }
        
    }
    
    public static void closeConnection(Connection conexao){
        
        try {
            if(conexao != null){
                conexao.close();
            }  
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void closeConnection(Connection conexao, PreparedStatement stmt){
        closeConnection(conexao);
        
        try {
            if(stmt != null){
                stmt.close();
            }  
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void closeConnection(Connection conexao, PreparedStatement stmt, ResultSet rs){
        
        closeConnection(conexao, stmt);
        
        try {
            if(rs != null){
                rs.close();
            }  
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
