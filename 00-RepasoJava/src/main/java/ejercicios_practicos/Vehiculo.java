/**
 * Crear una clase Vehiculo con atributos marca, modelo, y velocidad. 
 * Añade un método acelerar que aumente la velocidad en 10 unidades y 
 * otro método frenar que disminuya la velocidad en 10 unidades.
 */
package ejercicios_practicos;

/**
 *
 * @author Videla Guliotti Tobías Uriel
 */
public class Vehiculo {
    private String marca;
    private String modelo;
    private double velocidad = 0;
    
    public void acelerar(){
        this.velocidad += 10;
    }
    public void frenar(){
        this.velocidad -= 10;
    }
}
