//importar librerías
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException; 

public class Avion {
    // Matriz para representar las sillas del avión, donde cada elemento puede contener un objeto Pasajero
    Pasajero[][] sillas;

    // Número total de filas en el avión
    int numFilas;

    // Método para leer la estructura del avión desde un archivo
    public void leerEstructura(String nombreArchivo) {
        try {
            // Crear un objeto Scanner para leer el archivo proporcionado
            Scanner sc = new Scanner(new File(nombreArchivo));

            // Leer el número total de filas en el avión
            this.numFilas = sc.nextInt();

            // Leer el número total de clases en el avión
            int numClases = sc.nextInt();
            
            // Inicializar la matriz de sillas con el número total de filas
            sillas = new Pasajero[numFilas][];

            // Inicializar variables para rastrear la posición actual en la matriz de sillas
            int fila = 0;

            // Leer la información de cada clase
            for (int clase = 0; clase < numClases; clase++) {
                // Leer el número de filas y el número de sillas por fila para la clase actual
                int numFilasClase = sc.nextInt();
                int numSillasClase = sc.nextInt();

                // Crear un arreglo de Pasajero para representar la fila de sillas en la clase actual
                for (int i = 0; i < numFilasClase; i++) {
                    Pasajero[] filaDeSillas = new Pasajero[numSillasClase];
                    // Asignar la fila de sillas recién creada a la matriz de sillas
                    sillas[fila] = filaDeSillas;
                    // Incrementar la posición de la fila
                    fila++;
                }
            }
            System.out.println("Estructura creada, filas: " + fila);

        } catch (FileNotFoundException e) { // Excepción caso de que el archivo no pueda ser encontrado
            System.out.println("Archivo no existe: " + nombreArchivo);  // Imprimir un mensaje indicando que el archivo no existe
        }
    }
    
    // Método para agregar un pasajero a una silla específica en el avión
    public boolean agregarPasajero(Pasajero pasajero) {
        // Verificar si la fila proporcionada es válida
        if (pasajero.getFila() < 0 || pasajero.getFila() >= numFilas) {
            System.out.println("Fila es inválida");
            // Devolver false para indicar que la operación de agregar pasajero ha fallado
            return false;
        }
    
        // Verificar si la columna proporcionada es válida para la fila dada
        if (pasajero.getColumna() < 0 || pasajero.getColumna() >= sillas[pasajero.getFila()].length) {
            System.out.println("Columna inválida");
            // Devolver false para indicar que la operación de agregar pasajero ha fallado
            return false;
        }
    
        // Verificar si la silla seleccionada está disponible (no ocupada por otro pasajero)
        if (sillas[pasajero.getFila()][pasajero.getColumna()] == null) {
            // Asignar la silla al pasajero
            sillas[pasajero.getFila()][pasajero.getColumna()] = pasajero;
            // Imprimir un mensaje indicando que el pasajero ha sido asignado correctamente a la silla
            System.out.println("Pasajero " + pasajero.getNombre() + " asignado");
            // Devolver true para indicar que la operación de agregar pasajero ha tenido éxito
            return true;
        } else {
            // Imprimir un mensaje indicando que la silla está ocupada
            System.out.println("Silla ocupada");
            // Devolver false para indicar que la operación de agregar pasajero ha fallado
            return false;
        }
    }


    // Método para calcular y devolver la cantidad total de dinero recaudado por la venta de boletos
    public int leerDinero() {
        // Variable para acumular la cantidad total de dinero
        int acum = 0;
    
        // Iterar sobre las filas del avión
        for (int i = 0; i < sillas.length; i++) {
            // Iterar sobre las columnas de cada fila
            for (int j = 0; j < sillas[i].length; j++) {
                // Verificar si la silla está ocupada por un pasajero
                if (sillas[i][j] == null) {
                    // Si la silla está vacía, continuar con la siguiente iteración
                    continue;
                } else {
                    // Si la silla está ocupada, acumular el precio del tiquete del pasajero actual
                    acum += sillas[i][j].getPrecioTiquete();
                }
            }
        }
    
        // Devolver la cantidad total de dinero recaudado por la venta de boletos
        return acum;
    }


       // Método para imprimir la estructura del avión, representando las sillas ocupadas con "+" y las vacías con "-"
    public void imprimirEstructura() {
        // Iterar sobre las filas del avión
        for (int i = 0; i < sillas.length; i++) {
            // Iterar sobre las columnas de cada fila
            for (int j = 0; j < sillas[i].length; j++) {
                // Verificar si la silla está ocupada por un pasajero
                if (sillas[i][j] == null) {
                    // Si la silla está vacía, imprimir "-" para representarla
                    System.out.print("-");
                } else {
                    // Si la silla está ocupada, imprimir "+" para representarla
                    System.out.print("+");
                }
            }
            // Imprimir una nueva línea después de imprimir todas las columnas de la fila actual
            System.out.println();
        }
    }


    // Método para imprimir los nombres de los pasajeros en el avión
    public void imprimirNombres() {
        // Iterar sobre las filas del avión
        for (int i = 0; i < sillas.length; i++) {
            // Iterar sobre las columnas de cada fila
            for (int j = 0; j < sillas[i].length; j++) {
                // Verificar si la silla está ocupada por un pasajero
                if (sillas[i][j] == null) {
                    // Si la silla está vacía, continuar con la siguiente iteración
                    continue;
                } else {
                    // Si la silla está ocupada, imprimir el nombre del pasajero
                    System.out.println(sillas[i][j].getNombre());
                }
            }
        }
    }


    // Método para calcular y devolver la edad promedio de los pasajeros en el avión
    public int calcularEdadPromedio() {
        // Variables para contar la cantidad de pasajeros y acumular la suma de sus edades
        int cont = 0;
        int acum = 0;
    
        // Iterar sobre las filas del avión
        for (int i = 0; i < sillas.length; i++) {
            // Iterar sobre las columnas de cada fila
            for (int j = 0; j < sillas[i].length; j++) {
                // Verificar si la silla está ocupada por un pasajero
                if (sillas[i][j] == null) {
                    // Si la silla está vacía, continuar con la siguiente iteración
                    continue;
                } else {
                    // Si la silla está ocupada, acumular la edad del pasajero y aumentar el contador
                    acum += sillas[i][j].getEdad();
                    cont++;
                }
            }
        }
    
        // Calcular la edad promedio dividiendo la suma de edades por la cantidad de pasajeros
        int ans = acum / cont;
        // Devolver la edad promedio calculada
        return ans;
    }

}

