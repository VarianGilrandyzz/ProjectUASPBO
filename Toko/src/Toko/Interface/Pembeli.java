/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Toko.Interface;

/**
 *
 * @author Kian Arata
 */
public class Pembeli {
     private String nama;
    
    
    public void mendampingipembeli(InAdmin Admin){
        System.out.println("Saya mau melihat barang-barang di toko anda");
        System.out.println("Tolong dampingi saya");
        
        Admin.bekerja();
        Admin.memerintah();
        Admin.kurangiHarga();
        Admin.tambahHarga();
        
        System.out.println("-----------------------------------------------------");
    }
}
