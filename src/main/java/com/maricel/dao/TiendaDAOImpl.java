/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maricel.dao;

import com.maricel.config.Conexion;
import com.maricel.model.Tienda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class TiendaDAOImpl implements TiendaDAO{
    
    private Conexion objConexion;
    private Connection objConnection;

    public TiendaDAOImpl () {
        objConexion = new Conexion();
    }

    @Override
    public List<Tienda> findAll() {
        //Consulta SQL que se tiene que realizar
        String consulta = "SELECT * FROM tiendas";
        // Listado de datos que se retorna
        List<Tienda> listado = new LinkedList<>();

        try {
            this.objConexion.conectar();
            this.objConnection = this.objConexion.getJdbcConnection();

            PreparedStatement prest = this.objConnection.prepareStatement(consulta);
            // Ejecuta la consulta
            ResultSet rs = prest.executeQuery(consulta);

            Tienda objTienda;

            while (rs.next()) {
                objTienda = new Tienda();
                objTienda.setId(rs.getInt("id"));
                objTienda.setNombre(rs.getString("nombre"));
                objTienda.setDocumento(rs.getString("documento"));
               objTienda.setDireccion(rs.getString("direccion"));
                objTienda.setTelefono(rs.getString("telefono"));
                objTienda.setFechadeNac(rs.getString("fechadenac"));
               

                listado.add(objTienda);
            }

        } catch (Exception e) {
            System.out.println("Error en la consulta " + e);
        }
        return listado;
    }

    @Override
    public Tienda insert(Tienda objTienda) {
        String consulta = "INSERT INTO tiendas (nombre, documento, direccion, telefono, fechadenac ) VALUES (?,?,?,?,?)";
        try{
            this.objConexion.conectar();
            this.objConnection = this.objConexion.getJdbcConnection();
            //Inicializacion de la consulta
            PreparedStatement  prest = this.objConnection.prepareStatement(consulta);
            //Agregar los datos dentro de la consulta
            prest.setString(1, objTienda.getNombre());
            prest.setString(2, objTienda.getDocumento());
            prest.setString(3, objTienda.getDireccion());
            prest.setString(4, objTienda.getTelefono());
             prest.setString(5, objTienda.getFechadeNac());
            
            int count = prest.executeUpdate();
            
            ResultSet rs = null;
            rs = prest.executeQuery("SELECT LAST_INSERT_ID()");
            
            int autoKey = -1;
            if(rs.next()){
                autoKey = rs.getInt("id");
               objTienda .setId(autoKey);
                System.out.println("Ultimo ID introducto " + autoKey);
            }else{
                System.out.println("No exite dato de ID");
            }
        }catch(Exception e){
            System.out.println("Error al insertar " + e);
        }
        return  objTienda;
    }

    @Override
    public Tienda findById(Integer id) {
        String consulta = "SELECT * FROM tiendas WHERE id=?";
        Tienda  objTienda = new Tienda();
        try{
            this.objConexion.conectar();
            this.objConnection = objConexion.getJdbcConnection();
            PreparedStatement prest = this.objConnection.prepareStatement(consulta);
            prest.setInt(1, id);
            ResultSet rs = prest.executeQuery();
            
           while (rs.next()){
           objTienda.setId(rs.getInt("id"));
            objTienda.setNombre(rs.getString("nombre"));
           objTienda.setDocumento(rs.getString("documento"));
            objTienda.setDireccion(rs.getString("direccion"));
            objTienda.setTelefono(rs.getString("telefono"));
            objTienda.setFechadeNac(rs.getString("fechadenac"));
           }
            
        }catch(Exception e){
            System.out.println("Error en findById " + e );
        }
        return objTienda;
    }

    @Override
    public Tienda updateById(Integer id, Tienda objTienda) {
        String consulta = "UPDATE tiendas SET nombre=?, documento=?, direccion=?, telefono=? fechadenac=? WHERE id=?";
        try{
            this.objConexion.conectar();
            this.objConnection = this.objConexion.getJdbcConnection();
            PreparedStatement prest = this.objConnection.prepareStatement(consulta);
            prest.setString(1, objTienda.getNombre());
            prest.setString(2, objTienda.getDocumento());
            prest.setString(3, objTienda.getDireccion());
            prest.setString(4, objTienda.getTelefono());
             prest.setString(5, objTienda.getFechadeNac());
            prest.setInt(6, id );
            int resultado = prest.executeUpdate();
            
            if(resultado == 1){
                System.out.println("Actualizacion satisfactoria");
                objTienda.setId(id);
            }else{
                objTienda.setId(0);
                System.out.println("No se actualizo el registro");
            }
        }catch (Exception e){
            System.out.println("Error en updateById " + e);
        }
        return objTienda;
    }

    @Override
    public Boolean deleteById(Integer id) {
       String consulta = "DELETE FROM tiendas WHERE id=?";
       Boolean returnValue = false;
       try{
           this.objConexion.conectar();
           this.objConnection = objConexion.getJdbcConnection();
           PreparedStatement prest = this.objConnection.prepareStatement(consulta);
           prest.setInt(1, id);
           
           int resultado = prest.executeUpdate();
           if(resultado > 0){
               returnValue = true;
           }
           System.out.println("Eliminacion satisfactoria");
       }catch(Exception e){
           System.out.println("Eror en deleteById " + e);
       }
       return returnValue;
    }

}
