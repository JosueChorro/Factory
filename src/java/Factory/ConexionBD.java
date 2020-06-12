/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import java.sql.*;

/**
 *
 * @author JCH
 */
public abstract class ConexionBD {
    protected String[] parametros;
    protected Connection conexion;
    
    abstract Connection open();
    
    public ResultSet consultaSQL(String consulta){
        Statement st;
        ResultSet rs = null;
        
        try{
            st = conexion.createStatement();
            rs = st.executeQuery(consulta);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return rs;
    }
    
    public boolean ejecutarSQL(String consulta){
        Statement st;
        boolean guardar = true;
        
        try{
            st = conexion.createStatement();
            st.executeUpdate(consulta);
        }catch(SQLException ex){
            guardar = false;
            ex.printStackTrace();
        }
        
        return guardar;
    }
    
    public boolean cerrarConexion(String consulta){
        boolean ok = true;
        
        try{
            conexion.close();
        }catch(Exception ex){
            ok = false;
            ex.printStackTrace();
        }
        
        return ok;
    }
    
    
}
