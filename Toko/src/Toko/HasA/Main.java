/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Toko.HasA;

/**
 *
 * @author Kian Arata
 */
public class Main {
    public static void main(String[] args) {
        Sepatu s = new Sepatu();
        s.setMerk("Adidas");
        s.setBiaya(10000);
        
        Admin a = new Admin();
        a.setNama("Aldi");
        a.setBiaya(12000);
        
        Pembeli p = new Pembeli();
        p.setNama("Arata");
        p.setSepatu(s);
        p.setAdmin(a);
        p.setJumlah(2);
        System.out.println("Biaya Total = " + p.hitungBiayaTotal());
    }
}
