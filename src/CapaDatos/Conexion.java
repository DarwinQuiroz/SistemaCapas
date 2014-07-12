/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CapaDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @author Darwin
 */
public class Conexion 
{
    Connection ConexionDatos= null;
    PreparedStatement Sentencia= null;
    ResultSet ConjuntoDatos=null;
    static String Usuario = null;
    static String Cadena = null;
    static String Clave =null;

    public static void setUsuario(String Usuario) 
    {
        Conexion.Usuario = Usuario;
    }
    
    public static void setCadena(String Cadena) 
    {
        Conexion.Cadena = Cadena;
    } 
    
    public static void setClave(String Clave) 
    {
        Conexion.Clave = Clave;
    } 
    
    private static Conexion Instancia=null;
    
    public static Conexion GetInstancia()
    {
        if (Instancia == null)
        {
            Instancia=new Conexion( );       
        }
        return Instancia;
    }    
    
   public void Conectar()
   {
       try 
       {
            ConexionDatos= DriverManager.getConnection(Cadena, Usuario, Clave);    
       }
       catch(SQLException ex)
       {
            ex.getStackTrace();
       }
               
    }
     public void Desconectar()       
     {
         try
         {
            ConexionDatos.close();    
         }
         catch(SQLException ex)
         {
             ex.getStackTrace();
         }
     }
     
     public void Ejecutar(String Cadena) throws SQLException
     {
         try
         {
            Sentencia= ConexionDatos.prepareStatement(Cadena);
            Sentencia.executeUpdate();
         }
         catch(SQLException ex)
         {
             throw ex;
         }                 
     }
     
     public ResultSet EjecutarConsulta (String Cadena) throws SQLException
     {
         try
         {
             Sentencia = ConexionDatos.prepareStatement(Cadena);
             ConjuntoDatos = Sentencia.executeQuery();
             return ConjuntoDatos;
         }
         catch(SQLException ex)
         {
             throw ex;
         }   
     }
    
}
