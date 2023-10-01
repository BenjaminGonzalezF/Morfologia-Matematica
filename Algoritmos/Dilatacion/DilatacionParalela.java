package Algoritmos.Dilatacion;

import Algoritmos.Estructura;
import Algoritmos.GestionHilos;
import Algoritmos.Hilo;
import Datos.Datos;
import ElementosEstructurantes.Tipos.ElementoEstructuranteBase;

public class DilatacionParalela extends Estructura {
    
    private ElementoEstructuranteBase elementoEstructurante;

    public DilatacionParalela(int nElemento, Datos datos) {
        super(nElemento, datos);
    }

    public void iniciar() {
        elementoEstructurante = aplicarElementoEstructurante(2, nElemento);

        int nHilos = Runtime.getRuntime().availableProcessors();
        GestionHilos gestionHilos = new GestionHilos(datos);
        Thread[] hilos = new Thread[nHilos];

        int sumador = datos.getAlto() / nHilos;
        int indexInicial = 0;
        int indexFinal = sumador;

        // Iniciar todos los hilos para realizar la dilatación
        for (int i = 0; i < nHilos; i++) {
            hilos[i] = new Thread(new Hilo(i+1,elementoEstructurante, indexInicial, indexFinal,gestionHilos));
            hilos[i].start();
            indexInicial = indexFinal + 1;
            indexFinal += sumador;
        }

        // Esperar a que todos los hilos terminen
        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                System.err.println("Error al esperar a los hilos: " + e.getMessage());
            }
        }
        
        System.out.println("Los hilos han terminado");

        generarPGM("DilatacionParalelaElemento" + nElemento);
    }
}

