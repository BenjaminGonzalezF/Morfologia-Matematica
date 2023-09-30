package Algoritmos.Erosion;

import Algoritmos.Estructura;
import Algoritmos.GestionHilos;
import Algoritmos.Hilo;
import Datos.Datos;
import ElementosEstructurantes.Tipos.ElementoEstructuranteBase;

public class ErosionParalela extends Estructura{
    
    ElementoEstructuranteBase elementoEstructurante;
    public ErosionParalela(int nElemento, Datos datos) {
        super(nElemento, datos);
    }

    public void iniciar(){
        elementoEstructurante = this.aplicarElementoEstructurante(1, this.nElemento);

        int nHilos  = Runtime.getRuntime().availableProcessors();
        GestionHilos gestionHilos = new GestionHilos(datos);
        Thread[] hilos = new Thread[nHilos];

        

        int indexInicial,indexFinal,sumador;

        sumador = datos.getAlto()/nHilos;
        indexInicial = 0;
        indexFinal = sumador;

        //Inicia todos los hilos
        for (int i = 0; i < nHilos; i++) {
            hilos[i] = new Thread(new Hilo(i+1,elementoEstructurante, indexInicial, indexFinal,gestionHilos));
            hilos[i].run();
            indexInicial = indexFinal + 1 ;
            indexFinal = indexFinal + sumador;
        }
        //Esperar a todos los hilos
        try {
            for (int i = 0; i < nHilos; i++) {
                hilos[i].join();
            }
        } catch (InterruptedException e) {
            System.err.println("Error al esperar a los hilos: " + e.getMessage());
        }
        
        System.out.println("Los hilos han terminado");

        this.generarPGM("ErosionParalelaElemento" + nElemento);
    }


}
