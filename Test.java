import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    int tiempo = 0;
    int iteracionPorElemento = 100;
    long memoria = 0;


    private void crearTabla(){
        String[] algoritmos = {"Erosion","Dilatacion"};
        String[] elementos = {"Elemento1","Elemento2","Elemento3","Elemento4","Elemento5"};
        String[] procesamientos = {"Secuencial","Paralelo"};

        String[] encabezado = {"Algoritmo","Elemento","Procesamiento","Tiempo", "Memoria (Bytes)"};

        try {
            FileWriter csvWriter = new FileWriter("Pruebas.csv");
            csvWriter.append(String.join(",", encabezado));
            csvWriter.append("\n");

            for (int i = 1; i < algoritmos.length + 1; i++) {
                for (int j = 1; j < elementos.length + 1; j++) {
                    for (int k = 1; k < procesamientos.length + 1; k++) {
                        for (int l = 0; l < iteracionPorElemento; l++) {
                            //Mide los recursos utilizados por el programa
                            Runtime runtime = Runtime.getRuntime();
                            runtime.gc();
                            Ejecucion ejecucion = new Ejecucion("test.pgm",i,j,k);
                            ejecucion.iniciar();
                            memoria = runtime.totalMemory() - runtime.freeMemory();
                            memoria = memoria / 1024;
    
                            tiempo = ejecucion.getTiempo();
                            csvWriter.append(algoritmos[i - 1]);
                            csvWriter.append(",");
                            csvWriter.append(elementos[j- 1]);
                            csvWriter.append(",");
                            csvWriter.append(procesamientos[k- 1]);
                            csvWriter.append(",");
                            csvWriter.append(String.valueOf(tiempo));
                            csvWriter.append(",");
                            csvWriter.append(String.valueOf(memoria));
                            csvWriter.append("\n");
                            
                        }

                    }
                }
            }

            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void procesarPruebas() {
        try {
            FileReader fileReader = new FileReader("Pruebas.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            Map<String, Integer> tiempoSum = new HashMap<>();
            Map<String, Long> memoriaSum = new HashMap<>();
            Map<String, Integer> contador = new HashMap<>();

            String line;
            // Saltar la primera línea (encabezados)
            bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {
                String[] campos = line.split(",");
                String algoritmo = campos[0];
                String elemento = campos[1];
                String procesamiento = campos[2];
                int tiempo = Integer.parseInt(campos[3]);
                long memoria = Long.parseLong(campos[4]);

                String clave = algoritmo + "," + elemento + "," + procesamiento;

                // Actualizar el tiempo promedio
                tiempoSum.put(clave, tiempoSum.getOrDefault(clave, 0) + tiempo);

                // Actualizar la memoria promedio
                memoriaSum.put(clave, memoriaSum.getOrDefault(clave, 0L) + memoria);

                // Incrementar el contador de iteraciones
                contador.put(clave, contador.getOrDefault(clave, 0) + 1);
            }

            bufferedReader.close();

            // Crear el archivo "Resultados.csv"
            FileWriter csvWriter = new FileWriter("Resultados.csv");
            csvWriter.append("Algoritmo,Elemento,Procesamiento,Promedio Tiempo,Promedio Memoria (Bytes)\n");

            for (String clave : tiempoSum.keySet()) {
                int promedioTiempo = tiempoSum.get(clave) / contador.get(clave);
                long promedioMemoria = memoriaSum.get(clave) / contador.get(clave);

                String[] partes = clave.split(",");
                String algoritmo = partes[0];
                String elemento = partes[1];
                String procesamiento = partes[2];

                csvWriter.append(algoritmo);
                csvWriter.append(",");
                csvWriter.append(elemento);
                csvWriter.append(",");
                csvWriter.append(procesamiento);
                csvWriter.append(",");
                csvWriter.append(String.valueOf(promedioTiempo));
                csvWriter.append(",");
                csvWriter.append(String.valueOf(promedioMemoria));
                csvWriter.append("\n");
            }

            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void iniciar() throws IOException{
        crearTabla();
        procesarPruebas();

    }




}
