package Algoritmos;
import Datos.Datos;
import ElementosEstructurantes.Tipos.*;

//Clase padre de las implementaciones de los algoritmos
public class Estructura {
    protected int nElemento;
    protected Datos datos;

    public Estructura (int nElemento, Datos datos){
        this.nElemento = nElemento;
        this.datos = datos;
    }


    public ElementoEstructuranteBase aplicarElementoEstructurante(int algoritmo, int nElemento){
    
        switch (nElemento) {
            case 1:
                Uno uno = new Uno(algoritmo,datos);
                return uno;
                // Realiza acciones relacionadas con uno
/*
            case 2:
                //Dos dos = new Dos(algoritmo);
                // Realiza acciones relacionadas con dos
                //return dos;
            case 3:
                // Tres tres = new Tres(algoritmo,datos);
                // Realiza acciones relacionadas con tres
                //return tres;
                break;
            case 4:
                // Cuatro cuatro = new Cuatro(algoritmo,datos);
                // Realiza acciones relacionadas con cuatro
                //return cuatro;
                break;
            case 5:
                // Cinco cinco = new Cinco(algoritmo,datos);
                // Realiza acciones relacionadas con cinco
                //return cinco;
                break;
                */
            default:
                System.out.println("Opción no válida. Introduce un valor del 1 al 5.");
        }
        return null;
    }
    
}
