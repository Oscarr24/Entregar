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

    public static double  calcularCostoConsulta(Mascota mascota, double  costoBase){
        double  costoTotal = costoBase;

        if (mascota.getEspecie().equals("Perro")) {
            costoTotal += 15;
        } else if (mascota.getEspecie().equals("Gato")) {
            costoTotal += 10;
        }

        if (mascota.getEdad() > 10) {
            costoTotal += 20;
        }

        return costoTotal;
    }

    public boolean agregarMascota(String nombre, String especie, String raza,int edad, String identificacion,Persona propietario) {
        Mascota newMascota = new Mascota(nombre, especie,raza,edad,identificacion,propietario);

        for (int i = 0; i < listMascotas.length; i++) {
            if (listMascotas[i] !=null && listMascotas[i].getNombre().equals(nombre)) {
                return false;
            }
        }
        for (int i = 0; i < listMascotas.length; i++) {
            if (listMascotas[i] == null){
                listMascotas[i] = newMascota;
                return true;
            }
        }
        return false;

    }

    private int obtenerPosicionMascota(String nombre){
        for(int i = 0; i < listMascotas.length; i++){
            if(listMascotas[i] != null &&
                    listMascotas[i].getNombre().equals(nombre)){
                return i;
            }
        }
        return -1;
    }
    public boolean eliminarMascota(String nombre) {
        int indexMascota = obtenerPosicionMascota(nombre);

        if (indexMascota == -1) return false;

        listMascotas[indexMascota] = null;
        return true;
    }

    public boolean actualizarMascota(String nombre, String especie, String raza,int edad, String identificacion, Persona propietario) {
        int indexMascota = obtenerPosicionMascota(nombre);

        if (indexMascota == -1) return false;

        Mascota actualizarMascota = listMascotas[indexMascota];

        actualizarMascota.setNombre(nombre);
        actualizarMascota.setEspecie(especie);
        actualizarMascota.setRaza(raza);
        actualizarMascota.setEdad(edad);
        actualizarMascota.setIdentififacion(identificacion);
        actualizarMascota.setPropietario(propietario);

        return true;

    }

    public Mascota obtenerMascota(String nombre) {
        int indexMascota = obtenerPosicionMascota(nombre);
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
