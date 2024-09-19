/** 
 * EJERCICIO 2: Ingreso de datos por teclado.
 * 
 * Desarrollar un sistema (solo declarar los atributos y métodos)
 * Clase padre: persona
 * Clases hijos: Docentes, Alumnos
 * Clase materia
 * 
 * Inicializar en la creación del objeto docentes que dictan una materia y alumnos que cursan una determinada materia
 */
package ejercicio2;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    public static int cantidadMaterias = 3;
    public static int cantidadDocentes = 3;
    public static int cantidadAlumnos = 3;

    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema educativo");

        // Crear materias
        Materia[] materias = new Materia[cantidadMaterias];
        for (int i = 0; i < materias.length; i++) {
            materias[i] = crearMateria(i + 1);
        }

        // Crear docentes
        Docente[] docentes = new Docente[cantidadDocentes];
        for (int i = 0; i < docentes.length; i++) {
            docentes[i] = crearDocente(i + 1, materias);
        }

        // Crear alumnos
        Alumno[] alumnos = new Alumno[cantidadAlumnos];
        for (int i = 0; i < alumnos.length; i++) {
            alumnos[i] = crearAlumno(i + 1, materias);
        }

        // Mostrar información
        System.out.println("\nDocentes y sus materias:");
        for (Docente docente : docentes) {
            mostrarDocenteYMateria(docente);
        }

        System.out.println("\nAlumnos y sus materias:");
        for (Alumno alumno : alumnos) {
            mostrarAlumnoYMateria(alumno);
        }
    }

    private static Materia crearMateria(int numero) {
        System.out.println("Ingrese los datos para la materia " + numero + ":");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        return new Materia(nombre, codigo);
    }

    private static Docente crearDocente(int numero, Materia[] materias) {
        System.out.println("Ingrese los datos para el docente " + numero + ":");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("DNI: ");
        String dni = scanner.nextLine();
        System.out.println("Seleccione la materia que dicta (1-3):");
        for (int i = 0; i < materias.length; i++) {
            System.out.println((i + 1) + ". " + materias[i].getNombre());
        }
        int seleccion = Integer.parseInt(scanner.nextLine()) - 1;
        return new Docente(nombre, dni, materias[seleccion]);
    }

    private static Alumno crearAlumno(int numero, Materia[] materias) {
        System.out.println("Ingrese los datos para el alumno " + numero + ":");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("DNI: ");
        String dni = scanner.nextLine();
        System.out.println("Seleccione la materia que cursa (1-3):");
        for (int i = 0; i < materias.length; i++) {
            System.out.println((i + 1) + ". " + materias[i].getNombre());
        }
        int seleccion = Integer.parseInt(scanner.nextLine()) - 1;
        return new Alumno(nombre, dni, materias[seleccion]);
    }

    private static void mostrarDocenteYMateria(Docente docente) {
        System.out.println(docente.getNombre() + " dicta " + docente.getMateriaQueDicta());
    }

    private static void mostrarAlumnoYMateria(Alumno alumno) {
        System.out.println(alumno.getNombre() + " cursa " + alumno.getMateriaQueCursa());
    }
}
