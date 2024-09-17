# Proyectos Programación 2
Repositorio para alojar todos los proyectos que se desarrollen a lo largo de la materia **Programación 2**.
## Proyectos
1. **Práctica POO**:
    - **Crear un proyecto en NetBeans**:
        - Crear una clase llamada `Libro`. La clase debe tener atributos como `titulo`, `autor`, y `numeroDePaginas` . Define un método `mostrarDetalles` que imprima los detalles del libro.
        - Crear una clase `Persona` con atributos `nombre` y `edad`. Agrega un método `esMayorDeEdad` que devuelva `true` si la persona tiene 18 años o más.
        - Crear una clase `Rectangulo` con atributos `largo` y `ancho`. Define un método `calcularArea` que devuelva el área del rectángulo.
        - Crear una clase `CuentaBancaria` con un atributo `saldo`. Implementa métodos para `depositar` y `retirar` dinero, asegurando que no se pueda retirar más del saldo disponible. 
        - Crear una clase `Vehiculo` con atributos `marca`, `modelo`, y `velocidad`. Añade un método `acelerar` que aumente la velocidad en 10 unidades y otro método `frenar` que disminuya la velocidad en 10 unidades.
        - Crear una clase `Animal` con un atributo `nombre`. Implementa un método `hacerSonido` que imprima un sonido genérico. Luego, crea subclases `Perro` y `Gato` que sobrescriban el método `hacerSonido` con un sonido específico para cada animal.
        - Crear una clase `Estudiante` con atributos `nombre`, `apellido`, y `promedio`. Añade un método `mostrarInfo` que imprima el nombre completo del estudiante y su promedio.
        - Crear una clase `Producto` con atributos `nombre`, `precio`, y `stock`. Implementa un método `aplicarDescuento` que reciba un porcentaje y disminuya el precio en ese porcentaje. 
        - Crear una clase `Banco` que tenga una lista de objetos `CuentaBancaria`. Añade métodos para agregar cuentas a la lista y mostrar el saldo total del banco. 
        - Crear una clase `Empleado` con atributos `nombre`, `sueldoBase`, y `antigüedad`. Implementa un método `calcularSueldo` que aumente el sueldo base un 10% por cada año de antigüedad.
1. **TP1 | Gestión de Tareas**:
    - **Objetivo**: Desarrollar una aplicación de consola en Java para gestionar tareas personales, donde los usuarios puedan registrarse y realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre sus tareas.
    - **Requerimientos**:
        1. **Registro de Usuarios**:
            - Los usuarios deben poder registrarse proporcionando un nombre de usuario y una contraseña.
            - No se permiten nombres de usuario duplicados.
            - La aplicación debe almacenar temporalmente los usuarios registrados en memoria.
        1. **Gestión de Tareas**:
            - **Crear Tarea**: Los usuarios deben poder crear nuevas tareas proporcionando un título, una descripción y asignando un estado inicial (Nuevo, Pendiente, Finalizado).
            - **Ver Tareas**: Los usuarios deben poder ver la lista de todas sus tareas con su ID, título, descripción y estado.
            - **Actualizar Tarea**: Los usuarios deben poder actualizar el título, la descripción y el estado de una tarea específica, identificándola por su ID.
            - **Eliminar Tarea**: Los usuarios deben poder eliminar una tarea específica, identificándola por su ID.
        1. **Cerrar sesión**:
            - Los usuarios deben poder cerrar sesión y regresar al menú principal.
---
*Videla Guliotti Tobías Uriel*
