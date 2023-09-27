package Datos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrearPGM {
    private String nombre = "";
    Datos datos;

    public CrearPGM( String nombre, Datos datos){
        this.datos = datos;
        this.nombre= nombre;
        crear();

    }


    public void crear(){
        // Crear un nombre de archivo único para cada lista
        String nombreArchivo = nombre + System.currentTimeMillis() + ".pgm";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            // Escribir la cabecera PGM en el archivo
            writer.write("P2");
            writer.newLine();
            writer.write("#Creado por Serllet Romina y Benjamin");
            writer.newLine();
            writer.write(datos.getAncho() + " " + datos.getAlto());
            writer.newLine();
            writer.write(String.valueOf(datos.getMaximo()));
            writer.newLine();

            // Recorrer los elementos de la lista y escribirlos en el archivo
            for (ArrayList<Integer> lista : datos.getDatos()) {
                for (Integer valor : lista) {
                    writer.write(String.valueOf(valor));
                    writer.write(" ");
                }
                writer.newLine();
            }

            System.out.println("Archivo " + nombreArchivo + " creado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
