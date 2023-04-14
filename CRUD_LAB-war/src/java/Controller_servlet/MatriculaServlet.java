/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller_servlet;

    import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import CRUD_LAB.entity.Matricula;
import CRUD_LAB.session.MatriculaFacadeLocal;

/**
 *
 * @author ddav_
 */

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */



@WebServlet(name = "MatriculaServlet", urlPatterns = {"/MatriculaServlet"})
public class MatriculaServlet extends HttpServlet {
    
    @EJB
    private MatriculaFacadeLocal matriculaFacade;

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
        int curso = Integer.parseInt(request.getParameter("curso"));
        int estudiante = Integer.parseInt(request.getParameter("estudiante"));
        int nota = Integer.parseInt(request.getParameter("nota"));
        Matricula matri = new Matricula(curso, estudiante, nota);
        
        String action = request.getParameter("action");
        
        if (action.equals("Add")) {
            matriculaFacade.create(matri);
        }else if (action.equals("Edit")) {
            matriculaFacade.edit(matri);
        }else if (action.equals("Delete")) {
            matriculaFacade.remove(matri);
        }else if (action.equals ("Search")) {
            matri = matriculaFacade.find(curso);
        }
        response.setContentType("text/html;charset=UTF-8");
     
        request.setAttribute("matri", matri);
        request.setAttribute("allMatriculas", matriculaFacade.findAll());
        request.getRequestDispatcher("matriculaInfo.jsp").forward(request, response);
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

