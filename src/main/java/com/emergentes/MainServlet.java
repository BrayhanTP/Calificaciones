/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author RUBEN
 */
@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        Personas objper = new Personas();
        int id,pos;
        HttpSession ses = request.getSession();
        ArrayList <Personas> lista = (ArrayList<Personas>) ses.getAttribute("listaper");
        switch(op){
            case "nuevo":
                //enivar un objeto vacio a editar
                request.setAttribute("miobjper", objper);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "Editar":
                //Enviar un objeto a editar pero con conternido
                id=Integer.parseInt(request.getParameter("id"));
                pos = buscarPorIndice(request, id);
                objper =lista.get(pos);
                request.setAttribute("miobjper", objper);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "eliminar":
                //eliminar el registrp de la coleccion segun el id
                 id=Integer.parseInt(request.getParameter("id"));
                pos = buscarPorIndice(request, id);
                if (pos >=0){
                    lista.remove(pos);
                }
                request.setAttribute("listaper", lista);
                response.sendRedirect("index.jsp");;
                break;
            default:
                
        }
   
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession ses = request.getSession();
        ArrayList <Personas> lista =(ArrayList<Personas>)ses.getAttribute("listaper");
        Personas objper = new Personas();
        objper.setId(id);
        objper.setNombre(request.getParameter("nombre"));
        objper.setPrimer_parcial(Integer.parseInt(request.getParameter("primer_parcial")));
        objper.setSegundo_parcial(Integer.parseInt(request.getParameter("segundo_parcial")));
        objper.setExamen_final(Integer.parseInt(request.getParameter("examen_final")));
        if(id == 0){
            int idNuevo = obtenerId(request);
            objper.setId(idNuevo);
            lista.add(objper);
            
        }
        else{
            int pos = buscarPorIndice(request,id);
            lista.set(pos, objper);
            
            
        }
       request.setAttribute("listaper", lista);
        response.sendRedirect("index.jsp");
        
        
    }

public int buscarPorIndice (HttpServletRequest request,int id){
    HttpSession ses = request.getSession();
    ArrayList<Personas> lista = (ArrayList<Personas>) ses.getAttribute("listaper");
    int pos = -1;
    if (lista != null){
        for(Personas ele : lista){
            ++pos;
            if(ele.getId() == id){
                break;
            }
            
        }
    }
    return pos;
}
  public int obtenerId(HttpServletRequest request){
      HttpSession ses = request.getSession();
      ArrayList<Personas> lista = (ArrayList<Personas>) ses.getAttribute("listaper");
      int idn =0;
      for (Personas ele : lista){
          idn= ele.getId();
      }
      return idn +1;
  }

}
