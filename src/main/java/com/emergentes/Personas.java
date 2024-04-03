/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes;

/**
 *
 * @author RUBEN
 */
public class Personas {
    private int id;
    private String nombre;
    private int primer_parcial;
    private int segundo_parcial;
    private int examen_final;

    public Personas() {
        this.id = 0;
        this.nombre = "";
        this.primer_parcial = 0;
        this.segundo_parcial = 0;
        this.examen_final = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrimer_parcial() {
        return primer_parcial;
    }

    public void setPrimer_parcial(int primer_parcial) {
        this.primer_parcial = primer_parcial;
    }

    public int getSegundo_parcial() {
        return segundo_parcial;
    }

    public void setSegundo_parcial(int segundo_parcial) {
        this.segundo_parcial = segundo_parcial;
    }

    public int getExamen_final() {
        return examen_final;
    }

    public void setExamen_final(int examen_final) {
        this.examen_final = examen_final;
    }
    
    
    
}
