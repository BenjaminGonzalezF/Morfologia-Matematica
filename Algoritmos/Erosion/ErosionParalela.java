package Algoritmos.Erosion;

import java.util.ArrayList;
import java.util.List;

import Algoritmos.Estructura;
import Algoritmos.Hilo;
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
        int nHilos  = Runtime.getRuntime().availableProcessors();

        int indexInicial,indexFinal,operacion,sumador;

        sumador = datos.getAlto()/nHilos;
        indexInicial = 0;
        indexFinal = sumador;

        for (int i = 0; i < nHilos; i++) {

            List<ArrayList<Integer>> subListas = new ArrayList<>();
            //subListas = datos.obtenerSubListas(indexInicial, indexFinal);
            System.out.println("Ejecucion del hilo " + (i+1) );
            Hilo hilo = new Hilo(i,elementoEstructurante, indexInicial, indexFinal);
            hilo.run();
            indexInicial = indexFinal + 1 ;
            indexFinal = indexFinal + sumador;
        }



        // for (int i = 1; i < nIteraciones; i++) {
/*              nuevaLista = elementoEstructurante.patron(i*2);
             datos.reemplazarListaN(i*2, nuevaLista); */
        // }


/*         System.out.println("Listas : ");
        System.out.println(datos.getLista(inicioDeListas));
        System.out.println(datos.getLista(inicioDeListas+1));
         


        nuevaLista = elementoEstructurante.patron(inicioDeListas);
        datos.reemplazarListaN(inicioDeListas, nuevaLista);

        System.out.println("Lista Nueva: ");
        System.out.println(datos.getLista(inicioDeListas));
        */
        





        
        
    
        
    }


}
