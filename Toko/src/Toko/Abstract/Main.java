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
public class Main {
          public static void main(String[] args) {
         UserAmatir pa = new UserAmatir();
         UserPro po = new UserPro();
         Pembeli p1 = new Pembeli("Arata");
         Pembeli p2 = new Pembeli("Kian");
         
         p1.dipimpinAdmin(pa);
         p2.dipimpinAdmin(po);
         
         p1.TransaksiAdmin();
         p2.TransaksiAdmin();
    }
}
