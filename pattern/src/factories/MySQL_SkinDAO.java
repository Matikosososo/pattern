package factories;

import dao.SkinDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Arma;
import model.Skin;

public class MySQL_SkinDAO implements SkinDAO {

    private ResultSet tablaVirtual;
    private List<Skin> listSkin;
    MySQL_ConexionDAO c;

    public MySQL_SkinDAO() throws ClassNotFoundException, SQLException {
        c = new MySQL_ConexionDAO(DatosConexion.MySQL.SERVER, DatosConexion.MySQL.USER, DatosConexion.MySQL.PASS, DatosConexion.MySQL.BD);
    }

    @Override
    public void create(Skin s) {
        String query = "insert into skin values(null, '" + s.getNombre() + "')";
        c.ejecutar(query);
    }

    @Override
    public List<Skin> read() {
        String query = "Select * from skin";
        Skin s;
        listSkin = new ArrayList<>();
        tablaVirtual = c.ejecutarSelect(query);
        try {
            while (tablaVirtual.next()) {
                s = new Skin();

                s.setId(tablaVirtual.getInt(1));
                s.setNombre(tablaVirtual.getString(2));
                listSkin.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQL_ArmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        c.desconectar();
        return listSkin;
    }

    @Override
    public void update(Skin s) {
        String query = "UPDATE skin set nombre = " + s.getNombre() + " where id =" + s.getId();
        c.ejecutar(query);
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM skin where id = " + id;
        c.ejecutar(query);
    }

    @Override
    public Skin getByID(int id) {
        String query = "Select * from skin where id = " + id;
        Skin s;
        listSkin = new ArrayList<>();
        tablaVirtual = c.ejecutarSelect(query);
        try {
            if (tablaVirtual.next()) {
                s = new Skin();

                s.setId(tablaVirtual.getInt(1));
                s.setNombre(tablaVirtual.getString(2));
                listSkin.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQL_ArmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        c.desconectar();
        return listSkin.get(0);
    }

    @Override
    public List<Skin> search(String exp) {
        String query = "Select * from skin where nombre LIKE '%" + exp + "%'";
        Skin s;
        listSkin = new ArrayList<>();
        tablaVirtual = c.ejecutarSelect(query);
        try {
            while (tablaVirtual.next()) {
                s = new Skin();

                s.setId(tablaVirtual.getInt(1));
                s.setNombre(tablaVirtual.getString(2));
                listSkin.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQL_ArmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        c.desconectar();
        return listSkin;
    }

}
