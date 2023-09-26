package Datos;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//Clase singleton encargada de gestionar los datos.
public class Datos {
    private static Datos instance = null;
    private int alto;
    private int ancho;
    private int maximo;
    // Lista de arraylist donde cada arraylist contiene los datos de una fila. Esto
    // permite filas de distintos tamaños
    List<ArrayList<Integer>> datos = new ArrayList<>();
    public Datos(){}
    public Datos(int alto, int ancho, int maximo, List<ArrayList<Integer>> datos) {
        this.alto = alto;
        this.ancho = ancho;
        this.maximo = maximo;
        this.datos = datos;
    }

    //Devuelve la misma instancia para todas las llamadas
    public Datos getInstance() {
        if (instance == null) {
            instance = new Datos();
        }
        return instance;
    }
    //Devuelve todos los datos
    public List<ArrayList<Integer>> getMatriz() {
        return datos;
    }

    //Remplaza los valores de la lista con indice i con los de la nueva Lista
    public void reemplazarListaN(int i,ArrayList<Integer> nuevaLsita){
        this.datos.set(i, nuevaLsita);
        
    }
    //Devuelve una sublista 
    public List<ArrayList<Integer>> obtenerSubListas(int inicio, int finalVal) {
        if (inicio < 0 || finalVal < inicio || finalVal > alto) {
            throw new IllegalArgumentException("Los índices no son válidos");
        }
        
        return datos.subList(inicio, finalVal);
    }
    public void setDatos(List<ArrayList<Integer>> datos) {
        this.datos = datos;
    }

    public ArrayList<Integer> getLista(int i){
        return datos.get(i);
    }

    
    private void mostrarDatos() {
        for (ArrayList<Integer> fila : datos) {
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
        for (ArrayList<Integer> fila : datos) {
            System.out.println(fila.size());
        }
    }



    public int getAlto() {
        return this.alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return this.ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getMaximo() {
        return this.maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    public List<ArrayList<Integer>> getDatos() {
        return this.datos;
    }


    public Datos alto(int alto) {
        setAlto(alto);
        return this;
    }

    public Datos ancho(int ancho) {
        setAncho(ancho);
        return this;
    }

    public Datos maximo(int maximo) {
        setMaximo(maximo);
        return this;
    }

    public Datos datos(List<ArrayList<Integer>> datos) {
        setDatos(datos);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Datos)) {
            return false;
        }
        Datos datos = (Datos) o;
        return alto == datos.alto && ancho == datos.ancho && maximo == datos.maximo && Objects.equals(datos, datos.datos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alto, ancho, maximo, datos);
    }

    @Override
    public String toString() {
        return "{" +
            " alto='" + getAlto() + "'" +
            ", ancho='" + getAncho() + "'" +
            ", maximo='" + getMaximo() + "'" +
            ", datos='" + getDatos() + "'" +
            "}";
    }
    
    
}
