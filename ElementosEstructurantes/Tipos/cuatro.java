package ElementosEstructurantes.Tipos;

import java.util.ArrayList;

import Datos.Datos;


public class cuatro extends ElementoEstructuranteBase {
    // Erosion: 1 Dilatacion: 2
    public cuatro(int algoritmo, Datos datos) {
        super(algoritmo, datos);
    }

    // (i-1,j-1),(i,j),(i-1,j+1),(i+1,j-1),(i+1,j+1)
    /*
     * x  0  x
     * 0 (x) 0
     * x  0  x
     */

    @Override
    public ArrayList<Integer> patron(int filaInicio) {
        ArrayList<Integer> filaActual = datos.getLista(filaInicio);
        ArrayList<Integer> filaAnterior = datos.getLista(filaInicio - 1);
        ArrayList<Integer> filaSiguiente = datos.getLista(filaInicio + 1);
        ArrayList<Integer> nuevaFila = new ArrayList<>();
    
        int maximoLargo = Math.min(filaActual.size(), filaSiguiente.size());
    
        for (int i = 1; i < maximoLargo - 1; i++) {
            int valorCentral = filaActual.get(i);
            int valorIzquierda = filaActual.get(i - 1);
            int valorDerecha = filaActual.get(i + 1);
            int valorArriba = filaAnterior.get(i);
            int valorAbajo = filaSiguiente.get(i);
    
            int nuevoValor = 0;
    
            if (algoritmo == 1) {
                // Erosión: Escoge el valor mínimo
                nuevoValor = menor(valorCentral, valorIzquierda, valorDerecha, valorArriba, valorAbajo);
            } else if (algoritmo == 2) {
                // Dilatación: Escoge el valor máximo
                nuevoValor = mayor(valorCentral, valorIzquierda, valorDerecha, valorArriba, valorAbajo);
            }
    
            nuevaFila.add(nuevoValor);
        }
    
        return nuevaFila;
    }
    
}
