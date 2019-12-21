/*
 * To change this lidcense header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author windows x
 */
public class Data {
    private String id,kategori,merk,warna, ukuran, jumlah;

    public Data(String kategori, String merk, String warna, String ukuran, String jumlah) {
//        this.id = id;
        this.kategori = kategori;
        this.merk = merk;
        this.warna = warna;
        this.ukuran = ukuran;
//        this.harga = harga;
        this.jumlah = jumlah;
    }

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
    
    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

//    public void setHarga(String harga) {
//        this.harga = harga;
//    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getKategori() {
        return kategori;
    }

    public String getMerk() {
        return merk;
    }

    public String getWarna() {
        return warna;
    }

    public String getUkuran() {
        return ukuran;
    }

//    public String getHarga() {
//        return harga;
//    }

    public String getJumlah() {
        return jumlah;
    }
}
