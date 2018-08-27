/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;

/**
 *
 * @author Toshiba
 */
public class Alumno implements Serializable{
    
    private int id;  //  2 bytes
    private String Name;  // 2 bytes * 10 letras= 20
    private String LastName;;//=20
    private int age;         //  4
    private long date;      //   8
    private String grado;    //6
    private LIST_COUNTRY country;  //4
    public static enum LIST_COUNTRY{Chinandega,Leon,Managua,Masaya,Granada,Rivas}
                                    //4
    public final static int DIM= 69;
    public Alumno(){}
    public Alumno(
            String Name,
            String LastName,
            int age,
            long date,
            String grado,
            LIST_COUNTRY  country){
        this.Name= Name;
        this.LastName=LastName;
        this.age=age;
        this.date=date;
        this.grado=grado;
        this.country=country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public LIST_COUNTRY getCountry() {
        return country;
    }

    public void setCountry(LIST_COUNTRY country) {
        this.country = country;
    }
    
    
    
}
