package ElementosEstructurantes.Tipos;

import java.util.ArrayList;

import Datos.Datos;

public class Dos extends ElementoEstructuranteBase {
	// Erosion: 1 Dilacion:2
	public Dos(int algoritmo, Datos datos) {
		super(algoritmo, datos);
	}
	@Override
	public ArrayList<Integer> patron(int filainicio) {
		ArrayList<Integer> primera = datos.getLista(filainicio);
		ArrayList<Integer> segunda = datos.getLista(filainicio + 1);
		ArrayList<Integer> nuevaLista = new ArrayList<Integer>();
		nuevaLista.add(primera.get(0));

		int maximoLargo = listaMenor(primera, segunda).size();

		for (int i = 1; i < maximoLargo - 1; i++) {
			int valorAReemplazar = segunda.get(i);
			int valorArriba = primera.get(i);
			int valorIzquierda = segunda.get(i - 1);
			int nuevoValor = 0;

			/*
			 * System.out.println("Valor a reemplazar :" +valorAReemplazar +
			 * "Valor izquierda: " + valorIzquierda + " Valor abajo: " + valorAbajo);
			 * System.out.println(valorAReemplazar + "Se remplaza por " +ß
			 * mayor(valorAReemplazar, valorIzquierda, valorAbajo));
			 */

			if (algoritmo == 1)
				;
			nuevoValor = menor(valorAReemplazar, valorIzquierda, valorArriba);
			if (algoritmo == 2)
				;
			nuevoValor = mayor(valorAReemplazar, valorIzquierda, valorArriba);

			nuevaLista.add(nuevoValor);
		}

		return nuevaLista;
	}

}
