package model;

public class Skin {
    private int id;
    private String nombre;

    public Skin(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Skin() {
    }

    public Skin(String nombre) {
        this.nombre = nombre;
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
    
    
}
