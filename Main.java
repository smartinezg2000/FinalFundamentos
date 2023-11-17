import java.util.Scanner;

public class Main
{
    
    
    public static void main(String [] args){  
        //Creacion avion
        Avion avion = new Avion();
        
        
        
        //creacion menú e invocacion metodos
        Scanner input = new Scanner(System.in);
    
        
        String s="a";
        
        
        while(!s.equals("F")){
                System.out.println("A. Nombre del archivo con la estructura del avion.");
                System.out.println("B. Ingresar pasajero");
                System.out.println("C. Dinero recaudado hoy");
                System.out.println("D. Lista de pasajeros");
                System.out.println("E. Edad promedio de los pasajeros.");
                System.out.println("F. Termina programa.");
                System.out.println("G. Imprimir mapa del avion.");
                
               s = input.nextLine().toUpperCase();
            
            if(s.equals("A")){
                System.out.println("Escribe el nombre del archivo");
                String archivo = input.nextLine();
                System.out.print('\u000C');
                avion.leerEstructura(archivo);
                
                System.out.println();
            }
            else if(s.equals("B")){
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
                input.nextLine();
                
                
                Pasajero pasajero = new Pasajero( nombre,  precioTiquete,edad,  fila,  columna);
                System.out.print('\u000C');
                avion.agregarPasajero(pasajero);
                
                
                System.out.println();
            }
            else if(s.equals("C")){
                System.out.print('\u000C');
                System.out.println("El dinero recaudado es : " + avion.leerDinero());
                System.out.println();
            }
            else if(s.equals("D")){
                System.out.print('\u000C');
                avion.imprimirNombres();
                System.out.println();
            }
            else if(s.equals("E")){
                System.out.print('\u000C');
                System.out.println("La edad promedio de los pasajeros es: " + avion.calcularEdadPromedio());
                System.out.println();
            }
            else if(s.equals("G")){
                System.out.print('\u000C');
                avion.imprimirEstructura();
                System.out.println();
            }
            
        }
        System.out.println("Programa terminado.");
    }
}
