/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "SessionServlet", urlPatterns = {"/SessionServlet"})
public class SessionServlet extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession sesion = request.getSession();
        String titulo = null;
        
        Integer contadorVisitas
                = (Integer) sesion.getAttribute("contadorVisitas");
        if (contadorVisitas== null) {
            contadorVisitas= new Integer(1);
            titulo= "BIENVENIDO POR PRIMRA VEZ";
        
    }else{
        titulo= "Bienvenido Nuevamente";
        contadorVisitas += 1;  }
        
        sesion.setAttribute("contadorVisitas", contadorVisitas);
        

            PrintWriter out = response.getWriter();
            out.println("T&iacute;tulo: "+ titulo);
            out.println("<br>");
            out.println("No. Acceso al recurso: "+ contadorVisitas);
            out.println("<br>");
            out.println("ID de la sesi&oacute;n: "+ sesion.getId());
        }
    }

    

