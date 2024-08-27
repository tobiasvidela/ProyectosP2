/**
 * Crear una clase CuentaBancaria con un atributo saldo. 
 * Implementa métodos para depositar y retirar dinero, asegurando que no se pueda retirar más del saldo disponible.
 */
package ejercicios_practicos;

/**
 *
 * @author Videla Guliotti Tobías Uriel
 */
public class CuentaBancaria {
    private double saldo = 0;
    
    public double getSaldo(){
        return this.saldo;
    }
    
    public void depositar(double monto){
        this.saldo += monto;
    }
    public void retirar(double monto){
        if (monto <= this.saldo) {
            this.saldo -= monto;
        }
        else {
            System.out.println("El saldo disponible es menor que el monto que se desea retirar.");
        }
    }
}
