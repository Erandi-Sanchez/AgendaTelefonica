package org.generation.util;

/**
 * Clase que representa un contacto en la agenda telefónica.
 * Implementa comparación por nombre/apellido (ignorando mayúsculas)
 * y formato de impresión especial.
 */
public class Contacto {
    private String nombre;
    private String apellido;
    private String telefono;

    // Constructor
    public Contacto(String nombre, String apellido, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    // Métodos de comparación
    public boolean esIgual(Contacto otro) {
        if (otro == null) return false;
        return this.nombre.equalsIgnoreCase(otro.nombre)
                && this.apellido.equalsIgnoreCase(otro.apellido);
    }

    // Representación textual del contacto
    @Override
    public String toString() {
        return String.format("%s %s - %s", nombre, apellido, telefono);
    }

    // ===== Getters & Setters =====
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}