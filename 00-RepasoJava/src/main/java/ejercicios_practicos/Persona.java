/**
 * Crear una clase Persona con atributos nombre y edad. 
 * Agrega un método esMayorDeEdad que devuelva true si la persona tiene 18 años o más.
 */
package ejercicios_practicos;

/**
 *
 * @author Videla Guliotti Tobías Uriel
 */
public class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    public boolean esMayorDeEdad(){
        return this.edad >= 18;
    }
}
