package Algoritmos;
import Datos.*;
import ElementosEstructurantes.Tipos.*;

public class Estructura {
	protected int nElemento;
	protected Datos datos;

	public Estructura(int nElemento, Datos datos) {
		this.nElemento = nElemento;
		this.datos = datos;
	}

    public void generarPGM(String algoritmo){
         CrearPGM crearArchivo = new CrearPGM(algoritmo, this.datos);
         crearArchivo.crear();
    }

    public ElementoEstructuranteBase aplicarElementoEstructurante(int algoritmo, int nElemento){
    
        switch (nElemento) {
            case 1:
                Uno uno = new Uno(algoritmo,datos);
                return uno;
                // Realiza acciones relacionadas con uno
            case 2:
                Dos dos = new Dos(algoritmo,datos);
                // Realiza acciones relacionadas con dos
                return dos;
            case 3:
                 Tres tres = new Tres(algoritmo,datos);
                // Realiza acciones relacionadas con tres
                return tres;
            case 4:
                 Cuatro cuatro = new Cuatro(algoritmo,datos);
                // Realiza acciones relacionadas con cuatro
                return cuatro;
            case 5:
                 Cinco cinco = new Cinco(algoritmo,datos);
                // Realiza acciones relacionadas con cinco
                return cinco;               
            default:
                System.out.println("Opción no válida. Introduce un valor del 1 al 5.");
        }
        return null;
    }
    
}
