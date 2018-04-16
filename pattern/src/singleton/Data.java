package singleton;
import factories.MySQL_ArmaDAO;
public class Data {
    private static Data d;
    
    private Data(){
        // Quizas la conexión
        
        System.out.println("Se ha construido un objeto");
    }
    
    public static Data getInstance(){
        if(d == null){
            d = new Data();
        }
        
        return d;
    }
    
    
}
