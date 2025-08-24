package co.edu.uniquindio.poo;

public class Mascota {
    private String nombre;
    private String especia;
    private String raza;
    private String edad;
    private String identififacion;
    private String propietario;
    private String contacto;

    public Mascota(String nombre, String especia, String raza, String edad, String identififacion, String propietario, String contacto) {
        this.nombre = nombre;
        this.especia = especia;
        this.raza = raza;
        this.edad = edad;
        this.identififacion = identififacion;
        this.propietario = propietario;
        this.contacto = contacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecia() {
        return especia;
    }

    public void setEspecia(String especia) {
        this.especia = especia;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getIdentififacion() {
        return identififacion;
    }

    public void setIdentififacion(String identififacion) {
        this.identififacion = identififacion;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "nombre='" + nombre + '\'' +
                ", especie='" + especia + '\'' +
                ", raza='" + raza + '\'' +
                ", edad='" + edad + '\'' +
                ", identificacion='" + identififacion + '\'' +
                ", propietario='" + propietario + '\'' +
                ", contacto='" + contacto + '\'' +
                '}';
    }
}

