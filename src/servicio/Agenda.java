package servicio;

import modelo.Contacto;
import java.util.*;

public class Agenda {
    private List<Contacto> contactos;
    private int maxContactos;

    public Agenda(int maxContactos) {
        this.maxContactos = maxContactos;
        this.contactos = new ArrayList<>();
    }

    public Agenda() {
        this(10);
    }

    public boolean añadirContacto(Contacto contacto) {
        if (contactos.size() >= maxContactos) {
            System.out.println("La agenda está llena.");
            return false;
        }
        if (contactos.contains(contacto)) {
            System.out.println("El contacto ya existe.");
            return false;
        }
        contactos.add(contacto);
        System.out.println("Contacto añadido.");
        return true;
    }

    public boolean existeContacto(Contacto contacto) {
        return contactos.contains(contacto);
    }

    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
        } else {
            contactos.sort(Comparator.comparing(Contacto::getNombre).thenComparing(Contacto::getApellido));
            for (Contacto c : contactos) {
                System.out.println(c);
            }
        }
    }

    public void buscaContacto(String nombre, String apellido) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre) && contacto.getApellido().equalsIgnoreCase(apellido)) {
                System.out.println("Teléfono: " + contacto.getTelefono());
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

    public boolean eliminarContacto(Contacto contacto) {
        if (contactos.remove(contacto)) {
            System.out.println("Contacto eliminado.");
            return true;
        } else {
            System.out.println("El contacto no existe.");
            return false;
        }
    }

    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre) && contacto.getApellido().equalsIgnoreCase(apellido)) {
                contacto.setTelefono(nuevoTelefono);
                System.out.println("Teléfono actualizado.");
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

    public boolean agendaLlena() {
        return contactos.size() >= maxContactos;
    }

    public int espacioLibres() {
        return maxContactos - contactos.size();
    }
}
