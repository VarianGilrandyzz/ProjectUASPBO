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
public class Admin {
    private String nama;

    public Admin(String nama){
        this.nama = nama;
    }
    public void Berkendara(){
        System.out.println("Nama : " + this.nama);
    }
}
