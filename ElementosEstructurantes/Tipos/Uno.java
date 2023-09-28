package ElementosEstructurantes.Tipos;

import java.util.ArrayList;

import Datos.Datos;

public class Uno extends ElementoEstructuranteBase {
    //Erosion: 1 Dilacion:2
    public Uno(int algoritmo, Datos datos) {
        super(algoritmo,datos);
    }

    // (i,j-1),(i,j),(i-1,j)
    /*
     * x (x) 0
     * 0  x  0
     */

    //  Esta funcion comienza desde una fila de inicio que corresponde al iterador "i" de la matriz 
    //  y trabaja con 2 filas contiguas, luego realiza el patron uno
     
    @Override
    public ArrayList<Integer>  patron(int filainicio) {
        ArrayList<Integer> primera = datos.getLista(filainicio);
        ArrayList<Integer> segunda = datos.getLista(filainicio + 1);
        ArrayList<Integer> nuevaLista = new ArrayList<Integer>();
        nuevaLista.add(primera.get(0));


        int maximoLargo = listaMenor(primera, segunda).size();

        for (int i = 1; i < maximoLargo - 1; i++) {
            int valorAReemplazar = primera.get(i);
            int valorIzquierda = primera.get(i - 1);
            int valorAbajo = segunda.get(i);
            int nuevoValor = 0;
/* 
/*             System.out.println("Valor a reemplazar :" +valorAReemplazar +
                                "Valor izquierda: " + valorIzquierda + 
                                " Valor abajo: " + valorAbajo);
            System.out.println(valorAReemplazar + "Se remplaza por " + mayor(valorAReemplazar, valorIzquierda, valorAbajo)); */
            if(algoritmo == 1 ){
                nuevoValor= menor(valorAReemplazar, valorIzquierda, valorAbajo);
            }
            if(algoritmo == 2 ){
                nuevoValor = mayor(valorAReemplazar, valorIzquierda, valorAbajo);
            }

            nuevaLista.add(nuevoValor);
        }

        return nuevaLista;
    }

}
