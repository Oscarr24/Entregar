package co.edu.uniquindio.poo;
import java.util.Scanner;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Veterinaria nuevaVeterinaria = new Veterinaria("UQ", "123");

        boolean respuestaCreacion = nuevaVeterinaria.agregarMascota("Oscar", "Perro",
                "Husky", "12", "1113618192", "Oscar","123123");

        JOptionPane.showMessageDialog(null, nuevaVeterinaria.getListMascotas());

        if (respuestaCreacion) {
            JOptionPane.showMessageDialog(null, "Empleado agregado correctamente");
        }else{
            JOptionPane.showMessageDialog(null, "Empleado no agregado");
        }

        boolean respuestaCreacion2 = nuevaVeterinaria.agregarMascota("Oscar", "Perro",
                "Husky", "12", "1113618192", "Oscar","123123");


        if (respuestaCreacion2) {
            JOptionPane.showMessageDialog(null, "Empleado agregado correctamente");
        }else{
            JOptionPane.showMessageDialog(null, "Empleado no agregado");
        }
    }
}