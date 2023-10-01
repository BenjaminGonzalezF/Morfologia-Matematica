import java.io.FileWriter;
import java.io.IOException;

public class Test {

    int tiempo = 0;

    private void crearTabla(){
        String[] algoritmos = {"Erosion","Dilatacion"};
        String[] elementos = {"Elemento1","Elemento2","Elemento3","Elemento4","Elemento5"};
        String[] procesamientos = {"Secuencial","Paralelo"};

        String[] encabezado = {"Algoritmo","Elemento","Procesamiento","Tiempo"};

        try {
            FileWriter csvWriter = new FileWriter("Pruebas.csv");
            csvWriter.append(String.join(",", encabezado));
            csvWriter.append("\n");

            for (int i = 1; i < algoritmos.length + 1; i++) {
                for (int j = 1; j < elementos.length + 2; j++) {
                    for (int k = 1; k < procesamientos.length + 1; k++) {
                        Ejecucion ejecucion = new Ejecucion("test.pgm",i,j,k);
                        ejecucion.iniciar();
                        tiempo = ejecucion.getTiempo();
                        csvWriter.append(algoritmos[i - 1]);
                        csvWriter.append(",");
                        csvWriter.append(elementos[j- 1]);
                        csvWriter.append(",");
                        csvWriter.append(procesamientos[k- 1]);
                        csvWriter.append(",");
                        csvWriter.append(String.valueOf(tiempo));
                        csvWriter.append("\n");
                    }
                }
            }

            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void iniciar() throws IOException{
        crearTabla();

    }




}
