package Algoritmos;

import java.util.ArrayList;
import java.util.List;

import Datos.Datos;

public class GestionHilos {
    protected Datos datos;
    List<ArrayList<Integer>> nuevosDatos = new ArrayList<>();
    
    public GestionHilos(Datos datos){
        this.datos = datos;
    }

    public synchronized void unirSubListas(int indexInicial, int indexFinal, List<ArrayList<Integer>> nuevaSubListas){
        for (int i = indexInicial; i < indexFinal ; i++) {
            datos.setNuevosDatos(datos.getDatos());

            datos.reemplazarNuevaListaN(i, nuevaSubListas.get(0));
            nuevaSubListas.remove(0);
        }

    }




    
}
