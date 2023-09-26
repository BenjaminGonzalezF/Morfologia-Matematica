package Algoritmos;

import java.util.ArrayList;
import java.util.List;

import Datos.Datos;
import ElementosEstructurantes.Tipos.ElementoEstructuranteBase;

public class Hilo implements Runnable{
    ElementoEstructuranteBase elementoEstructurante;
    List<ArrayList<Integer>> nuevaSubListas = new ArrayList<>();

    int idHilo,inicio, finalVal;

    public Hilo(int idHilo,ElementoEstructuranteBase elementoEstructurante, int inicio, int finalVal){
        this.idHilo=idHilo;
        this.elementoEstructurante = elementoEstructurante;
        this.inicio = inicio;
        this.finalVal = finalVal;
    }

    
    @Override
    public void run() {
        // TODO Auto-generated method stub
        operar();
    }


    public void operar(){
        ArrayList<Integer> nuevaLista = new ArrayList<Integer>();


        for (int i = inicio; i < finalVal; i++) {
            nuevaLista = elementoEstructurante.patron(i);
            nuevaSubListas.add(nuevaLista);   
        }
        System.out.println("Nueva sublistas " + nuevaSubListas);

        //Enviar nueva sublista para ser agregada a la nueva matriz
    }
    
}
