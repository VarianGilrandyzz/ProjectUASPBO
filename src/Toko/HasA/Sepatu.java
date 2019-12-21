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
public class Sepatu {
    private String merk;
    private int biaya;
    
    Sepatu(){
        
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getMerk() {
        return merk;
    }

    public void setBiaya(int biaya) {
        this.biaya = biaya;
    }

    public int getBiaya() {
        return biaya;
    }

    public int hitungBiayaSepatu(int jumlah) {
        return biaya * jumlah;
    }
}
