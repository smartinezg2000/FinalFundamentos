public class Pasajero {
    // Atributos de la clase Pasajero que representan la información del pasajero
    // y su ubicación en el avión.
    private String nombre;
    private int precioTiquete;
    private int fila;
    private int columna;
    private int edad;

    // Constructor de la clase Pasajero para inicializar sus atributos al crear un nuevo objeto Pasajero.
    public Pasajero(String nombre, int precioTiquete, int edad, int fila, int columna) {
        this.nombre = nombre;
        this.precioTiquete = precioTiquete;
        this.edad = edad;
        this.fila = fila;
        this.columna = columna;
    }

    // Método getter para obtener el nombre del pasajero.
    public String getNombre() {
        return nombre;
    }

    // Método setter para establecer el nombre del pasajero.
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método getter para obtener el precio del tiquete del pasajero.
    public int getPrecioTiquete() {
        return precioTiquete;
    }

    // Método setter para establecer el precio del tiquete del pasajero.
    public void setPrecioTiquete(int precioTiquete) {
        this.precioTiquete = precioTiquete;
    }

    // Método getter para obtener la columna en la que se encuentra el pasajero en el avión.
    public int getColumna() {
        return columna;
    }

    // Método getter para obtener la fila en la que se encuentra el pasajero en el avión.
    public int getFila() {
        return fila;
    }

    // Método getter para obtener la edad del pasajero.
    public int getEdad() {
        return edad;
    }
}

