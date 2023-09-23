import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejecucion {
    String tipo = "";
    int ancho = 0, alto = 0;

    //Lista de arraylist donde cada arraylist contiene los datos de una fila. Esto permite filas de distintos tamaños
    List<ArrayList<Integer>> matriz = new ArrayList<>();

    private void generarMatriz() throws IOException {
        //Scanner sc = new Scanner(System.in);
        //System.out.println("Ingrese el nombre del archivo");
        //String archivoPGM = sc.nextLine();
        String archivoPGM = "test.pgm";
        String linea;
        // Abrir archivo de tipo pgm
        BufferedReader br = new BufferedReader(new FileReader(archivoPGM));
        // Leer la información del encabezado PGM

        int lineasProcesadas = 0;

        //Inicializar las variables considerando posibles comentarios entre lineas.
        while (lineasProcesadas<2) {
            linea = br.readLine();
            if(!linea.trim().startsWith("#")){
                String[] tokens = linea.split(" ");
                    for (int i = 0; i < tokens.length; i++) {
                            if (lineasProcesadas == 0) {
                                tipo = tokens[i];
                            }
                            if(lineasProcesadas == 1){
                                alto = Integer.parseInt(tokens[i]);
                                ancho = Integer.parseInt(tokens[i]);
                            }
                        }
                    lineasProcesadas +=1;
            }            
        }

        while ((linea = br.readLine()) != null) {
            String[] valores = linea.split(" ");
            ArrayList<Integer> fila = new ArrayList<>();
            for (String valor : valores) {
                fila.add(Integer.parseInt(valor));
            }
            matriz.add(fila);
        }

    }
    
    private void mostrarMatriz(){
        for (ArrayList<Integer> fila : matriz) {
            for (Integer pixel : fila) {
                System.out.print(pixel + " ");
            }
            System.out.println(); 
        }
    }

        private void mostrarLargoFilas(){
        for (ArrayList<Integer> fila : matriz) {
            System.out.println(fila.size()); 
        }
    }

    public void iniciar() throws IOException {
        generarMatriz();
        //mostrarMatriz();
        mostrarLargoFilas();

    
    
    }
}
