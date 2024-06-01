/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.math.BigDecimal;

/**
 *
 * @author Josem
 */
public class Cuenta {
    private String nombre;
    private String telefono;
    private int cedula;
    private String correo;
    private String contraseña;
    private BigDecimal Saldo;

    public Cuenta(String nombre, String telefono, int cedula, String correo, String contraseña, BigDecimal Saldo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.cedula = cedula;
        this.correo = correo;
        this.contraseña = contraseña;
        this.Saldo = Saldo;
    }

    public Cuenta(String nombre, String telefono, int cedula, String correo, String contraseña) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.cedula = cedula;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    

    public Cuenta() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public BigDecimal getSaldo() {
        return Saldo;
    }

    public void setSaldo(BigDecimal Saldo) {
        this.Saldo = Saldo;
    }
    
    
}

