package org.generation.agenda;

import org.generation.util.Contacto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Agenda {
    private List<Contacto> contactos;
    private int capacidadMaxima;

    // Constructores
    public Agenda(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.contactos = new ArrayList<>();
    }

    public Agenda() {
        this(10); // Capacidad por defecto: 10 contactos
    }

    // ===== MÉTODOS NUEVOS =====
    public void añadirContacto(Contacto nuevo) {
        // Validar campos vacíos
        if (nuevo.getNombre().isEmpty() || nuevo.getApellido().isEmpty()) {
            System.out.println("Error: Nombre y apellido no pueden estar vacíos");
            return;
        }

        // Validar duplicados
        if (existeContacto(nuevo)) {
            System.out.println("El contacto ya existe");
            return;
        }

        // Validar espacio
        if (agendaLlena()) {
            System.out.println("🔴 Agenda llena. No se pueden añadir más contactos");
            return;
        }

        contactos.add(nuevo);
        System.out.println("✅ Contacto añadido correctamente");
    }

    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        Contacto buscado = new Contacto(nombre, apellido, "");
        for (Contacto contacto : contactos) {
            if (contacto.esIgual(buscado)) {
                contacto.setTelefono(nuevoTelefono);
                System.out.println("✅ Teléfono actualizado");
                return;
            }
        }
        System.out.println("Contacto no encontrado");
    }

    public int espacioLibres() {
        return capacidadMaxima - contactos.size();
    }

    // ===== MÉTODOS EXISTENTES (mejorados) =====
    private boolean existeContacto(Contacto c) {
        return contactos.stream().anyMatch(contacto -> contacto.esIgual(c));
    }

    private boolean agendaLlena() {
        return contactos.size() >= capacidadMaxima;
    }

    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("📭 La agenda está vacía");
            return;
        }

        Collections.sort(contactos, Comparator
                .comparing(Contacto::getNombre, String.CASE_INSENSITIVE_ORDER)
                .thenComparing(Contacto::getApellido, String.CASE_INSENSITIVE_ORDER));

        System.out.println("** Lista de contactos **");
        contactos.forEach(System.out::println);
    }

    public void buscarContacto(String nombre, String apellido) {
        Contacto buscado = new Contacto(nombre, apellido, "");
        contactos.stream()
                .filter(c -> c.esIgual(buscado))
                .findFirst()
                .ifPresentOrElse(
                        c -> System.out.println("Teléfono: " + c.getTelefono()),
                        () -> System.out.println("❌ Contacto no encontrado")
                );
    }

    public void eliminarContacto(Contacto contactoEliminar) {
        if (contactos.removeIf(c -> c.esIgual(contactoEliminar))) {
            System.out.println("🗑️ Contacto eliminado");
        } else {
            System.out.println("El contacto no existe");
        }
    }
}