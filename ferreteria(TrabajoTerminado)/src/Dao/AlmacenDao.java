/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Almacen;
import java.util.List;

/**
 *
 * @author kmvil
 */
public interface AlmacenDao {
    public boolean registrarAlmacen(Almacen alm);
    public List listarAlmacen();
    public boolean actualizarAlmacen(Almacen alm);
    public boolean eliminarAlmacen(int id) ;
    public List ObtenerAlmacenPorIdArticulo(int id);
}
