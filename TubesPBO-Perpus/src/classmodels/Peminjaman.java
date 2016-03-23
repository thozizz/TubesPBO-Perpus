package classmodels;


// Author Fachri Ul Albab & Thoriq & Dede
// Keterangan : 
//  1. +7 Tanggal Kembali
//  2. Hitung Denda

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Peminjaman{
    //Class Variable / Attribute
    private ArrayList<Buku> listBuku = new ArrayList();
    private String idPeminjaman;
    private Date tanggalPinjam;
    private Date tanggalKembali;
    private Date tanggalPengembalian;
    private boolean statusPeminjaman = true;
    private double biayaDenda;
    private int maxPinjam;


    // CONSTRUCTOR //
    public Peminjaman(String IdPeminjaman, Date tanggalPinjam, int maxPinjam){
        this.idPeminjaman = IdPeminjaman;
        this.maxPinjam = maxPinjam;
        this.tanggalPinjam = tanggalPinjam;
        
        //Add 7 Days to tanggalPinjam sebagai tanggal Pengembalian
        //using java.util.calender
        Calendar cal = Calendar.getInstance();
        cal.setTime(tanggalPinjam);
        cal.add(Calendar.DATE, 7);
        this.tanggalKembali = cal.getTime();
    }

    // CLASS METHOD //
    public void addBuku(Buku b){
        if(getSisaPinjam() > 0){
            b.kurangSisaBuku();
            listBuku.add(b);
        } else {
            System.out.println("Peminjaman Penuh");
        }
    }

    public void removeBukuByObject(Buku b){
        if(listBuku.size() > 0){    
            listBuku.remove(b);
            b.kurangSisaBuku();
        }else{
            System.out.println("Tidak ada buku pada peminjaman ID : " + getId() );
        }
    }

    public void removeBukuByIndex(int idx){
        if(listBuku.size() > 0){    
            listBuku.remove(idx);
        }else{
            System.out.println("Tidak ada buku yang dipinjam");
        }
    }
    
    public void removeBukuById(String idBuku){
        Buku buku = getBukuById(idBuku);
        removeBukuByObject(buku);
    }

    public Buku getBukuByIndex(int idx){
        try {
            return listBuku.get(idx);
        } catch (Exception e) {
            return null; //Jika tidak ditemukan
        }
    }   

    public Buku getBukuById(String id){
        for(Buku bk : listBuku){
            if(bk.getId() == id)
                return bk;
        }
        return null; //Jika tidak ditemukan
    }

    public String getId(){
        return idPeminjaman;
    }

    public Date getTanggalKembali(){
        return tanggalKembali;
    }

    public Date getTanggalPengembalian(){
        return tanggalPengembalian;
    }

    public Date getTanggalPinjam(){
        return tanggalPinjam;
    }

    public boolean getStatus(){
        return statusPeminjaman;
    }

    public int getSisaPinjam(){
        return maxPinjam - listBuku.size();
    }

    public double getBiayaDenda(){
        return biayaDenda;
    }

    public void setTanggalPinjam(Date tanggalPinjam){
        this.tanggalPinjam = tanggalPinjam;
    }

    public void setTanggalKembali(Date tanggalKembali){
        this.tanggalKembali = tanggalKembali;
    }

    public void setTanggalPengembalian(Date tanggalPengembalian){
        this.tanggalPengembalian = tanggalPengembalian;
    }

    public void setStatusPeminjaman(boolean statusPeminjaman){
        this.statusPeminjaman = statusPeminjaman;
    }

    public void setId(String IdPeminjaman){
        this.idPeminjaman = IdPeminjaman;
    }

    public void setBiayaDenda(double biayaDenda){
        this.biayaDenda = biayaDenda;
    }

    public int getMaxPinjam() {
        return maxPinjam;
    }

    public void hitungDenda(long nominal){
        //Reserved buat hitung biayaDenda
        if(tanggalPengembalian.after(tanggalKembali)) {
            double BiayaDenda;
            BiayaDenda = ((tanggalPengembalian.getTime()-tanggalKembali.getTime())*nominal);
            this.setBiayaDenda(biayaDenda);
        } else {
            this.setBiayaDenda(0);
        }
    }
    
    public int totalbuku(){
        return listBuku.size();
    }
}