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
public class Pembeli {
    private String nama;
    private Sepatu sepatu;
    private Admin admin;
    private int jumlah;
    
    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setSepatu(Sepatu sepatu) {
        this.sepatu = sepatu;
    }

    public Sepatu getSepatu() {
        return sepatu;
    }
    public void setAdmin(Admin  admin) {
        this.admin = admin;
    }

    public Admin getAdmin() {
        return admin;
    }
    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getJumlah() {
        return jumlah;
    }
    public int hitungBiayaTotal() {
        return sepatu.hitungBiayaSepatu(jumlah) + admin.hitungBiayaAdmin(jumlah);
    }
}
