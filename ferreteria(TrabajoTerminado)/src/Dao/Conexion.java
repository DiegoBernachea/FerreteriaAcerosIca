/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

/**
 *
 * @author kmvil
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Alumno
 */
public class Conexion {
    
    Connection con;
    
    public Connection getConnection(){
        try{
          String myBd = "jdbc:mysql://localhost:3306/bdferreteria?serverTimezone=America/Lima";
          con = DriverManager.getConnection(myBd,"root","");
            return con;
        }catch (SQLException e){
        System.out.println("Error de Conexion "+ e.getMessage() );
        }
        return null;
    }
    
    
}