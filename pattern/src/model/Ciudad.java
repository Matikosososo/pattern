package model;

public class Ciudad {
    private int id;
    private String nombre;

    public Ciudad(String nombre) {
        this.nombre = nombre;
    }

    public Ciudad() {
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

    @Override
    public String toString() {
        return "ID: "+ id+" - Nombre: "+nombre;
    }
    
    
}
