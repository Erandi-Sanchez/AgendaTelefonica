package org.genetation.util;
import java.util.ArrayList; //ArrayList: Lista dinámica, almacenar los contactos.
import java.util.Collections; //Collections: Proporciona métodos estáticos
import java.util.List; //List: Interfaz que define las operaciones básicas de una lista



public class Agenda {
    //Atributos de la clase
    private List<Contacto> contactos; //Lista contactos que almacena objetos de tipo contacto
    private int tamanoMax; //Tamño máximo de la lista

    //Metodo constructor de tamaño
    public Agenda (int tamanoMax){
        this.contactos = new ArrayList<>(); //Inicializa la lista como una nueva instancia de Arraylist
        this.tamanoMax = tamanoMax; //Asigna el valor del parametro al atributo
    }
    //Llamado al metodo constructor (se puede cambiar el tamaño)
    public Agenda(){
        this(10);
    }

    



}
