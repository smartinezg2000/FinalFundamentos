
public class Pasajero
{
    //la fila y columna son atributos ya que en la matriz que representa el avion vamos a introducir el objeto Pasajero, no string. desde ese mismo objeto usamos getters para conseguir los datos necesarios
    private String nombre;
    private int precioTiquete;
    private int fila;
    private int columna;
    private int edad;

    public Pasajero(String nombre, int precioTiquete,int edad, int fila, int columna)
    {
        this.nombre=nombre;
        this.precioTiquete=precioTiquete;
        this.columna = columna;
        this.fila = fila;
        this.edad = edad;
        
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public int getPrecioTiquete(){
        return precioTiquete;
    }
    
     public void setPrecioTiquete(int precioTiquete){
        this.precioTiquete=precioTiquete;
    }   
    public int getColumna(){
        return columna;
    }

    public int getFila(){
        return fila;
    }
    public int getEdad(){
        return edad;
    }
    
}
