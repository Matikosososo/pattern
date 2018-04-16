
package factories;

import dao.ArmaDAO;
import exception.MotorNoSoportadoException;

public class DAOFactory {
    public enum Motor{
        MY_SQL, ORACLE, MS_SQL
    }
    
    public ArmaDAO getProductoDAO(Motor motor) throws MotorNoSoportadoException{
        switch(motor){
            case MY_SQL:
                return new MySQL_ArmaDAO();
            case ORACLE:
                return new OracleDB_ArmaDAO();
            default:
                throw new MotorNoSoportadoException(motor+" no soportado");
        }
    }
}
