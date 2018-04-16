package model;

public class Arma {
    private int id;
    private String nombre;
    private int municion;

    public Arma(int id, String nombre, int municion) {
        this.id = id;
        this.nombre = nombre;
        this.municion = municion;
    }

    public Arma() {
    }

    public Arma(int id, int municion) {
        this.id = id;
        this.municion = municion;
    }
    
    
    
    public Arma(String nombre, int municion) {
        this.nombre = nombre;
        this.municion = municion;
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

    public int getMunicion() {
        return municion;
    }

    public void setMunicion(int municion) {
        this.municion = municion;
    }

    @Override
    public String toString() {
        return "ID: "+ id+" - Nombre: "+nombre+" - Munición: "+municion;
    }
    
    
}
