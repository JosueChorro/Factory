/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import DAO.CategoriaDAO;
import DAO.CategoriaDAOImplementar;
import Model.Categoria;
import java.util.List;

/**
 *
 * @author JCH
 */
public class Prueba {
    public static void main(String[] args) {
        Prueba eva = new Prueba();
        eva.guardarcate();
        eva.listar();
    }
    
    public void listar(){
        CategoriaDAO dao = new CategoriaDAOImplementar();
        List<Categoria> list = dao.Listar();
        
        System.out.println("Lista de categorias");
        for (Categoria listar : list) {
            String estado = "";
            if (listar.getEstado_categoria() == 1) {
                estado = "Activo";
            }else{
                estado = "Inactivo";
            }
            System.out.println("ID: " + listar.getId_categoria() + "\n"
                    + "Nombre: " + listar.getNom_categoria() + "\n"
                    + "Estado: " + estado + "\n");
        }
    }
    
    public void editarcat(){
        CategoriaDAO dao = new CategoriaDAOImplementar();
        Categoria edit = dao.editarCat(1);
        
        System.out.println("Lista de categorias");
        String estado = "";
        if (edit.getEstado_categoria() == 1) {
            estado = "Activo";
        }else{
            estado = "Inactivo";
        }
        System.out.println("ID: " + edit.getId_categoria() + "\n"
                    + "Nombre: " + edit.getNom_categoria() + "\n"
                    + "Estado: " + estado + "\n");
        
    }
    
    public void guardarcate(){
        CategoriaDAO dao = new CategoriaDAOImplementar();
        Categoria guardar = new Categoria();
        guardar.setNom_categoria("Bebidas Naturales");
        guardar.setId_categoria(5);
        guardar.setEstado_categoria(1);
        dao.guardarCat(guardar);
    }
}
