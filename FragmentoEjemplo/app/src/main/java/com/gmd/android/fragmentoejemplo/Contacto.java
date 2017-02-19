package com.gmd.android.fragmentoejemplo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pjohnson on 18/02/17.
 */

public class Contacto implements Serializable {
    private String nombre;
    private String apellido;
    private String numero;
    private String fechaNacimiento;

    public Contacto(String nombre, String apellido, String numero, String fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numero = numero;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public static List<Contacto> obtenerContactos() {
        List<Contacto> lista = new ArrayList<>();
        Contacto contacto1 = new Contacto("Maria", "Soliz", "3452343", "10/12/1990");
        Contacto contacto2 = new Contacto("Pedro", "Soliz", "2342552", "10/12/1990");
        Contacto contacto3 = new Contacto("Juana", "Soliz", "2341231", "10/12/1990");
        Contacto contacto4 = new Contacto("Yanina", "Soliz", "2342345", "10/12/1990");
        Contacto contacto5 = new Contacto("Diego", "Soliz", "2342342", "10/12/1990");
        Contacto contacto6 = new Contacto("Eduardo", "Soliz", "2342342", "10/12/1990");
        Contacto contacto7 = new Contacto("Carlos", "Soliz", "2342342", "10/12/1990");
        Contacto contacto8 = new Contacto("Gladys", "Soliz", "6786786", "10/12/1990");
        Contacto contacto9 = new Contacto("Sergio", "Soliz", "5675675", "10/12/1990");
        Contacto contacto10 = new Contacto("Alberto", "Soliz", "57567565", "10/12/1990");
        Contacto contacto11 = new Contacto("Amy", "Soliz", "5675675", "10/12/1990");
        Contacto contacto12 = new Contacto("Cinthya", "Soliz", "5675675", "10/12/1990");
        Contacto contacto13 = new Contacto("Yaco", "Soliz", "5675675", "10/12/1990");

        lista.add(contacto1);
        lista.add(contacto2);
        lista.add(contacto3);
        lista.add(contacto4);
        lista.add(contacto5);
        lista.add(contacto6);
        lista.add(contacto7);
        lista.add(contacto8);
        lista.add(contacto9);
        lista.add(contacto10);
        lista.add(contacto11);
        lista.add(contacto12);
        lista.add(contacto13);

        return lista;
    }

}
