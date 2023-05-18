/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop;

/**
 *
 * @author User
 */
/**
 * class Akun
 * untuk menyimpan dari setiap email dan password
 * yang memiliki akses modifier public
 */
public class Akun {
    
    /**
     * variabel ini menggunakan access private
     * yang akan menjadi encapulasi
     * yang merubah akses modifier private menjadi public
     */
    private String email, password;

    /**
     * custructpr menggunakan akses modifier public
     * agar dapat diakses keseluruh package
     */
    public Akun(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
     /**
     * method ini untuk mengambibil variabel email
     * yang akan mengembalikan nilai dari String
     * 
     * @return String
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * method ini untuk mengset variabel email
     * 
     * @param email
     * yang akan menukar nilai
     */
    public void getEmail (String email) {
        this.email = email;
    }

     /**
     * method ini untuk mengambibil variabel password
     * yang akan mengembalikan nilai dari String
     * 
     * @return String
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * method ini untuk mengset variabel password
     * 
     * @param password
     * yang akan menukar nilai
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * method ini untuk mengset variabel password
     * dan juga menjadi overloading method
     * @param password
     * yang akan menukar nilai
     */
    public void setPassword(int password) {
        this.password = String.valueOf(password);
    }
}
