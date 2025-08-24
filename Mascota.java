package co.edu.uniquindio.poo;


public class Mascota {
    private String nombre;
    private String especie;
    private String raza;
    private int edad;
    private String identififacion;
    private Persona propietario;

    public Mascota(String nombre, String especie, String raza, int  edad, String identififacion,Persona propietario) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.identififacion = identififacion;
        this.propietario = propietario;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getIdentififacion() {
        return identififacion;
    }

    public void setIdentififacion(String identififacion) {
        this.identififacion = identififacion;
    }

    public Persona getPropietario() {
        return propietario;
    }

    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "nombre='" + nombre + '\'' +
                ", tipoAnimal='" + especie + '\'' +
                ", raza='" + raza + '\'' +
                ", edad=" + edad +
                ", codigo='" + identififacion + '\'' +
                ", propietario=" + (propietario != null ? propietario.getNombre() : "N/A") +
                '}';
    }
}
