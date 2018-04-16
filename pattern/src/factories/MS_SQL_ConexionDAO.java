package factories;

import dao.ConexionDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MS_SQL_ConexionDAO implements ConexionDAO {

    private Connection con;
    private Statement sentencia;
    private ResultSet tablaVirtual;
    private String server;
    private String usuario;
    private String password;
    private String bd_name;
    private String url;

    public MS_SQL_ConexionDAO(String server, String usuario, String password, String bd_name) throws ClassNotFoundException {
        this.server = server;
        this.usuario = usuario;
        this.password = password;
        this.bd_name = bd_name;

        String protocolo = "jdbc:sqlserver://";
        String lineaUsuario = "user=" + usuario;
        String lineaPassword = "password=" + password;

        url = protocolo + server + ";" + "databaseName=" + bd_name + ";" + lineaUsuario + ";" + lineaPassword;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    }

    @Override
    public void conectar() {
        try {
            System.out.println(url);
            
            con = DriverManager.getConnection(url);
            
            if (con != null) {
                
                System.out.println("OK CONEXi'on!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MS_SQL_ConexionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ejecutar(String sql) {
        try {
            conectar();
            //1.- Crear la sentencia a traves de la conexion
            //Abro la conexion
            
            sentencia = con.createStatement();
            
            //2.- Ejecutar sql
            sentencia.execute(sql);
            System.out.println(sql);
            //3.- Cerrar la conexion --> desconectar();
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(MS_SQL_ConexionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ResultSet ejecutarSelect(String select) {
        conectar();
        System.out.println(select);
        try {
            sentencia = con.createStatement();
            tablaVirtual = sentencia.executeQuery(select);
        } catch (SQLException ex) {
            Logger.getLogger(MS_SQL_ConexionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        return tablaVirtual;
    }

    @Override
    public void desconectar() {
        try {
            sentencia = null;
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(MS_SQL_ConexionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
