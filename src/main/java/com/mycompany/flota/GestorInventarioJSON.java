/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.flota;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author bofpc
 */
public class GestorInventarioJSON {
    
    public void exportar(List<Vehiculo> vehiculos, File ruta) {
        File archivo = new File("datos/json/flota.json");
        
        if(!archivo.exists()){
            archivo.mkdirs();
        }
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        try (PrintWriter pw = new PrintWriter(new FileWriter(ruta.getAbsoluteFile(), true))) {
            gson.toJson(vehiculos, pw);
            System.out.println("JSON exportado exitosamente en: " + archivo.getAbsolutePath());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void importar(ArrayList<Vehiculo> vehiculos, HashMap<String, Vehiculo> vehiculosMap){
        File archivo = new File("datos/json/flota.json");
        
        if(!archivo.exists()){
            System.err.println("No se ha encontrado el JSON");
        }
        
        Gson gson = new Gson();
        
        try(BufferedReader br = new BufferedReader(new FileReader(archivo.getAbsoluteFile()))){
            Vehiculo[] vehiculosList = gson.fromJson(br, Vehiculo[].class);
            
            for(Vehiculo vehiculo : vehiculos){
                    vehiculos.add(vehiculo);
                    vehiculosMap.put(vehiculo.getMatricula(), vehiculo);
            }
        }
        catch(FileNotFoundException e){
            System.err.println(e.getMessage());
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
