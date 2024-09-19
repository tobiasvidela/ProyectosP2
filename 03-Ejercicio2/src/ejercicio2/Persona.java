package ejercicio2;

public class Persona {
    protected String nombre;
    protected String DNI;
    
    public Persona (String nombre, String DNI) {
        this.nombre = nombre;
        this.DNI = DNI;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public String getDNI() {
        return this.DNI;
    }
}
