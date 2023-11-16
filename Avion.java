
/**
 * Write a description of class Avion here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Avion
{
    Pasajero [][] sillas;
    int numFilas;

    public void leerEstructura(String nombreArchivo) {
        try {
            Scanner sc = new Scanner(new File(nombreArchivo));
            // leer el número total de filas
            this.numFilas = sc.nextInt();
            // leer el número de clase
            int numClases = sc.nextInt();
            sillas = new Pasajero[numFilas][];
            int fila = 0;
            for(int clase = 0; clase < numClases; clase++) {
                // número de filas y número de sillas
                int numFilasClase = sc.nextInt();
                int numSillasClase = sc.nextInt();
                for(int i = 0; i < numFilasClase; i++) {
                    Pasajero [] filaDeSillas = new Pasajero[numSillasClase];
                    sillas[fila] = filaDeSillas;
                    fila++;
                }
            }
            System.out.println("Estructura creada, filas: " + fila);
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no existe: " + nombreArchivo);
        }
    }

    public boolean agregarPasajero(Pasajero pasajero) {
        if(pasajero.getFila() < 0 || pasajero.getFila() >= numFilas) {
            System.out.println("Fila es inválida");
            return false;
        }
        if(pasajero.getColumna() < 0 || pasajero.getColumna() >= sillas[pasajero.getFila()].length) {
            System.out.println("Columna inválida");
            return false;
        }
        if(sillas[pasajero.getFila()][pasajero.getColumna()] == null) {
            sillas[pasajero.getFila()][pasajero.getColumna()] = pasajero;
            System.out.println("Pasajero " + pasajero.getNombre() + " asignado");
            return true;
        } else {
            System.out.println("Silla ocupada");
            return false;
        }

    }
    public int leerDinero(){
        int acum = 0;
        for(int i =0; i<sillas.length;i++){
            for(int j = 0; j<sillas[i].length;j++){
                if(sillas[i][j]==null) continue;
                else{
                acum+=sillas[i][j].getPrecioTiquete();
                }
            }
        }
        return acum;
    }


}
