package co.edu.uniquindio.poo;

public class Veterinaria {
    private String nombre;
    private String nit;

    private Mascota[] listMascotas;

    public Veterinaria(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
        listMascotas = new Mascota[10];
    }

    @Override
    public String toString() {
        return "Veterinaria{" + "nombre=" + nombre + ", nit=" + nit + '}';
    }

    public boolean agregarMascota(String nombre, String especie, String raza,String edad, String identificacion, String propietario, String Contacto) {
        Mascota newEmpleado = new Mascota(nombre, especie,raza,edad,identificacion,propietario,Contacto);

        for (int i = 0; i < listMascotas.length; i++) {
            if (listMascotas[i] !=null && listMascotas[i].getNombre().equals(nombre)) {
                return false;
            }
        }
        for (int i = 0; i < listMascotas.length; i++) {
            if (listMascotas[i] == null){
                listMascotas[i] = newEmpleado;
                return true;
            }
        }
        return false;

    }

    private int obtenerPosicionesmascota(String numIdentificacion) {
        for (int i = 0; i < listMascotas.length; i++) {
            if(listMascotas[i].getNombre().equals(nombre)){
                return i;
            }
        }
        return -1;
    }
    public boolean eliminarEmpleado(String nombre) {
        int indexMascota = obtenerPosicionesmascota(nombre);

        if (indexMascota == -1) return false;

        listMascotas[indexMascota] = null;
        return true;
    }

    public boolean actualizarEmpleado(String nombre, String especie, String raza,String edad, String identificacion, String propietario, String contacto) {
        int indexMascota = obtenerPosicionesmascota(nombre);

        if (indexMascota == -1) return false;

        Mascota actualizarMascota = listMascotas[indexMascota];

        actualizarMascota.setNombre(nombre);
        actualizarMascota.setEspecia(especie);
        actualizarMascota.setRaza(raza);
        actualizarMascota.setEdad(edad);
        actualizarMascota.setIdentififacion(identificacion);
        actualizarMascota.setPropietario(propietario);
        actualizarMascota.setContacto(contacto);

        return true;

    }

    public Mascota obtenerMascota(String nombre) {
        int indexMascota = obtenerPosicionesmascota(nombre);
        if (indexMascota == -1) return null;

        return listMascotas[indexMascota];
    }

    public Mascota[] getListMascotas() {
        return listMascotas;
    }

    public void setListMascotas(Mascota[] listMascotas) {
        this.listMascotas = listMascotas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
}
