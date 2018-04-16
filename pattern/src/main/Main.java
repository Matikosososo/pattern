package main;

import com.mysql.jdbc.MySQLConnection;
import exception.MotorNoSoportadoException;
import factories.DAOFactory;
import factories.MySQL_ArmaDAO;
import factories.MySQL_ConexionDAO;
import java.sql.SQLException;
import java.util.List;
import model.Arma;
import model.Ciudad;
import model.Skin;

public class Main {

    public static void main(String[] args) throws MotorNoSoportadoException, ClassNotFoundException, SQLException {
//---------------------------MY SQL------------------------------
        System.out.println("--------------------------------MY SQL------------------------------------");
//---------------------------ARMAS------------------------------
        //crear Nuevo
        //Arma a = new Arma("Pipa", 1);
        //DAOFactory.getInstance().getArmaDAO(DAOFactory.Motor.MY_SQL).create(a);

        //Actualizar
        //Arma a = new Arma(4, 5);
        //DAOFactory.getInstance().getArmaDAO(DAOFactory.Motor.MY_SQL).update(a);
        
        // BORRAR (DELETE)
        //DAOFactory.getInstance().getArmaDAO(DAOFactory.Motor.MY_SQL).delete(4);
        
        //Read o get lista
        List<Arma> ListaArmas = DAOFactory.getInstance().getArmaDAO(DAOFactory.Motor.MY_SQL).read();
        for (Arma a : ListaArmas) {
            System.out.println(a);
        }

        //Buscar arma por id
        Arma b = DAOFactory.getInstance().getArmaDAO(DAOFactory.Motor.MY_SQL).getByID(2);
        System.out.println(b);

        //Buscar por expresion
        List<Arma> ListaArmasBuscar = DAOFactory.getInstance().getArmaDAO(DAOFactory.Motor.MY_SQL).search("mi");

        for (Arma a : ListaArmasBuscar) {
            System.out.println(a);
        }

        //---------------------------Skin------------------------------
        //crear Nuevo
        //Skin s = new Skin("Mochila monton de chatarra");
        //DAOFactory.getInstance().getSkinDAO(DAOFactory.Motor.MY_SQL).create(s);
        
        
        //---------------------------Ciudad------------------------------
        //crear Nuevo
        //Ciudad c = new Ciudad("Pisos Picados");
        //DAOFactory.getInstance().getCiudadDao(DAOFactory.Motor.MY_SQL).create(c);
        //---------------------------MS SQL------------------------------
        System.out.println("--------------------------------MS SQL------------------------------------");
        
        //CREAR ARMA
        //Arma a = new Arma("Escopeta Tactica", 8);
        //DAOFactory.getInstance().getArmaDAO(DAOFactory.Motor.MS_SQL).create(a);
        
        //LISTA O READ 
        List<Arma> listaArmasMS = DAOFactory.getInstance().getArmaDAO(DAOFactory.Motor.MS_SQL).read();
        
        for (Arma s : listaArmasMS) {
            System.out.println(s);
        }
        
        //UPDATE
        //Arma d = new Arma(2, 4);
        //DAOFactory.getInstance().getArmaDAO(DAOFactory.Motor.MS_SQL).update(d);
        
        //DELETE
        //DAOFactory.getInstance().getArmaDAO(DAOFactory.Motor.MS_SQL).delete(2);
        
        //Buscar arma por id
        Arma bMS = DAOFactory.getInstance().getArmaDAO(DAOFactory.Motor.MS_SQL).getByID(1);
        System.out.println(bMS);

        //Buscar por expresion
        List<Arma> ListaArmasBuscarMS = DAOFactory.getInstance().getArmaDAO(DAOFactory.Motor.MS_SQL).search("ta");

        for (Arma a : ListaArmasBuscarMS) {
            System.out.println(a);
        }
    }

}
