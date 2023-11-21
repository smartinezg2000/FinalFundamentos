import java.util.Scanner; //importar librería para poder utilizar entrada por teclado

public class Main {
    
    public static void main(String[] args) {  
        // Creación de un objeto de la clase Avion para gestionar la información del avión y sus pasajeros
        Avion avion = new Avion();
        
        // Creación de un objeto Scanner para obtener la entrada del usuario
        Scanner input = new Scanner(System.in);
    
        // Variable para almacenar la opción del menú seleccionada por el usuario
        String opcionUsuario = "a";
        
        // Bucle principal del programa que se ejecuta hasta que el usuario elige salir (opción "F")
        while (!opcionUsuario.equals("F")) {
            // Mostrar menú de opciones al usuario
            System.out.println("A. Nombre del archivo con la estructura del avion.");
            System.out.println("B. Ingresar pasajero");
            System.out.println("C. Dinero recaudado hoy");
            System.out.println("D. Lista de pasajeros");
            System.out.println("E. Edad promedio de los pasajeros.");
            System.out.println("F. Termina programa.");
            System.out.println("G. Imprimir mapa del avion.");
            
            // Leer la opción del usuario y convertirla a mayúsculas para evitar errores con mayúsculas y minúsculas
            opcionUsuario = input.nextLine().toUpperCase();
            
            // Realizar acciones según la opción seleccionada por el usuario
            if (opcionUsuario.equals("A")) {
                // Leer el nombre del archivo proporcionado por el usuario y cargar la estructura del avión desde ese archivo
                System.out.println("Escribe el nombre del archivo");
                String archivo = input.nextLine();
                System.out.print('\u000C');  // Limpiar la pantalla
                avion.leerEstructura(archivo);
                System.out.println();
            } else if (opcionUsuario.equals("B")) {
                // Solicitar al usuario información sobre un nuevo pasajero y agregarlo a la lista de pasajeros del avión
                System.out.println("Escribe el nombre del pasajero");
                String nombre = input.nextLine();
                System.out.println("Edad");
                int edad = input.nextInt();
                System.out.println("Escribe el precio en enteros");
                int precioTiquete = input.nextInt();
                System.out.println("la fila");
                int fila = input.nextInt();
                System.out.println("la columna");
                int columna = input.nextInt();
                input.nextLine();  // Limpiar el buffer del Scanner
                Pasajero pasajero = new Pasajero(nombre, precioTiquete, edad, fila, columna);
                System.out.print('\u000C');  // Limpiar la pantalla
                avion.agregarPasajero(pasajero);
                System.out.println();
            } else if (opcionUsuario.equals("C")) {
                // Mostrar la cantidad de dinero recaudado hoy por la venta de boletos
                System.out.print('\u000C');  // Limpiar la pantalla
                System.out.println("El dinero recaudado es : " + avion.leerDinero());
                System.out.println();
            } else if (opcionUsuario.equals("D")) {
                // Mostrar la lista de nombres de los pasajeros en el avión
                System.out.print('\u000C');  // Limpiar la pantalla
                avion.imprimirNombres();
                System.out.println();
            } else if (opcionUsuario.equals("E")) {
                // Calcular y mostrar la edad promedio de los pasajeros en el avión
                System.out.print('\u000C');  // Limpiar la pantalla
                System.out.println("La edad promedio de los pasajeros es: " + avion.calcularEdadPromedio());
                System.out.println();
            } else if (opcionUsuario.equals("G")) {
                // Imprimir la estructura del avión en forma de mapa
                System.out.print('\u000C');  // Limpiar la pantalla
                avion.imprimirEstructura();
                System.out.println();
            }
        }
        // Aca termina el programa y manda este mensaje
        System.out.println("Programa terminado.");
    }
}
