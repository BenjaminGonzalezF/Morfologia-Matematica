public class Matriz {
    private static Matriz instance = null;
    private int[][] matriz;
    private int alto,ancho;

    private Matriz(int alto, int ancho) {
        this.alto = alto;
        this.ancho = ancho;
        matriz = new int[alto][ancho]; 
    }


    public Matriz getInstance() {
        if (instance == null) {
            instance = new Matriz(this.alto, this.ancho);
        }
        return instance;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    
}
