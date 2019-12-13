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
public class Main {
    public static void main(String[] args) {
        Pembeli p = new Pembeli();
        UserAmatir ua = new UserAmatir("Bambang");
        UserPro uo = new UserPro("Kian");
        
        p.mendampingipembeli(ua);
        p.mendampingipembeli(uo);
        
    }
}
