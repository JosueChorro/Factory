/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Categoria;
import java.util.List;

/**
 *
 * @author JCH
 */
public interface CategoriaDAO {
    public List<Categoria> Listar();
    public List<Categoria> Listar2();
    public Categoria editarCat(int id_cat_edit);
    public boolean guardarCat(Categoria categotia);
    public boolean borrarCat(int id_cat_borrar);
}
