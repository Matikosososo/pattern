package dao;

import java.util.List;
import model.Ciudad;

public interface CiudadDAO {
    void create(Ciudad c);
    List<Ciudad> read();
    void update(Ciudad c);
    void delete(String id);
    
    // Otros
    Ciudad getByID(String id);
    List<Ciudad> search(String exp);
}
