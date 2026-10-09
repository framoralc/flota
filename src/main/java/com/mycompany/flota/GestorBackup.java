package com.mycompany.flota;


import com.mycompany.flota.Vehiculo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bofpc
 */
public class GestorBackup {
    
    public void guardarBackup(List<Vehiculo> listaVehiculos){
        File backups = new File("datos/backup/flota_backup.ser");
        
        if(!backups.exists()){
            backups.mkdirs();
        }
        
        try (ObjectOutputStream backup = new ObjectOutputStream(new FileOutputStream(backups))) {
            backup.writeObject(listaVehiculos);
            System.out.println("Copia de seguridad guardada exitosamente en: " + backups.getAbsolutePath());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public List<Vehiculo> cargarBackup(){
        File archivo = new File("datos/backup/flota_backup.ser");
        
        if (!archivo.exists()) {
            System.err.println("No se encontró el backup");
            return null;
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            // Lectura y casendose directamente sin instanceof
            List<Vehiculo> listaVehiculos = (List<Vehiculo>) ois.readObject();
            System.out.println("backup cargado");
            return listaVehiculos;
            
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
