/**
 * Crear una clase llamada Libro. 
 * La clase debe tener atributos como titulo, autor, y numeroDePaginas. 
 * Define un método mostrarDetalles que imprima los detalles del libro.
*/
package ejercicios_practicos;

/**
 *
 * @author Videla Guliotti Tobías Uriel
 */
public class Libro {
    private String titulo;
    private String autor;
    private int numeroDePaginas;

    public Libro(String titulo, String autor, int numeroDePaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroDePaginas = numeroDePaginas;
    }
    
    public void mostrarDetalles(){
        System.out.println("Detalles del libro");
        System.out.println(" Título: " + this.titulo);
        System.out.println(" Autor: " + this.autor);
        System.out.println(" Número de Páginas: " + this.numeroDePaginas);
    }
}
