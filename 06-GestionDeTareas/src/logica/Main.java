package logica;

public class Main {
    public static String USUARIO_ACTUAL = null;
    
    public static void main(String[] args) {
        try {
            Util.conectarBaseDatos();
        } catch (Exception e) {
            System.out.println(e);
        }//finally { }
    }
}
