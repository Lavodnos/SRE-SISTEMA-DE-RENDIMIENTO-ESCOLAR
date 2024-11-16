/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ALUMNO;
import Modelo.ALUMNO_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author kimbe
 */
@WebServlet(name = "UpdatePassALU", urlPatterns = {"/UpdatePassALU"})
public class UpdatePassALU extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
        ALUMNO ALU=new ALUMNO();
        ALUMNO_DAO ALUdao=new ALUMNO_DAO();
           
          
             int idp=Integer.parseInt(request.getParameter("id"));
              String nwepass=request.getParameter("txt_Newpassword");
              ///pasando datos al DAO ALUMNO
              
              if (idp!=0 && nwepass!=null) {
             ALUdao.UpdatePassword(idp,nwepass);
          JOptionPane.showMessageDialog(null, "Contraseñá Actualizada");
               request.getRequestDispatcher("Controlador?accion=cambiarpassword").forward(request, response);
        }else{

               JOptionPane.showMessageDialog(null, "ERROR, NO SE ACTULIZO CONTRASEÑA");
                 request.getRequestDispatcher("Vista/Admin/Mostrar_AlumnoS.jsp").forward(request, response);
          }
         
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
