/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller_servlet;


import CRUD_LAB.entity.Estudiantes;
import CRUD_LAB.session.EstudiantesFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author gilberto-pedraza
 */
@WebServlet(name = "StudentServlet", urlPatterns = {"/StudentServlet"})
public class StudentServlet extends HttpServlet {

    @EJB
    private EstudiantesFacadeLocal estudiantesFacade;
    
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
        String codEstudiantes = request.getParameter("codEstudiantes");

        int studentId=0;
        if(codEstudiantes!=null && !codEstudiantes.equals("")){
            studentId=Integer.parseInt(codEstudiantes);
        } 
        
        String nombreEstudiante=request.getParameter("nombreEstudiante");
        String apellidoEstudiante=request.getParameter("apellidoEstudiante");
        
        String yearStr =request.getParameter("semestreEstudiante");
        int semestreEstudiante=Integer.parseInt(yearStr);
        
        
        String action = request.getParameter("action");
        
        Estudiantes student = new Estudiantes(codEstudiantes,nombreEstudiante,apellidoEstudiante,semestreEstudiante);
        
        if("Add".equalsIgnoreCase(action)){
            estudiantesFacade.create(student);
        }else if("Edit".equalsIgnoreCase(action)){
            estudiantesFacade.edit(student);
        }else if("Delete".equalsIgnoreCase(action)){
            estudiantesFacade.remove(student);
        }else if("Search".equalsIgnoreCase(action)){
            estudiantesFacade.find(student.getCodEstudiantes());
 
        }
        
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("student", student);
        request.setAttribute("allStudents", estudiantesFacade.findAll());
        request.getRequestDispatcher("studentInfo.jsp").forward (request,response);
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