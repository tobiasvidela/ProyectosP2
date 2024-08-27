/**
 * Crear una clase Producto con atributos nombre, precio, y stock. 
 * Implementa un método aplicarDescuento que reciba un porcentaje y disminuya el precio en ese porcentaje.
 */
package ejercicios_practicos;

/**
 *
 * @author Videla Guliotti Tobías Uriel
 */
public class Producto {
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    
    /**
     * 
     * @param porcentaje : valores double entre 0 y 1
     */
    public void aplicarDescuento(double porcentaje){
        this.precio -= this.precio * porcentaje;
    }
}
