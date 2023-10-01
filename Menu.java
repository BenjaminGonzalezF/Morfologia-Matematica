import java.io.File;

public class Menu {
    //Se deben hacer las validaciones de entradas

    int algoritmo = 0 ;
    int nElementoEstrucurante = 0;
    int procesamiento = 0;
    String nombreArchivo = "";

    

    public void seleccionAlgoritmo(){

        while (algoritmo<=0 || algoritmo > 3){
            System.out.println("Ingrese el algoritmo a ejecutar");
            System.out.println("1. Erosion");
            System.out.println("2. Dilatacion");
            System.out.println("3. Volver atras");
            System.out.println("4. Salir");
            try {
                algoritmo = Integer.parseInt(System.console().readLine());
                if(algoritmo<=0 || algoritmo > 3){
                    System.out.println("Error: Ingrese un numero valido");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un valor numerico\n");
            }
        }
        if(algoritmo == 3){
            solicitarNombreDeArchivo();
        }
        if(algoritmo == 4){
            terminarEjecucion();
        }
        seleccionTipoProcesamiento();
    }

    private void solicitarNombreDeArchivo() {
        while (true) {
            System.out.println("Ingrese el nombre del archivo +.pgm ");
            try {
                nombreArchivo = System.console().readLine();
                File archivo = new File(nombreArchivo);
                if (!nombreArchivo.endsWith(".pgm")) {
                    System.out.println("Error: El archivo debe ser formato pgm");
                    continue;
                }
                if (!archivo.exists()) {
                    System.out.println("El archivo no existe");
                    continue;
                } 
            } catch (Exception e) {
                System.out.println("Error: Compruebe el nombre del archivo");
            }
            break;
        }
        algoritmo = 0;
        seleccionAlgoritmo();
    }

    
    private void seleccionTipoProcesamiento(){
        while (true){
            System.out.println("Ingrese número del tipo de procesamiento\n");
            System.out.println("1. Secuencial");
            System.out.println("2. Paralelo");
            System.out.println("3. Volver atras ");
            System.out.println("4. Salir ");
            try {
                procesamiento = Integer.parseInt(System.console().readLine());
                if(procesamiento<1 || procesamiento > 4){
                    System.out.println("Error: Ingrese un numero valido");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un valor numerico");
                continue;
            }

            if(procesamiento == 3){
                seleccionAlgoritmo();
            }
            if(procesamiento == 4){
                terminarEjecucion();
            }
            break;
        }
        seleccionElementoEstructurante();
    }

    //Crea una funcion que sea un menu de selección de un elemento estructurante, el usuario debe ingresar por consola el número del elemento estriucturante que desa las opciones son del 1 al 5, 6 es para volver atras y 7 para salir, todo validado */
    private void seleccionElementoEstructurante(){
        while (true){
            System.out.println("Ingrese número del elemento estructurante\n");
            System.out.println("1. Elemento estructurante 1 ");
            System.out.println("2. Elemento estructurante 2 ");
            System.out.println("3. Elemento estructurante 3 ");
            System.out.println("4. Elemento estructurante 4 ");
            System.out.println("5. Elemento estructurante 5 ");
            System.out.println("6. Volver atras ");
            System.out.println("7. Salir ");
            try {
                nElementoEstrucurante = Integer.parseInt(System.console().readLine());
                if(nElementoEstrucurante<=0 || nElementoEstrucurante > 7){
                    System.out.println("Error: Ingrese un numero valido");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un valor numerico");
                continue;
            }
            if(nElementoEstrucurante == 6){
                this.algoritmo = 0;
                seleccionTipoProcesamiento();
            }
            if(nElementoEstrucurante == 7){
                terminarEjecucion();
            }
            break;
        }
    }


    private void terminarEjecucion(){
        System.out.println("Adios");
        System.exit(0);
    }

    public void resetearAtributos(){
         algoritmo = 0 ;
         nElementoEstrucurante = 0;
         procesamiento = 0;
    }
    public Menu(){
    }

    public void iniciar(){
        if(nombreArchivo == ""){
            solicitarNombreDeArchivo();
        }
        else{
            seleccionAlgoritmo();
        }
    }

    public int getAlgoritmo() {
        return this.algoritmo;
    }

    public int getNElementoEstrucurante() {
        return this.nElementoEstrucurante;
    }

    public String getNombreArchivo() {
        return this.nombreArchivo;
    }

    public int getProcesamiento() {
        return this.procesamiento;
    }



}
