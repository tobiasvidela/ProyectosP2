package ejercicio2;

public class Alumno extends Persona {
    private Materia materiaQueCursa;

    public Alumno(String nombre, String DNI, Materia materia) {
        super(nombre, DNI);
        this.materiaQueCursa = materia;
    }
    
    public String getMateriaQueCursa() {
        return "[" + this.materiaQueCursa.getCodigo() + "] " + this.materiaQueCursa.getNombre() + "\n";
    }
}
