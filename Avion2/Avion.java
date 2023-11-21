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
        if (pasajero.getFila() < 0 || pasajero.getFila() >= numFilas) {
            System.out.println("Fila es inválida");
            return false;
        }
        if (pasajero.getColumna() < 0 || pasajero.getColumna() >= sillas[pasajero.getFila()].length) {
            System.out.println("Columna inválida");
            return false;
        }
        if (sillas[pasajero.getFila()][pasajero.getColumna()] == null) {
            sillas[pasajero.getFila()][pasajero.getColumna()] = pasajero;
            System.out.println("Pasajero " + pasajero.getNombre() + " asignado");
            return true;
        } else {
            System.out.println("Silla ocupada");
            return false;
        }
    }

    // Método para calcular y devolver la cantidad total de dinero recaudado por la venta de boletos
    public int leerDinero() {
        int acum = 0;
        for (int i = 0; i < sillas.length; i++) {
            for (int j = 0; j < sillas[i].length; j++) {
                if (sillas[i][j] == null) continue;
                else {
                    acum += sillas[i][j].getPrecioTiquete();
                }
            }
        }
        return acum;
    }

    // Método para imprimir la estructura del avión, representando las sillas ocupadas con "+" y las vacías con "-"
    public void imprimirEstructura() {
        for (int i = 0; i < sillas.length; i++) {
            for (int j = 0; j < sillas[i].length; j++) {
                if (sillas[i][j] == null) System.out.print("-");
                else System.out.print("+");
            }
            System.out.println();
        }
    }

    // Método para imprimir los nombres de los pasajeros en el avión
    public void imprimirNombres() {
        for (int i = 0; i < sillas.length; i++) {
            for (int j = 0; j < sillas[i].length; j++) {
                if (sillas[i][j] == null) continue;
                else System.out.println(sillas[i][j].getNombre());
            }
        }
    }

    // Método para calcular y devolver la edad promedio de los pasajeros en el avión
    public int calcularEdadPromedio() {
        int cont = 0;
        int acum = 0;

        for (int i = 0; i < sillas.length; i++) {
            for (int j = 0; j < sillas[i].length; j++) {
                if (sillas[i][j] == null) continue;
                else {
                    acum += sillas[i][j].getEdad();
                    cont++;
                }
            }
        }

        int ans = acum / cont;
        return ans;
    }
}

