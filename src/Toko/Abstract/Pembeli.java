/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Toko.Abstract;

/**
 *
 * @author Kian Arata
 */
public class Pembeli {
    private String nama;
    private Admin admin;
    
    public Pembeli(String nama){
        this.nama = nama;
    }
    public void dipimpinAdmin(Admin admin){
        this.admin = admin;
    }
    public void TransaksiAdmin(){
        System.out.println("Nama pembeli : " + this.nama);
        System.out.println("Admin bekerja dengan : ");
        this.admin.Admin();
        System.out.println("------------------------------------------");
    } 
}
