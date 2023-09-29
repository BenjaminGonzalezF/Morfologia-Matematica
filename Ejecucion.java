import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Algoritmos.Erosion.ErosionParalela;
import Algoritmos.Erosion.ErosionSecuencial;
import Datos.Datos;

public class Ejecucion {

    String tipo = "";
    int ancho = 0, alto = 0, maximo = 0;

    // Lista de arraylist donde cada arraylist contiene los datos de una fila. Esto
    // permite filas de distintos tamaños

    List<ArrayList<Integer>> matriz = new ArrayList<>();

    Datos datos  = new Datos();

    private void generarEstructura(BufferedReader br) {
        String linea;
        ArrayList<Integer> fila = new ArrayList<>();


        try {
            while ((linea = br.readLine()) != null) {
                String[] valores = linea.split(" ");
                for (String valor : valores) {
                    fila.add(Integer.parseInt(valor));
                }
                if(fila.size() == ancho){
                    matriz.add(new ArrayList<>(fila));
                    fila.clear();
                    //System.out.println(matriz.get(0));
                 }
            }
        }catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        datos.setDatos(matriz);
        datos.setAlto(alto);
        datos.setAncho(ancho);
        datos.setMaximo(maximo);
        datos.setTipo(tipo);
    }

    private void leerArchivo() throws IOException {
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Ingrese el nombre del archivo");
        // String archivoPGM = sc.nextLine();
        String archivoPGM = "test.pgm";
        String linea;
        // Abrir archivo de tipo pgm
        BufferedReader br = new BufferedReader(new FileReader(archivoPGM));
        // Leer la información del encabezado PGM

        int lineasProcesadas = 0;

        // Inicializar las variables considerando posibles comentarios entre lineas.
        while (lineasProcesadas <3) {
            linea = br.readLine();
            if (!linea.trim().startsWith("#")) {
                String[] tokens = linea.split(" ");
                for (int i = 0; i < tokens.length; i++) {
                    if (lineasProcesadas == 0) {
                        tipo = tokens[i];
                    }
                    if (lineasProcesadas == 1) {
                        if(alto == 0) ancho = Integer.parseInt(tokens[i]);
                        alto = Integer.parseInt(tokens[i]);
                    }
                    if(lineasProcesadas == 2){
                        maximo = Integer.parseInt(tokens[i]);
                    }
                }
                lineasProcesadas += 1;
            }
        }

        generarEstructura(br);

    }

    private void mostrarMatriz() {
        for (ArrayList<Integer> fila : matriz) {
            for (Integer pixel : fila) {
                System.out.print(pixel + " ");
            }
            System.out.println();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    private void mostrarLargoFilas() {
        for (ArrayList<Integer> fila : matriz) {
            System.out.println(fila.size());
        }
    }

    public void testErosionParelela1(){

        System.out.println("\nDatos Originales");
        datos.mostrar60Elementos(0, "DatosOriginales");
        datos.mostrar60Elementos(1, "DatosOriginales");
        System.out.println();


        ErosionParalela eros = new ErosionParalela(1,datos );
        ErosionSecuencial erosionSecuencial = new ErosionSecuencial(1,datos);
        
        System.out.println("\nDatos resultantes");
        datos.mostrar60Elementos(0, "NuevosDatos");
        datos.mostrar60Elementos(1, "NuevosDatos");
    }
    
    public void iniciar() throws IOException {
        leerArchivo();
        testErosionParelela1();

    }
}
