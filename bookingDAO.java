/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.DataConnection;
import model.users;
import java.sql.ResultSet;
import model.booking;

/**
 *
 * @author Admin
 */
public class bookingDAO implements Object1DAO {

    public boolean addBooking(final Object obj) {
        final booking book =(booking) obj;
        try{
        new DataConnection().executeSql("insert into booking values('"+book.getUsername()+"','"+book.getEmail()+"','"+book.getArrival_date()+"','"+book.getDepature_date()+"','"+book.getRoom()+"','"+book.getNo_people()+"')");
        return true;
        }catch(Exception e){
                e.printStackTrace();
                 return false;
                }
       
    }

    public users selectBooking(final String username) {
        try {
            final ResultSet rs = new DataConnection().selectData("select * from booking where username='" + username + "'");
            if (rs.next()) {
                final String name = rs.getString(1);
                final String password = rs.getString(2);
                final String phone = rs.getString(3);
                 final String email = rs.getString(4);
                  final String address = rs.getString(5);
                
                return new users(name, password,phone,email,address);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }
    

public boolean checkAccount(final String username, final String password) {
        try {
            final ResultSet rs = new DataConnection().selectData("select * from user where username='" + username + "'");
            while (rs.next()) {
                if (rs.getString(1).equals(username) && rs.getString(2).equals(password)) {
                    return true;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public static void main(final String[] args) {
        final booking book = new booking("thanh","thanh@gmail", "12/12/2019","13/12/2019","1","2");
       System.out.println(new bookingDAO().addBooking(book));
      //System.out.println(new usersDAO().checkAccount("aaa","123"));

    }
}