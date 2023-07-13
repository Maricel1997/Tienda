/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.maricel.dao;

import com.maricel.model.Tienda;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface TiendaDAO {
    //Metodo que devuelve el listado de objetos
    public List<Tienda> findAll();
    // Metodo que inserta un onjeto en la BBDD
    public Tienda insert(Tienda objTienda);
    //Metodo que devuelde un objeto en base a su ID
    public Tienda findById(Integer id);
    //Metodo que modifica un objeto en la BBDD en base a su ID
    public Tienda updateById(Integer id, Tienda objTienda);
    //Metodo que elimina un objeto en la BDD en base a su ID
    public Boolean deleteById(Integer id);
    
}
