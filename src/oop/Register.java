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
 * class Register
 * untuk menyimpan dari setiap email, password dan namaLengkap
 * yang memiliki akses modifier public
 */
public class Register extends Akun{
    
    /**
     * variabel ini menggunakan access private
     * yang akan menjadi encapulasi
     * yang merubah akses modifier private menjadi public
     */
    private static String namaLengkap; 
    
    public Register(String email, String password, String namaLengkap) {
        super(email, password);
        this.namaLengkap = namaLengkap;
    }
    
     /**
     * custructpr menggunakan akses modifier public
     * agar dapat diakses keseluruh package
     * dan menjadi overloading method
     */
    public Register(String email, String password) {
        super(email, password);
    }
    /**
     * method ini untuk mengambibil variabel namaLengkap
     * yang akan mengembalikan nilai dari String
     * 
     * @return String
     */
    public String getNamaLengkap() {
        return namaLengkap;
    }
    /**
     * method ini untuk mengset variabel namaLengkap
     * 
     * @param email
     * yang akan menukar nilai
     */
    public void setNamaLengkap() {
        this.namaLengkap = namaLengkap;
    }
}
