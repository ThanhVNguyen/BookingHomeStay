/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.bookingDAO;
import dao.usersDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.booking;
import model.users;

/**
 *
 * @author Admin
 */
@WebServlet("/RepairBooking")
public class RepairBooking extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(final HttpServletRequest request,final HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        
        final String username=request.getParameter("username");
        final String email=request.getParameter("email");
        final String arrival_date=request.getParameter("arrival_date");
        final String depature_date =request.getParameter("depature_date");
        final String room =request.getParameter("room");
        final String no_people =request.getParameter("no_people");
      
  
 
        final booking book = new booking(username,email,arrival_date,depature_date,room,no_people);
        if(new bookingDAO().addBooking(book)){
           HttpSession session =request.getSession();
           session.setAttribute("book",book);
           response.sendRedirect("notice.jsp");
        }else{
            System.out.println("Error Register");
        }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    protected void doPost(final HttpServletRequest request,final HttpServletResponse response)
            throws ServletException, IOException {
            this.doGet(request, response);
 
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
