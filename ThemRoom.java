/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DataConnection;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ThemRoom", urlPatterns = {"/ThemRoom"})
public class ThemRoom extends HttpServlet {



   

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        String ma_danh_muc = request.getParameter("ma_danh_muc");  
        String ten_san_pham  = request.getParameter("ten_san_pham");
        String hinh_anh  = request.getParameter("hinh_anh"); 
        String mo_ta = request.getParameter("mo_ta"); 
        String don_gia = request.getParameter("don_gia"); 
        String so_luong  = request.getParameter("so_luong"); 
        
        String ma_san_pham="";
        try{
            ResultSet rs = new DataConnection().selectData("select * from user");
            while(rs.next()){
                String s = rs.getString(1);
                ma_san_pham=Integer.parseInt(s)+1+"";
                
            }
            new DataConnection().executeSql("insert into user value('"+ma_san_pham+"','"+ma_danh_muc+"','"+ten_san_pham+"','"+hinh_anh+"','"+mo_ta+"','"+don_gia+"','"+so_luong+"')");
            response.sendRedirect("admin_room.jsp");
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

  
}
