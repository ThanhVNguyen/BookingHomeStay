/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class booking {
    String username;
    String email;
    String arrival_date;
    String depature_date;
    String room;
    String no_people;


    public booking( String username, String email, String arrival_date, String depature_date, String room, String no_people) {

        this.username = username;
        this.email = email;
        this.arrival_date = arrival_date;
        this.depature_date = depature_date;
        this.room = room;
        this.no_people = no_people;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(String arrival_date) {
        this.arrival_date = arrival_date;
    }

    public String getDepature_date() {
        return depature_date;
    }

    public void setDepature_date(String depature_date) {
        this.depature_date = depature_date;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getNo_people() {
        return no_people;
    }

    public void setNo_people(String no_people) {
        this.no_people = no_people;
    }

    @Override
    public String toString() {
        return "booking{" + "username=" + username + ", email=" + email + ", arrival_date=" + arrival_date + ", depature_date=" + depature_date + ", room=" + room + ", no_people=" + no_people + '}';
    }


   
}
