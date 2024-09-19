package ejercicio2;

public class Docente extends Persona {
    private Materia materiaQueDicta;

    public Docente(String nombre, String DNI, Materia materia) {
        super(nombre, DNI);
        this.materiaQueDicta = materia;
    }
    
    public String getMateriaQueDicta() {
        return "[" + this.materiaQueDicta.getCodigo() + "] " + this.materiaQueDicta.getNombre() + "\n";
    }
}
