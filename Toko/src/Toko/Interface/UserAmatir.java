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
public class UserAmatir extends Admin implements InAdmin {

    public UserAmatir(String nama) {
        super(nama);
    }

    @Override
    public void bekerja() {
        System.out.println("Admin bekerja dengan baik");
    }

    @Override
    public void memerintah() {
        System.out.println("Admin memerintah pembeli untuk membayar terlebih dahulu");
    }

    @Override
    public void kurangiHarga() {
        System.out.println("Mengurangi harga barang");
    }

    @Override
    public void tambahHarga() {
        System.out.println("Menambah harga barang");
    }
    
}
