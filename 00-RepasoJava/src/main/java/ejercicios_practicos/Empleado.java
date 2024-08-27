/**
 * Crear una clase Empleado con atributos nombre, sueldoBase, y antigüedad. 
 * Implementa un método calcularSueldo que aumente el sueldo base un 10% por cada año de antigüedad.
 */
package ejercicios_practicos;

/**
 *
 * @author Videla Guliotti Tobías Uriel
 */
public class Empleado {
    private String nombre;
    private double sueldoBase;
    private int antiguedad;

    public Empleado(String nombre, double sueldoBase, int antiguedad) {
        this.nombre = nombre;
        this.sueldoBase = sueldoBase;
        this.antiguedad = antiguedad;
    }
    
    public void calcularSueldo(){
        System.out.println("Actual sueldo base: " + this.sueldoBase);
        this.sueldoBase += (this.sueldoBase * 0.10) * this.antiguedad;
        System.out.println("Nuevo sueldo base: " + this.sueldoBase);
    }
}
