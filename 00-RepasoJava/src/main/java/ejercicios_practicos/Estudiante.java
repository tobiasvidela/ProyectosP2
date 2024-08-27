/**
 * Crear una clase Estudiante con atributos nombre, apellido, y promedio. 
 * Añade un método mostrarInfo que imprima el nombre completo del estudiante y su promedio.
 */
package ejercicios_practicos;

/**
 *
 * @author Videla Guliotti Tobías Uriel
 */
public class Estudiante {
    private String nombre;
    private String apellido;
    private double promedio;

    public Estudiante(String nombre, String apellido, double promedio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.promedio = promedio;
    }
    
    public void mostrarInfo(){
        System.out.println(this.nombre + " " + this.apellido + "\n Promedio: " + this.promedio);
    }
}
