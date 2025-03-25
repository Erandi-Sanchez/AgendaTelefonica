package main;

import modelo.Contacto;
import servicio.Agenda;
import java.util.Scanner;

public class AgendaMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();
        int opcion;

        do {
            System.out.println("\nMenú de Agenda:");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Listar contactos");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Modificar teléfono");
            System.out.println("6. Ver espacio disponible");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    agenda.añadirContacto(new Contacto(nombre, apellido, telefono));
                    break;
                case 2:
                    System.out.print("Nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    apellido = scanner.nextLine();
                    agenda.buscaContacto(nombre, apellido);
                    break;
                case 3:
                    agenda.listarContactos();
                    break;
                case 4:
                    System.out.print("Nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    apellido = scanner.nextLine();
                    agenda.eliminarContacto(new Contacto(nombre, apellido, ""));
                    break;
                case 5:
                    System.out.print("Nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    apellido = scanner.nextLine();
                    System.out.print("Nuevo teléfono: ");
                    telefono = scanner.nextLine();
                    agenda.modificarTelefono(nombre, apellido, telefono);
                    break;
                case 6:
                    System.out.println("Espacios libres: " + agenda.espacioLibres());
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 7);

        scanner.close();
    }
}
