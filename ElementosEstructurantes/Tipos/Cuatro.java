package ElementosEstructurantes.Tipos;
import java.util.ArrayList;

import Datos.Datos;

public class Cuatro extends ElementoEstructuranteBase {
    // Erosion: 1 Dilacion:2
    public Cuatro(int algoritmo, Datos datos) {
        super(algoritmo, datos);
    }

    @Override
    public ArrayList<Integer> patron(int filainicio) {
        ArrayList<Integer> primera = datos.getLista(filainicio);
        ArrayList<Integer> segunda = datos.getLista(filainicio + 1);
        ArrayList<Integer> nuevaLista = new ArrayList<Integer>();
        nuevaLista = primera;

        int maximoLargo = listaMenor(primera, segunda).size();

        for (int i = 1; i < maximoLargo - 1; i++) {
            int valorAReemplazar = primera.get(i);
            int valorAbajo = segunda.get(i);
            int nuevoValor = 0;

            if (algoritmo == 1){
                nuevoValor = menor(valorAReemplazar, valorAbajo, 255);
            }
            if (algoritmo == 2){
                nuevoValor = mayor(valorAReemplazar, valorAbajo, 0);
            }
            nuevaLista.set(i,nuevoValor);
        }
        return nuevaLista;
    }
}