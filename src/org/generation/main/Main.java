package org.generation.main;

import org.generation.agenda.Agenda;
import org.generation.util.Contacto;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n**AGENDA TELEFÓNICA**");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Listar contactos");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Modificar teléfono");
            System.out.println("6. Ver espacio disponible");
            System.out.println("7. Salir");
            System.out.print("Selecciona una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1: // Añadir contacto (NUEVO)
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    agenda.añadirContacto(new Contacto(nombre, apellido, telefono));
                    break;
                case 2: // Buscar contacto
                    System.out.print("Nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    apellido = scanner.nextLine();
                    agenda.buscarContacto(nombre, apellido);
                    break;
                case 3: // Listar contactos
                    agenda.listarContactos();
                    break;
                case 4: // Eliminar contacto
                    System.out.print("Nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    apellido = scanner.nextLine();
                    agenda.eliminarContacto(new Contacto(nombre, apellido, ""));
                    break;
                case 5: // Modificar teléfono (NUEVO)
                    System.out.print("Nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    apellido = scanner.nextLine();
                    System.out.print("Nuevo teléfono: ");
                    telefono = scanner.nextLine();
                    agenda.modificarTelefono(nombre, apellido, telefono);
                    break;
                case 6: // Espacio disponible (NUEVO)
                    System.out.println("Espacios libres: " + agenda.espacioLibres());
                    break;
                case 7: // Salir
                    System.out.println("¡Adiós!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 7);

        scanner.close();
    }
}