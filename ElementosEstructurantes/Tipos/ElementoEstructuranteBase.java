package ElementosEstructurantes.Tipos;

import java.util.ArrayList;
import Datos.Datos;

public abstract class ElementoEstructuranteBase {
    //Erosion: 1 Dilacion:2
    protected int algoritmo = 0;
    protected Datos datos;


    //Constructor
    public ElementoEstructuranteBase(int algoritmo, Datos datos ){
        this.algoritmo = algoritmo;
        this.datos = datos;
    }

    //Esta clase debe ser implementada por cada hijo, ya que todos los patrones son diferentes
    //Devuelve una lista de integer a la cual ya se le ha aplicado el patron
    public abstract ArrayList<Integer>  patron(int filaInicio);

    public int menor(int a, int b, int c) {
        int menor = a;
        if (b < menor) {
            menor = b;
        }
        if (c < menor) {
            menor = c;
        }
        return menor;
    }


    public int mayor(int a, int b, int c) {
        int mayor = a;
        if (b > mayor) {
            mayor = b;
        }
        if (c > mayor) {
            mayor = c;
        }
        return mayor;
    }


    public ArrayList<Integer> listaMayor(ArrayList<Integer> uno ,ArrayList<Integer> dos ){
        if(uno.size() > dos.size()){
            return uno;
        }
        return dos;
    }

    public ArrayList<Integer> listaMenor(ArrayList<Integer> uno ,ArrayList<Integer> dos ){
        if(uno.size() < dos.size()){
            return uno;
        }
        return dos;
    }


    public int getAlgoritmo() {
        return this.algoritmo;
    }

    public Datos getDatos() {
        return this.datos;
    }

}
