package modelo;

public class Contacto {
    private String nombre;
    private String apellido;
    private String telefono;

    public Contacto(String nombre, String apellido, String telefono) {
        if (nombre.isEmpty() || apellido.isEmpty()) {
            throw new IllegalArgumentException("El nombre y el apellido no pueden estar vacíos.");
        }
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contacto contacto = (Contacto) obj;
        return nombre.equalsIgnoreCase(contacto.nombre) && apellido.equalsIgnoreCase(contacto.apellido);
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " - " + telefono;
    }
}
