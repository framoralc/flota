/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.flota;

import java.io.File;
import com.mycompany.flota.Vehiculo;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 *
 * @author framoralc
 */
public class GestorConfiguracion {
    // nombre de la empresa, versión del software, total de vehículos activos y kilometraje acumulado
    
    private String nombreEmpresa;
    private String versionSoftware;
    private int totalVehiculoActivos;
    private double kmAcumulado;

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getVersionSoftware() {
        return versionSoftware;
    }

    public void setVersionSoftware(String versionSoftware) {
        this.versionSoftware = versionSoftware;
    }

    public int getTotalVehiculoActivos() {
        return totalVehiculoActivos;
    }

    public void setTotalVehiculoActivos(int totalVehiculoActivos) {
        this.totalVehiculoActivos = totalVehiculoActivos;
    }

    public double getKmAcumulado() {
        return kmAcumulado;
    }

    public void setKmAcumulado(double kmAcumulado) {
        this.kmAcumulado = kmAcumulado;
    }

    public GestorConfiguracion(String nombreEmpresa, String versionSoftware) {
        this.nombreEmpresa = nombreEmpresa;
        this.versionSoftware = versionSoftware;
        this.totalVehiculoActivos = Vehiculo.getTotalVehiculos();
        this.kmAcumulado = Vehiculo.getTotalKilometraje();
    }
    
    public GestorConfiguracion(){
        this.nombreEmpresa = "";
        this.versionSoftware = "";
        this.totalVehiculoActivos = 0;
        this.kmAcumulado = 0.00;
    }
    
    public void guardarConfiguracion(GestorConfiguracion gc){
        File config = new File("/datos/config/empresa.dat");

        if (!config.exists()) {
            config.mkdirs();
        }

        try (DataOutputStream br = new DataOutputStream(new FileOutputStream(config))) {
            br.writeUTF(gc.getNombreEmpresa());
            br.writeUTF(gc.getVersionSoftware());
            br.writeInt(gc.getTotalVehiculoActivos());
            br.writeDouble(gc.getKmAcumulado());
            br.flush();
            System.out.println("Se ha guardado correctamente");
        } catch (EOFException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void cargarConfiguracion(GestorConfiguracion gc){
        File config = new File("/datos/config/empresa.dat");

        try(DataInputStream di = new DataInputStream(new FileInputStream(config))){
            
            gc.setNombreEmpresa(di.readUTF());
            gc.setVersionSoftware(di.readUTF());
            gc.setTotalVehiculoActivos(di.readInt());
            gc.setKmAcumulado(di.readDouble());
            System.out.println("Se ha cargado correctamente");
        }catch (EOFException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
