/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maricel.model;

/**
 *
 * @author Usuario
 */
public class Tienda {
    
      
      private String nombre;
      private String documento;
      private String direccion;
      private String telefono;
      private String fechadenac;
      private Integer id;
        
   public Tienda(){
            
        }
         
           //getters y setters
        public String getNombre(){
            return nombre;
        }
        public void setNombre(String name){
            this.nombre= name;
            
        }
         public String getDocumento(){
            return documento;
        }
        public void setDocumento(String documento){
            this.documento= documento;
        }
            
             public String getDireccion(){
            return direccion;
        }
        public void setDireccion(String direccion){
            this.direccion= direccion;
        }
             public String getTelefono(){
            return telefono;
        }
        public void setTelefono(String telefono){
            this.telefono= telefono;
            
        }
         public void setFechadeNac(String fechadenac){
            this.fechadenac= fechadenac;
        }
             public String getFechadeNac(){
            return fechadenac;
        }
    
         public Integer getId(){
            return id;
        }
        public void setId(Integer id){
            this.id= id;
        }
        
    
}


