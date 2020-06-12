/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Factory.ConexionBD;
import Factory.FactoryConexionBD;
import Model.Categoria;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JCH
 */
public class CategoriaDAOImplementar implements CategoriaDAO {
    
    ConexionBD conn;
    
    public CategoriaDAOImplementar() {
        this.conn = FactoryConexionBD.open(FactoryConexionBD.MySQL);
    }

    @Override
    public List<Categoria> Listar() {
        StringBuilder miSQL = new StringBuilder();
        miSQL.append("SELECT * FROM tb_categoria");
        List<Categoria> lista = new ArrayList<Categoria>();
        try{
            ResultSet resultado = this.conn.consultaSQL(miSQL.toString());
            while(resultado.next()){
                Categoria categoria = new Categoria();
                categoria.setId_categoria(resultado.getInt("id_categoria"));
                categoria.setNom_categoria(resultado.getString("nom_categoria"));
                categoria.setEstado_categoria(resultado.getInt("estado_categoria"));
                
                lista.add(categoria);
            }
        }catch(Exception ex){
            
        }finally{
            this.conn.cerrarConexion();
        }
        
        return lista;
    }

    @Override
    public List<Categoria> Listar2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Categoria editarCat(int id_cat_edit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean guardarCat(Categoria categotia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borrarCat(int id_cat_borrar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
