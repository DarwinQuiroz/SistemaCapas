/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;
/**
 *
 * @author Darwin
 */
public class Cliente 
{    
    private String Cedula;   
    /**
     * Get the value of Cedula
     *
     * @return the value of Cedula
     */
    public String getCedula() 
    {
        return Cedula;
    }

    /**
     * Set the value of Cedula
     *
     * @param Cedula new value of Cedula
     */
    public void setCedula(String Cedula) 
    {
        this.Cedula = Cedula;
    }

    private String Nombre;

    /**
     * Get the value of Nombre
     *
     * @return the value of Nombre
     */
    public String getNombre() 
    {
        return Nombre;
    }
    
    /**
     * Set the value of Nombre
     *
     * @param Nombre new value of Nombre
     */
    public void setNombre(String Nombre) 
    {
        this.Nombre = Nombre;
    }
    
    private String Direccion;

    /**
     * Get the value of Direccion
     *
     * @return the value of Direccion
     */
    public String getDireccion() 
    {
        return Direccion;
    }

    /**
     * Set the value of Direccion
     *
     * @param Direccion new value of Direccion
     */
    public void setDireccion(String Direccion) 
    {
        this.Direccion = Direccion;
    }

    private double Cupo;

    /**
     * Get the value of Cupo
     *
     * @return the value of Cupo
     */
    public double getCupo() 
    {
        return Cupo;
    }

    /**
     * Set the value of Cupo
     *
     * @param Cupo new value of Cupo
     */
    public void setCupo(double Cupo) 
    {
        this.Cupo = Cupo;
    }
    
    public Cliente(String Cedula, String Nombre, String Direccion, double Cupo) 
    {
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Cupo = Cupo;
    }   
    
}
