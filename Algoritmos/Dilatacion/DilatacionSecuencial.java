package Algoritmos.Dilatacion;

import java.util.ArrayList;

import Algoritmos.Estructura;
import Datos.Datos;
import ElementosEstructurantes.Tipos.ElementoEstructuranteBase;

public class DilatacionSecuencial extends Estructura {

        
    ElementoEstructuranteBase elementoEstructurante;
    public DilatacionSecuencial(int nElemento, Datos datos) {
        super(nElemento, datos);
    }

    public void iniciar(){
        elementoEstructurante = this.aplicarElementoEstructurante(1, this.nElemento);
        datos.setNuevosDatos(datos.getDatos());

        for (int i = 0; i < datos.getAlto() -1; i++) {
            ArrayList<Integer> nuevaLista = elementoEstructurante.patron(i);
            datos.reemplazarNuevaListaN(i, nuevaLista);
        }           
        
        this.generarPGM("DilatacionSecuencialElemento" + nElemento);
    }
}