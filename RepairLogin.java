package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import model.users;
import dao.usersDAO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet({ "/RepairLogin" })
public class RepairLogin extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

        final String username = request.getParameter("username");
        final String password = request.getParameter("password");
        final users user = new usersDAO().selectAccount(username);
        System.out.println(user);
         if(new usersDAO().checkAccount(username, password)) {
            final HttpSession session = request.getSession();
            session.setAttribute("name", (Object)user);
            response.sendRedirect("index.jsp");
                    
         }else{
            response.sendRedirect("errorLogin.jsp");
            //System.out.println("Error Login");
        }
        
    }
    
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}