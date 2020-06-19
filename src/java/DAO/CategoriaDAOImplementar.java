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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JCH
 */
public class CategoriaDAOImplementar implements CategoriaDAO {
    
    ConexionBD conn;
    
    public CategoriaDAOImplementar() {
        
    }

    @Override
    public List<Categoria> Listar() {
        this.conn = FactoryConexionBD.open(FactoryConexionBD.MySQL);
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
        }catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            this.conn.cerrarConexion();
        }
        
        return lista;
    }

    @Override
    public List<Categoria> Listar2() {
        this.conn = FactoryConexionBD.open(FactoryConexionBD.MySQL);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Categoria editarCat(int id_cat_edit) {
        this.conn = FactoryConexionBD.open(FactoryConexionBD.MySQL);
        Categoria cate = new Categoria();
        StringBuilder miSQL = new StringBuilder();
        miSQL.append("SELECT * FROM tb_categoria WHERE id_categoria = ").append(id_cat_edit);
        try{
            ResultSet resultado = this.conn.consultaSQL(miSQL.toString());
            while(resultado.next()){
                cate.setId_categoria(resultado.getInt("id_categoria"));
                cate.setNom_categoria(resultado.getString("nom_categoria"));
                cate.setEstado_categoria(resultado.getInt("estado_categoria"));
            }
        }catch(Exception ex){
            
        }finally{
            this.conn.cerrarConexion();
        }
        
        return cate;
    }

    @Override
    public boolean guardarCat(Categoria categoria) {
        this.conn = FactoryConexionBD.open(FactoryConexionBD.MySQL);
        boolean guardar = false;
        try{
            if (categoria.getId_categoria() == 0) { // Significa que no existe
                StringBuilder myQuery = new StringBuilder();
                myQuery.append("INSERT INTO tb_categoria (nom_categoria,estado_categoria) VALUES('");
                myQuery.append(categoria.getNom_categoria()).append("', '");
                myQuery.append(categoria.getEstado_categoria()).append("');");
                // Invocar metodo para ejecutar la consulta
                this.conn.ejecutarSQL(myQuery.toString());
            }else if(categoria.getId_categoria() > 0){ // significa que existe
                // Actualizar: id_categorias mayores a cero
                StringBuilder mySQL = new StringBuilder();
                mySQL.append("UPDATE tb_categoria SET nom_categoria = '").append(categoria.getNom_categoria());
                mySQL.append("', estado_categoria = '").append(categoria.getEstado_categoria()).append("'");
                mySQL.append("WHERE id_categoria = ").append(categoria.getId_categoria()).append(" ;");
                this.conn.ejecutarSQL(mySQL.toString());
            }
            guardar = true;
        }catch(Exception ex){
            
        }finally{
            this.conn.cerrarConexion();
        }
        
        return guardar;
    }

    @Override
    public boolean borrarCat(int id_cat_borrar) {
        this.conn = FactoryConexionBD.open(FactoryConexionBD.MySQL);
        boolean borrar = false;
        try{
            StringBuilder miSQL = new StringBuilder();
            miSQL.append("DELETE FROM tb_categoria WHERE id_categoria = ").append(id_cat_borrar);
            this.conn.ejecutarSQL(miSQL.toString());
            borrar = true;
        }catch(Exception ex){
            
        }finally{
            this.conn.cerrarConexion();
        }
        
        return borrar;
    }
    
}
