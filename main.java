import java.io.IOException;

class main {


    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        menu.iniciar();
        Ejecucion ejecucion = new Ejecucion(menu.getNombreArchivo(), menu.getAlgoritmo(), menu.getNElementoEstrucurante(),menu.getProcesamiento());
        ejecucion.iniciar();
    }
}