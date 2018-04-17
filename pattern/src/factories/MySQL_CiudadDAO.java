package factories;

import dao.CiudadDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Ciudad;
import model.Skin;

public class MySQL_CiudadDAO implements CiudadDAO {

    private ResultSet tablaVirtual;
    private List<Ciudad> listCiudad;
    MySQL_ConexionDAO c;

    public MySQL_CiudadDAO() throws ClassNotFoundException, SQLException {
        c = new MySQL_ConexionDAO(DatosConexion.MySQL.SERVER, DatosConexion.MySQL.USER, DatosConexion.MySQL.PASS, DatosConexion.MySQL.BD);
    }

    @Override
    public void create(Ciudad ci) {
        String query = "insert into ciudad values(null, '" + ci.getNombre() + "')";
        c.ejecutar(query);
    }

    @Override
    public List<Ciudad> read() {
        String query = "Select * from ciudad";
        Ciudad ci;
        listCiudad = new ArrayList<>();
        tablaVirtual = c.ejecutarSelect(query);
        try {
            while (tablaVirtual.next()) {
                ci = new Ciudad();

                ci.setId(tablaVirtual.getInt(1));
                ci.setNombre(tablaVirtual.getString(2));
                listCiudad.add(ci);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQL_ArmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        c.desconectar();
        return listCiudad;
    }

    @Override
    public void update(Ciudad ci) {
        String query = "UPDATE ciudad set nombre = " + ci.getNombre() + " where id =" + ci.getId();
        c.ejecutar(query);
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM ciudad where id = " + id;
        c.ejecutar(query);
    }

    @Override
    public Ciudad getByID(int id) {
        String query = "Select * from ciudad where id = " + id;
        Ciudad ci;
        listCiudad = new ArrayList<>();
        tablaVirtual = c.ejecutarSelect(query);
        try {
            if (tablaVirtual.next()) {
                ci = new Ciudad();

                ci.setId(tablaVirtual.getInt(1));
                ci.setNombre(tablaVirtual.getString(2));
                listCiudad.add(ci);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQL_ArmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        c.desconectar();
        return listCiudad.get(0);
    }

    @Override
    public List<Ciudad> search(String exp) {
        String query = "Select * from ciudad where nombre LIKE '%" + exp + "%'";
        Ciudad ci;
        listCiudad = new ArrayList<>();
        tablaVirtual = c.ejecutarSelect(query);
        try {
            while (tablaVirtual.next()) {
                ci = new Ciudad();

                ci.setId(tablaVirtual.getInt(1));
                ci.setNombre(tablaVirtual.getString(2));
                listCiudad.add(ci);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQL_ArmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        c.desconectar();
        return listCiudad;
    }

}
