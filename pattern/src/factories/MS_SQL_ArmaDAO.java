package factories;

import dao.ArmaDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Arma;

public class MS_SQL_ArmaDAO implements ArmaDAO {

    private ResultSet tablaVirtual;
    private List<Arma> listArma;
    MS_SQL_ConexionDAO c;

    public MS_SQL_ArmaDAO() throws ClassNotFoundException {
        c = new MS_SQL_ConexionDAO("RA52PCALU-31522", "sa", "123456", "muestra_db");//Cambiar Server en otro pc
    }

    @Override
    public void create(Arma a) {
        String query = "insert into arma values('" + a.getNombre() + "', " + a.getMunicion() + ")";
        c.ejecutar(query);
    }

    @Override
    public List<Arma> read() {
        String query = "Select * from arma";
        Arma a;
        listArma = new ArrayList<>();
        tablaVirtual = c.ejecutarSelect(query);
        try {
            while (tablaVirtual.next()) {
                a = new Arma();

                a.setId(tablaVirtual.getInt(1));
                a.setNombre(tablaVirtual.getString(2));
                a.setMunicion(tablaVirtual.getInt(3));
                listArma.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQL_ArmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        c.desconectar();
        return listArma;
    }

    @Override
    public void update(Arma a) {
        String query = "UPDATE arma set municion = " + a.getMunicion() + " where id =" + a.getId();
        c.ejecutar(query);
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM arma where id = " + id;
        c.ejecutar(query);
    }

    @Override
    public Arma getByID(int id) {
        String query = "Select * from arma where id = " + id;
        Arma a;
        listArma = new ArrayList<>();
        tablaVirtual = c.ejecutarSelect(query);
        try {
            if (tablaVirtual.next()) {
                a = new Arma();

                a.setId(tablaVirtual.getInt(1));
                a.setNombre(tablaVirtual.getString(2));
                a.setMunicion(tablaVirtual.getInt(3));
                listArma.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQL_ArmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        c.desconectar();
        return listArma.get(0);
    }

    @Override
    public List<Arma> search(String exp) {
        String query = "Select * from arma where nombre LIKE '%" + exp + "%'";
        Arma a;
        listArma = new ArrayList<>();
        tablaVirtual = c.ejecutarSelect(query);
        try {
            while (tablaVirtual.next()) {
                a = new Arma();

                a.setId(tablaVirtual.getInt(1));
                a.setNombre(tablaVirtual.getString(2));
                a.setMunicion(tablaVirtual.getInt(3));
                listArma.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQL_ArmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        c.desconectar();
        return listArma;
    }

}
