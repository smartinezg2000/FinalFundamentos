import java.util.Scanner;

public class Main
{
    
    
    public static void main(String [] args){   //Creacion avion
        Avion avion = new Avion();
        
        
        
        //creacion menú e invocacion metodos
        Scanner input = new Scanner(System.in);
        System.out.println("A. Nombre del archivo con la estructura del avion.");
        System.out.println("B. Nombre del pasajero, fila, y columna, precio del tiquete y tal vez edad");
        System.out.println("C. Dinero recaudado hoy");
        System.out.println("D. Lista de pasajeros");
        System.out.println("E. Edad promedio de los pasajeros(elegir un nuevo atributo o dejar ese si maria quiere)");
        System.out.println("F. Termina programa.");
        String s = input.nextLine();
        s = s.toUpperCase();
        while(s!="F"){
        
            if(s.equals("A")){
                System.out.println("Escribe el nombre del archivo");
                avion.leerEstructura(input.nextLine());
                
                
            }
            else if(s.equals("B")){
                System.out.println("Escribe el nombre del pasajero");
                String nombre = input.nextLine();
                
                System.out.println("Escribe el precio en enteros");
                int precioTiquete = input.nextInt();
                
                System.out.println("la fila");
                int fila = input.nextInt();
                
                System.out.println("la columna");
                int columna = input.nextInt();
                
                Pasajero pasajero = new Pasajero( nombre,  precioTiquete,  fila,  columna);
                avion.agregarPasajero(pasajero);
                
                
                
            }
            else if(s.equals("C")){
                System.out.println("El dinero recaudado es : " + avion.leerDinero());
                
            }
            else if(s.equals("D")){
                
            }
            else if(s.equals("E")){
                
            }
            
        }
        System.out.println("Programa terminado.");
    }
}
