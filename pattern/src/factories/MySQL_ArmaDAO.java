package factories;

import dao.ArmaDAO;
import java.util.List;
import model.Arma;
import factories.MySQL_ConexionDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQL_ArmaDAO implements ArmaDAO {

    private ResultSet tablaVirtual;
    private List<Arma> listArma;
    MySQL_ConexionDAO c;

    public MySQL_ArmaDAO() throws ClassNotFoundException, SQLException {
        c = new MySQL_ConexionDAO(DatosConexion.MySQL.SERVER, DatosConexion.MySQL.USER, DatosConexion.MySQL.PASS, DatosConexion.MySQL.BD);

    }

    @Override
    public void create(Arma a) {

        String query = "insert into arma values(null, '" + a.getNombre() + "', " + a.getMunicion() + ")";
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
        String query = "Select * from arma where nombre LIKE '%"+exp+"%'";
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
