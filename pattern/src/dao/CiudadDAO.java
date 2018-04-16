package dao;

import java.util.List;
import model.Ciudad;

public interface CiudadDAO {
    void create(Ciudad c);
    List<Ciudad> read();
    void update(Ciudad c);
    void delete(int id);
    
    // Otros
    Ciudad getByID(int id);
    List<Ciudad> search(String exp);
}
