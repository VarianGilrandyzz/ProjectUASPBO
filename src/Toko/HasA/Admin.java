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
public class Admin {
    private String nama;
    private int biaya;
    
    Admin(){
        
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setBiaya(int biaya) {
        this.biaya = biaya;
    }

    public int getBiaya() {
        return biaya;
    }
    
    public int hitungBiayaAdmin(int jumlah){
            return biaya * jumlah;
}
}