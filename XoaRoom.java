package controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DataConnection;


@WebServlet(name = "XoaRoom", urlPatterns = {"/XoaRoom"})
public class XoaRoom extends HttpServlet {

    


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String ma_san_pham = request.getParameter("ma_san_pham");
        try {
            new DataConnection().executeSql("delete from san_pham where ma_san_pham='" + ma_san_pham + "'" );
            response.sendRedirect("admin_room.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}