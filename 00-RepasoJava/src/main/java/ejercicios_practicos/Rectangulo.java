/**
 * Crear una clase Rectangulo con atributos largo y ancho. 
 * Define un método calcularArea que devuelva el área del rectángulo.
 */
package ejercicios_practicos;

/**
 *
 * @author Videla Guliotti Tobías Uriel
 */
public class Rectangulo {
    private double largo;
    private double ancho;

    public Rectangulo(double largo, double ancho) {
        this.largo = largo;
        this.ancho = ancho;
    }
    
    public double calcularArea(){
        return this.largo * this.ancho;
    }
}
