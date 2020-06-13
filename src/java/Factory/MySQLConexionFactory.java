/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author JCH
 */
public final class MySQLConexionFactory extends ConexionBD{

    public MySQLConexionFactory(String[] criterios) {
        this.parametros = criterios;
        this.open();
    }
  
    @Override
    public Connection open() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/" + this.parametros[0], this.parametros[1] , this.parametros[2]);
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return conexion;
    }
    
}
