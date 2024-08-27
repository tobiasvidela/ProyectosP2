/**
 * Crear una clase Banco que tenga una lista de objetos CuentaBancaria. 
 * Añade métodos para agregar cuentas a la lista y mostrar el saldo total del banco.
 */
package ejercicios_practicos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Videla Guliotti Tobías Uriel
 */
public class Banco {
    private List<CuentaBancaria> cuentas;
    
    public Banco(){
        this.cuentas = new ArrayList<>();
    }
    
    public void agregarCuentaBancaria(CuentaBancaria cuenta){
        this.cuentas.add(cuenta);
    }
    
    public double obtenerSaldoTotal() {
        double saldoTotal = 0;
        for (CuentaBancaria cuenta : cuentas) {
            saldoTotal += cuenta.getSaldo();
        }
        return saldoTotal;
    }

    public void mostrarSaldoTotal() {
        System.out.println("Saldo total del banco: " + obtenerSaldoTotal());
    }
}
