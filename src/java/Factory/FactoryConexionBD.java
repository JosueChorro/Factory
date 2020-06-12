/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

/**
 *
 * @author JCH
 */
public class FactoryConexionBD {
    public static final int MySQL = 1;
    public static String[] configMySQL = {"bd_inventario", "root", ""};
    
    public static ConexionBD open(int tipoBD){
        switch(tipoBD){
            case FactoryConexionBD.MySQL:
                return new MySQLConexionFactory(configMySQL);
            default:
                return null;
        }
    }
}
