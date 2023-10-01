package ElementosEstructurantes.Tipos;

import java.util.ArrayList;

import Datos.Datos;

public class Tres extends ElementoEstructuranteBase {
	// Erosion: 1 Dilacion:2
	public Tres(int algoritmo, Datos datos) {
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
			int valorAReemplazar = primera.get(i);
			int valorIzquierda = primera.get(i - 1);
			int valorDerecha = primera.get(i + 1);
			int nuevoValor = 0;

			if (algoritmo == 1)
				;
			nuevoValor = menor(valorAReemplazar, valorIzquierda, valorDerecha);
			if (algoritmo == 2)
				;
			nuevoValor = mayor(valorAReemplazar, valorIzquierda, valorDerecha);

			nuevaLista.add(nuevoValor);
		}
		return nuevaLista;
	}
}
