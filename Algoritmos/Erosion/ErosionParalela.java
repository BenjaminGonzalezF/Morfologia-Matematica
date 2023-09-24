package Algoritmos.Erosion;

import java.util.ArrayList;

import Algoritmos.Estructura;
import Datos.Datos;
import ElementosEstructurantes.Tipos.ElementoEstructuranteBase;

public class ErosionParalela extends Estructura{
    
    ElementoEstructuranteBase elementoEstructurante;
    public ErosionParalela(int nElemento, Datos datos) {
        super(nElemento, datos);
        iniciar();
    }

    private void iniciar(){
        elementoEstructurante = this.aplicarElementoEstructurante(1, this.nElemento);

        int nIteraciones = (datos.getAlto() -1)/2 ;
        ArrayList<Integer> nuevaLista = new ArrayList<Integer>();

        // for (int i = 1; i < nIteraciones; i++) {
/*              nuevaLista = elementoEstructurante.patron(i*2);
             datos.reemplazarListaN(i*2, nuevaLista); */
        // }


        int inicioDeListas = 0;
        System.out.println("Listas : ");
        System.out.println(datos.getLista(inicioDeListas));
        System.out.println(datos.getLista(inicioDeListas+1));
        


        nuevaLista = elementoEstructurante.patron(inicioDeListas);
        datos.reemplazarListaN(inicioDeListas, nuevaLista);

        System.out.println("Lista Nueva: ");
        System.out.println(datos.getLista(inicioDeListas));
        
        
    
        
    }


}
