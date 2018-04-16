package dao;

import java.util.List;
import model.Arma;

public interface ArmaDAO{
    void create(Arma a);
    List<Arma> read();
    void update(Arma a);
    void delete(int id);
    
    // Otros
    Arma getByID(int id);
    List<Arma> search(String exp);
}
