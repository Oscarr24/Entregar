package co.edu.uniquindio.poo;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Veterinaria nuevaVeterinaria = new Veterinaria("UQ", "123");

        String menu = "SISTEMA VETERINARIA UQ\n\nSeleccione una opción:\n1. Agregar mascota\n2. Mostrar lista de mascotas\n3. Mostrar información de propietarios\n4. Modificar datos de una mascota\n5. Eliminar una mascota\n6. Salir";
        int opcion;

        do {
            String input = JOptionPane.showInputDialog(menu);

            // Verificar si el usuario hizo clic en cancelar
            if (input == null) {
                opcion = 6; // Salir si hace clic en cancelar
            } else {
                opcion = Integer.parseInt(input);
            }

            switch (opcion) {
                case 1:
                    // Solicitar datos del propietario
                    String nombrePropietario = JOptionPane.showInputDialog("Ingrese el nombre completo del propietario:");
                    String numeroPropietario = JOptionPane.showInputDialog("Ingrese el número de contacto del propietario:");
                    String direccionPropietario = JOptionPane.showInputDialog("Ingrese la dirección del propietario:");

                    // Crear objeto Persona con los datos del propietario
                    Persona nuevoPropietario = new Persona(nombrePropietario, numeroPropietario, direccionPropietario);

                    // Solicitar datos de la mascota
                    String nombreMascota = JOptionPane.showInputDialog("Ingrese el nombre de la mascota:");
                    String tipoMascota = JOptionPane.showInputDialog("Ingrese el tipo de mascota (Perro, Gato, etc.):");
                    String razaMascota = JOptionPane.showInputDialog("Ingrese la raza de la mascota:");

                    String edadInput = JOptionPane.showInputDialog("Ingrese la edad de la mascota:");
                    int edadMascota = Integer.parseInt(edadInput);

                    String idMascota = JOptionPane.showInputDialog("Ingrese el ID/código de la mascota:");

                    // Agregar la mascota con los datos ingresados
                    boolean respuestaCreacion = nuevaVeterinaria.agregarMascota(
                            nombreMascota,
                            tipoMascota,
                            razaMascota,
                            edadMascota,
                            idMascota,
                            nuevoPropietario
                    );

                    if (respuestaCreacion) {
                        JOptionPane.showMessageDialog(null, "Mascota agregada correctamente");

                        // Preguntar si desea cotizar la consulta
                        int respuestaCotizar = JOptionPane.showConfirmDialog(null,
                                "¿Desea cotizar el costo de consulta para esta mascota?",
                                "Cotizar Consulta",
                                JOptionPane.YES_NO_OPTION
                        );

                        if (respuestaCotizar == JOptionPane.YES_OPTION) {
                            String costoBaseInput = JOptionPane.showInputDialog("Ingrese el costo base de la consulta:");
                            double costoBase = Double.parseDouble(costoBaseInput);

                            // Obtener la mascota recién agregada
                            Mascota mascota = nuevaVeterinaria.obtenerMascota(nombreMascota);

                            if (mascota != null) {
                                // Calcular el costo de la consulta
                                double costoTotal = Veterinaria.calcularCostoConsulta(mascota, costoBase);

                                JOptionPane.showMessageDialog(null,
                                        "COTIZACIÓN DE CONSULTA\n\n" +
                                                "Mascota: " + mascota.getNombre() + "\n" +
                                                "Especie: " + mascota.getEspecie() + "\n" +
                                                "Raza: " + mascota.getRaza() + "\n" +
                                                "Edad: " + mascota.getEdad() + " años\n" +
                                                "Propietario: " + mascota.getPropietario().getNombre() + "\n" +
                                                "Número de contacto: " + mascota.getPropietario().getNumero() + "\n" +
                                                "Dirección: " + mascota.getPropietario().getDireccion() + "\n" +
                                                "Costo base: $" + costoBase + "\n" +
                                                "Costo total: $" + costoTotal + "\n\n" +
                                                "Desglose:\n" +
                                                "- Costo base: $" + costoBase + "\n" +
                                                (mascota.getEspecie().equals("Perro") ? "- Recargo por perro: $15\n" :
                                                        mascota.getEspecie().equals("Gato") ? "- Recargo por gato: $10\n" : "") +
                                                (mascota.getEdad() > 10 ? "- Recargo por edad (>10 años): $20\n" : "")
                                );
                            } else {
                                JOptionPane.showMessageDialog(null, "Error: No se pudo encontrar la mascota para calcular el costo.");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: No se pudo agregar la mascota");
                    }
                    break;

                case 2:
                    // Mostrar lista de mascotas con información de propietarios
                    Mascota[] mascotas = nuevaVeterinaria.getListMascotas();
                    StringBuilder lista = new StringBuilder("LISTA DE MASCOTAS:\n\n");
                    for (Mascota mascota : mascotas) {
                        if (mascota != null) {
                            lista.append("MASCOTA:\n")
                                    .append("Nombre: ").append(mascota.getNombre()).append("\n")
                                    .append("Especie: ").append(mascota.getEspecie()).append("\n")
                                    .append("Raza: ").append(mascota.getRaza()).append("\n")
                                    .append("Edad: ").append(mascota.getEdad()).append(" años\n")
                                    .append("ID: ").append(mascota.getIdentififacion()).append("\n")
                                    .append("PROPIETARIO:\n")
                                    .append("Nombre: ").append(mascota.getPropietario().getNombre()).append("\n")
                                    .append("Número: ").append(mascota.getPropietario().getNumero()).append("\n")
                                    .append("Dirección: ").append(mascota.getPropietario().getDireccion()).append("\n")
                                    .append("----------------------------------------\n");
                        }
                    }
                    JOptionPane.showMessageDialog(null, lista.toString());
                    break;

                case 3:
                    // Mostrar solo información de propietarios
                    Mascota[] mascotasInfo = nuevaVeterinaria.getListMascotas();
                    StringBuilder infoPropietarios = new StringBuilder("INFORMACIÓN DE PROPIETARIOS:\n\n");

                    for (Mascota mascota : mascotasInfo) {
                        if (mascota != null) {
                            Persona propietario = mascota.getPropietario();
                            infoPropietarios.append("Propietario: ").append(propietario.getNombre()).append("\n")
                                    .append("Número: ").append(propietario.getNumero()).append("\n")
                                    .append("Dirección: ").append(propietario.getDireccion()).append("\n")
                                    .append("Mascota a cargo: ").append(mascota.getNombre()).append(" (").append(mascota.getEspecie()).append(")\n")
                                    .append("----------------------------------------\n");
                        }
                    }
                    JOptionPane.showMessageDialog(null, infoPropietarios.toString());
                    break;

                case 4:
                    // Modificar datos de una mascota
                    String nombreModificar = JOptionPane.showInputDialog("Ingrese el nombre de la mascota que desea modificar:");
                    Mascota mascotaModificar = nuevaVeterinaria.obtenerMascota(nombreModificar);

                    if (mascotaModificar != null) {
                        String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre de la mascota:", mascotaModificar.getNombre());
                        String nuevoTipo = JOptionPane.showInputDialog("Ingrese el nuevo tipo de mascota (Perro, Gato, etc.):", mascotaModificar.getEspecie());
                        String nuevaRaza = JOptionPane.showInputDialog("Ingrese la nueva raza de la mascota:", mascotaModificar.getRaza());
                        String nuevaEdadInput = JOptionPane.showInputDialog("Ingrese la nueva edad de la mascota:", mascotaModificar.getEdad());
                        int nuevaEdad = Integer.parseInt(nuevaEdadInput);
                        String nuevoID = JOptionPane.showInputDialog("Ingrese el nuevo ID/código de la mascota:", mascotaModificar.getIdentififacion());

                        // Actualizar los datos de la mascota
                        boolean respuestaActualizacion = nuevaVeterinaria.actualizarMascota(
                                nombreModificar,
                                nuevoTipo,
                                nuevaRaza,
                                nuevaEdad,
                                nuevoID,
                                mascotaModificar.getPropietario() // Mantener el mismo propietario
                        );

                        if (respuestaActualizacion) {
                            JOptionPane.showMessageDialog(null, "Datos de la mascota actualizados correctamente.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Error: No se pudo actualizar los datos de la mascota.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: No se encontró la mascota con ese nombre.");
                    }
                    break;

                case 5:
                    // Eliminar una mascota
                    String nombreEliminar = JOptionPane.showInputDialog("Ingrese el nombre de la mascota que desea eliminar:");
                    boolean respuestaEliminacion = nuevaVeterinaria.eliminarMascota(nombreEliminar);

                    if (respuestaEliminacion) {
                        JOptionPane.showMessageDialog(null, "Mascota eliminada correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: No se encontró la mascota con ese nombre.");
                    }
                    break;

                case 6:
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema. ¡Hasta pronto!");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor seleccione 1, 2, 3, 4, 5 o 6.");
            }
        } while (opcion != 6);
    }
}








