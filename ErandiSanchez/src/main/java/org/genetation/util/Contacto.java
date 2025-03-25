package org.genetation.util;
//1. Definimos la clase contacto, declarados con private para encapsularlos y que sólo se puedan acceder por medio de métdos (getter y setter).

//Atributos privados
public class Contacto {
    private String nombre;
    private String apellido;
    private String telefono;

    //Metodo constructor (inicializar un nuevo objeto con atributos especificos)

    public Contacto (String nombre, String apellido, String telefono){
        //Asignar valores para los contactos a crear
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;

    }
    // Getters y Setters
        // Obtener el valor
        public String getNombre() {
            return nombre;
        }

        //Modificar el valor del atributo
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        // Metodo para comparar contactos por nombre y apellido (ignorando mayúsculas/minúsculas)
        public boolean esIgual(Contacto otro) {
        //si otro (objeto de la misma clase con diferentes parametros) es diferente =  falso
        if (otro == null) return false;
        //si no es null compara nombre y apellido
        return this.nombre.equalsIgnoreCase(otro.getNombre()) &&
                    this.apellido.equalsIgnoreCase(otro.getApellido());
        }

        @Override
        //Remplazar el metodo to String que usamos por defecto en la clase Contacto, por una version que nosotros definimos
        public String toString() {
            return nombre + " " + apellido + " - " + telefono;
        }
    }


