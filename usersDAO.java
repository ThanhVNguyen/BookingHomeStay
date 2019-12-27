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
public class usersDAO implements ObjectDAO {

    public boolean addAccount(final Object obj) {
        final users user =(users) obj;
        try{
        new DataConnection().executeSql("insert into user values('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getPhone()+"','"+user.getEmail()+"','"+user.getAddress()+"')");
        return true;
        }catch(Exception e){
                e.printStackTrace();
                 return false;
                }
       
    }

    public users selectAccount(final String username) {
        try {
            final ResultSet rs = new DataConnection().selectData("select * from user where username='" + username + "'");
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
        final users user = new users("aaa", "123","0979524602","thanhv@gmail","Dong Nai");
       //System.out.println(new usersDAO().addAccount(user));
      System.out.println(new usersDAO().checkAccount("aaa","123"));

    }
}