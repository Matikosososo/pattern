/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

/**
 *
 * @author msilva
 */
public class DatosConexion {
    public static class MySQL{
        public static final String SERVER   = "localhost";
        public static final String USER     = "root";
        public static final String PASS     = "";
        public static final String BD       = "bd_muestra";
    }
    
    public static class MSSQL{
        public static final String SERVER   = "RA52PCALU-31522";
        public static final String USER     = "sa";
        public static final String PASS     = "123456";
        public static final String BD       = "muestra_db";
    }
}
