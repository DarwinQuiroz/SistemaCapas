/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Gestion;

import CapaDatos.Conexion;
import Clases.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Darwin
 */
public class GestionCliente implements IGestion
{
    private Cliente cliente = new Cliente ("","","",0);

    public GestionCliente() 
    {
        Conexion.setCadena("jdbc:mysql://localhost/facturacion");
        Conexion.setUsuario("root");
        Conexion.setClave("");
        
    }

    public Cliente getCliente() 
    {
        return cliente;
    }
    public void setCliente (Cliente cliente)
    {
        this.cliente = cliente;
    }
   
    
    @Override
    public void Grabar() throws SQLException 
    {        
        try
        {
            Conexion.GetInstancia().Conectar();
            Conexion.GetInstancia().Ejecutar("INSERT INTO cliente (Cedula, Nombre, Direccion, Cupo) VALUES ('"+cliente.getCedula()+"','"+cliente.getNombre()+"','"+cliente.getDireccion()+"', "+cliente.getCupo()+")");
        }
        catch(SQLException ex)
        {
            throw ex;            
        } 
        finally
        {
            Conexion.GetInstancia().Desconectar();
        }
    }

    @Override
    public void Modificar() throws SQLException 
    {
        try
        {
            Conexion.GetInstancia().Conectar();
            Conexion.GetInstancia().Ejecutar("UPDATE cliente SET Nombre = '"+cliente.getNombre()+"', Direccion = '"+cliente.getDireccion()+"', Cupo = '"+cliente.getCupo()+"' WHERE Cedula = "+cliente.getCedula());         
        }
        catch(SQLException ex)
        {
            throw ex;            
        }
        finally
        {
            Conexion.GetInstancia().Desconectar(); 
        }
    }

    @Override
    public void Nuevo() throws SQLException 
    {       
        cliente.setCedula("000000000-0");
        cliente.setNombre("SD");
        cliente.setDireccion("SD");
        cliente.setCupo(00);
    }

    @Override
    public void Eliminar() throws SQLException 
    {
        try
        {
            Conexion.GetInstancia().Conectar();
            Conexion.GetInstancia().Ejecutar("DELETE FROM cliente WHERE Cedula = "+cliente.getCedula());   
        }
        catch(SQLException ex)
        {
            throw ex;            
        }
        finally
        {
            Conexion.GetInstancia().Desconectar(); 
        }
    }
    
    @Override    
    public void Consultar() throws SQLException 
    { 
        try
        {            
           Conexion.GetInstancia().Conectar();
           ResultSet rs = Conexion.GetInstancia().EjecutarConsulta("SELECT Nombre, Direccion, Cupo FROM cliente WHERE Cedula = '"+cliente.getCedula()+"';");
           while(rs.next())
           {              
               cliente.setNombre(rs.getString("Nombre"));
               cliente.setDireccion(rs.getString("Direccion"));
               cliente.setCupo(rs.getDouble("Cupo"));
           }
        }
        catch(SQLException ex)
        { 
            throw ex;
        }
        finally
        {
            Conexion.GetInstancia().Desconectar(); 
        }
    }    
}
