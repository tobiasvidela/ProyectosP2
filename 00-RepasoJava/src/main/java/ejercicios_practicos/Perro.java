/**
 * Crear una clase Animal con un atributo nombre. 
 * Implementa un método hacerSonido que imprima un sonido genérico. 
 * Luego, crea subclases Perro y Gato que sobrescriban el método hacerSonido con un sonido específico para cada animal.
 */
package ejercicios_practicos;

/**
 *
 * @author Videla Guliotti Tobías Uriel
 */
public class Perro extends Animal {
    @Override
    public void hacerSonido(){
        System.out.println("Woof!");
    }
}
