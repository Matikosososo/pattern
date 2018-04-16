
package factories;

import dao.ArmaDAO;
import dao.CiudadDAO;
import dao.ConexionDAO;
import dao.SkinDAO;
import exception.MotorNoSoportadoException;
import java.sql.SQLException;

public class DAOFactory {
    
    private static DAOFactory daoFactory;
    
    public static DAOFactory getInstance(){
        if(daoFactory == null){
            daoFactory = new DAOFactory();
        }
        
        return daoFactory;
    }
    
    public enum Motor{
        MY_SQL, ORACLE, MS_SQL
    }
    
    
    
    public ArmaDAO getArmaDAO(Motor motor) throws MotorNoSoportadoException, ClassNotFoundException, SQLException{
        switch(motor){
            case MY_SQL:
                return new MySQL_ArmaDAO();
            case MS_SQL:
                return new MS_SQL_ArmaDAO();
            default:
                throw new MotorNoSoportadoException(motor+" no soportado");
        }
    }
    
    public SkinDAO getSkinDAO(Motor motor) throws MotorNoSoportadoException, ClassNotFoundException, SQLException{
        switch(motor){
            case MY_SQL:
                return new MySQL_SkinDAO();
            case MS_SQL:
                return new MS_SQL_SkinDAO();
            default:
                throw new MotorNoSoportadoException(motor+" no soportado");
        }
    }
    
    public CiudadDAO getCiudadDao(Motor motor) throws MotorNoSoportadoException, ClassNotFoundException, SQLException{
        switch(motor){
            case MY_SQL:
                return new MySQL_CiudadDAO();
            case MS_SQL:
                return new MS_SQL_CiudadDAO();
            default:
                throw new MotorNoSoportadoException(motor+" no soportado");
        }
    }
}
