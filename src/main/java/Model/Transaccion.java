/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 *
 * @author Josem
 */
public class Transaccion {
    private int id;
    private int cedula;
    private BigDecimal monto;
    private String tipo;
    private Timestamp fecha;
    private BigDecimal tarifa;

    public Transaccion() {
    }

    public Transaccion(BigDecimal monto, String tipo, Timestamp fecha, BigDecimal tarifa) {
        this.monto = monto;
        this.tipo = tipo;
        this.fecha = fecha;
        this.tarifa = tarifa;
    }
    
    

    public Transaccion(int cedula, BigDecimal monto, String tipo, Timestamp fecha, BigDecimal tarifa) {
        this.cedula = cedula;
        this.monto = monto;
        this.tipo = tipo;
        this.fecha = new Timestamp(System.currentTimeMillis());
        this.tarifa = tarifa;
    }

    public Transaccion(int id, int cedula, BigDecimal monto, String tipo, Timestamp fecha) {
        this.id = id;
        this.cedula = cedula;
        this.monto = monto;
        this.tipo = tipo;
        this.fecha = fecha;
    }

    public Transaccion(int id, int cedula, BigDecimal monto, String tipo, Timestamp fecha, BigDecimal tarifa) {
        this.id = id;
        this.cedula = cedula;
        this.monto = monto;
        this.tipo = tipo;
        this.fecha = fecha;
        this.tarifa = tarifa;
    }  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getTarifa() {
        return tarifa;
    }

    public void setTarifa(BigDecimal tarifa) {
        this.tarifa = tarifa;
    }
    
    
}
