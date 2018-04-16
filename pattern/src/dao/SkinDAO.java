package dao;

import java.util.List;
import model.Skin;

public interface SkinDAO {
    void create(Skin s);
    List<Skin> read();
    void update(Skin s);
    void delete(String id);
    
    // Otros
    Skin getByID(String id);
    List<Skin> search(String exp);
}
