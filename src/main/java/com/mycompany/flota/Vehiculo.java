/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.flota;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName; 

/**
 *
 * @author framoralc
 */

public class Vehiculo implements Serializable{
    //matrícula, marca, modelo, año, kilometraje, categoría de mantenimiento
    private static double TotalKilometraje;
    private static int TotalVehiculos;
    
    private String matricula;
    private String marca;
    private String modelo;
    private int año;
    @SerializedName("kms_recorridos")
    private double km;
    private String categoriaMantenimiento;

    public static int getTotalVehiculos() {
        
        return TotalVehiculos;
    }

    public static double getTotalKilometraje() {
        
        return TotalKilometraje;
    }
    

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public String getCategoriaMantenimiento() {
        return categoriaMantenimiento;
    }

    public void setCategoriaMantenimiento(String categoriaMantenimiento) {
        this.categoriaMantenimiento = categoriaMantenimiento;
    }

    public Vehiculo(String matricula, String marca, String modelo, int año, double km, String categoriaMantenimiento) {
        this.matricula = "";
        this.marca = "";
        this.modelo = "";
        this.año = 0;
        this.km = 0;
        this.categoriaMantenimiento = "";
        TotalVehiculos++;
        TotalKilometraje =+ km;
    }

    
}
