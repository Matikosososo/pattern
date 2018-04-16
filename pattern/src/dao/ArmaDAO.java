package dao;

import java.util.List;
import model.Arma;

public interface ArmaDAO{
    void create(Arma a);
    List<Arma> read();
    void update(Arma a);
    void delete(String id);
    
    // Otros
    Arma getByID(String id);
    List<Arma> search(String exp);
}
