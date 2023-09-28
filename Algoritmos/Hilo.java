package Algoritmos;

import java.util.ArrayList;
import java.util.List;

import ElementosEstructurantes.Tipos.ElementoEstructuranteBase;

public class Hilo implements Runnable{
    ElementoEstructuranteBase elementoEstructurante;
    List<ArrayList<Integer>> nuevaSubListas = new ArrayList<>();
    GestionHilos gestion;

    int idHilo,inicio, finalVal;

    public Hilo(int idHilo,ElementoEstructuranteBase elementoEstructurante, int inicio, int finalVal, GestionHilos gestion){
        this.idHilo=idHilo;
        this.elementoEstructurante = elementoEstructurante;
        this.inicio = inicio;
        this.finalVal = finalVal;
        this.gestion = gestion;
    }

    
    @Override
    public void run() {
        operar();
    }


    public void operar(){
        ArrayList<Integer> nuevaLista = new ArrayList<Integer>();

        
        for (int i = inicio; i < finalVal; i++) {
            nuevaLista = elementoEstructurante.patron(i);
            nuevaSubListas.add(nuevaLista);   
        }

        //Enviar nueva sublista para ser agregada a la matriz
        gestion.unirSubListas( inicio, finalVal,nuevaSubListas);

        
    }
    
}
