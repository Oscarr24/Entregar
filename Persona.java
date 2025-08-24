package co.edu.uniquindio.poo;

public class Persona {
    private String nombre;
    private String numero;
    private String direccion;


    public Persona(String nombre,String numero,String direccion ) {
        this.nombre = nombre;
        this.numero = numero;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", numero='" + numero + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }


}


