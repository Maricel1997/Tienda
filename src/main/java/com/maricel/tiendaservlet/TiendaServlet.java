/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maricel.tiendaservlet;

import com.maricel.dao.TiendaDAO;
import com.maricel.dao.TiendaDAOImpl;
import com.maricel.model.Tienda;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Usuario
 */
    
@WebServlet(urlPatterns="/TiendaServlet")
public class TiendaServlet extends HttpServlet{
    
    private TiendaDAO TiendaDao;
    
    public TiendaServlet(){
        super();
 
        TiendaDao = new TiendaDAOImpl();   
    }
    
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        this.procesarSolicitud(req, resp);
                   
    }  
     @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
         this.procesarSolicitud(req, resp);
              
     }
     protected void procesarSolicitud(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         switch (request.getParameter("action")){
             case "list":
                this.list(request, response);
                break;
             case "create":
                 this.create(request, response);
                 break;
             case "read":
                 this.read(request, response);
                 break;
             case "update":
                 this.update(request, response);
                 break;
             case "delete":
                 this.delete(request, response);
                 break;
             case "showRegister":
                 this.showRegister(request, response);
                 break;
             case "index":
                this.index(request, response);
                break;
            default:
               this.index(request, response);
                break;  
             
         }
     }
            
       

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Se redirecciona al JSP "index.jsp", es decir la pagina principal.
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
        
        private void showRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
               RequestDispatcher dispatcher = request.getRequestDispatcher("/view/create.jsp");
               dispatcher.forward(request, response);
        }    
               
               private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
               //Recoger los datos desde la peticion
               String name =request.getParameter("nombre");
               String documento =request.getParameter("documento");
                String direccion =request.getParameter("direccion");
               String telefono =request.getParameter("telefono");
                String fechadenac =request.getParameter("fechadenac");
               //crear el objeto que se envia al BD
               Tienda objTienda = new Tienda();
               objTienda.setNombre(name);
               objTienda.setDocumento(documento);
               objTienda.setDireccion(direccion);
               objTienda.setTelefono(telefono);
               objTienda.setFechadeNac(fechadenac);
               
             TiendaDao.insert(objTienda);
              
              //Redireccionar al "index"
              this.index(request, response);
              
              
              
               
               
} 
               private void list(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
                   List<Tienda> listaTiendas = this.TiendaDao.findAll();
                   
                   request.setAttribute("lista",listaTiendas );
                   
                  RequestDispatcher dispatcher = request.getRequestDispatcher("/view/list.jsp");
                  dispatcher.forward(request, response);
                  
               }
        private void read(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
              
         Integer id = Integer.parseInt(request.getParameter("id"));
         
         
         Tienda datosObjTienda = new Tienda();
                 
         datosObjTienda =this.TiendaDao.findById(id);
         
         request.setAttribute("Tiendas",datosObjTienda);
         
         RequestDispatcher dispatcher = request.getRequestDispatcher("/view/read.jsp");
         dispatcher.forward(request, response);
         
        }
       private void update(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
         
        Integer id = Integer.parseInt(request.getParameter("id"));  
        
        Tienda objTienda = new Tienda();
        objTienda = this.TiendaDao.findById(id);
        
        String name = request.getParameter("nombre");
        String documento = request.getParameter("documento");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String fechadenac = request.getParameter("fechadenac");
       
       
        
        objTienda.setNombre(name);
        objTienda.setDocumento(documento);
        objTienda.setDireccion(direccion);
       objTienda.setTelefono(telefono);
       objTienda.setFechadeNac(fechadenac);
       
        //Actualizar los datos en la base de datos
        TiendaDao.updateById(id, objTienda);
        
        this.list(request, response);
        
       }
        private void delete(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        Integer id = Integer.parseInt(request.getParameter("id"));  
        
        Tienda ObjTienda = new Tienda();
        
        ObjTienda = this.TiendaDao.findById(id);
        
        if (! ObjTienda .getId().equals(0)){
            
         this.TiendaDao.deleteById(id);
         
        }else{
            System.out.println("No existe el elementos con ese Id");
        }
        this.list(request, response);
        
        
}
        
}



