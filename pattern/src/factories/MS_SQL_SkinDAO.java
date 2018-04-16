package factories;

import dao.SkinDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Ciudad;
import model.Skin;

public class MS_SQL_SkinDAO implements SkinDAO {

    private ResultSet tablaVirtual;
    private List<Skin> listSkin;
    MS_SQL_ConexionDAO c;

    public MS_SQL_SkinDAO() throws ClassNotFoundException {
        c = new MS_SQL_ConexionDAO("RA52PCALU-31522", "sa", "123456", "muestra_db");//Cambiar Server en otro pc
    }

    @Override
    public void create(Skin s) {
        String query = "insert into skin values('" + s.getNombre() + "')";
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
