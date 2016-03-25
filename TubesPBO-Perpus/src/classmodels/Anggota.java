package classmodels;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Thoriq & DedeKiswanto
 * Ket : 1. PengembalianHitungDenda
 */

public class Anggota extends Orang {
    //CLASS VARIABLE
    private ArrayList<Peminjaman> riwayatPeminjaman = new ArrayList();
    private String idAnggota;
    private String tanggalPendaftaran;
    
    // CONSTRUCTOR
    public Anggota(String idAnggota, String name){
        super(name);
        this.idAnggota = idAnggota;
    }
    
    public Anggota(String idAnggota, String name, String tanggalPendaftaran){
        super(name);
        this.idAnggota = idAnggota;
        this.tanggalPendaftaran = tanggalPendaftaran;
    }
    
    // METHOD
    public void createPeminjaman(Date tanggal, String idPinjam, int maxPinjam){
        Peminjaman pjm;
        //Object created di dalam method (komposisi)
        pjm = new Peminjaman(idPinjam, tanggal, maxPinjam);
        //Insert it to array list
        riwayatPeminjaman.add(pjm);
    }
    //new 
    public void kembaliPeminjaman(String idPinjaman, Date tanggalKembali){
        for(Peminjaman pjm : riwayatPeminjaman){
            if(pjm.getId().equals(idPinjaman)){
                pjm.setTanggalPengembalian(tanggalKembali);}}
    }
    public void pengembalianPeminjaman(String idPinjaman, Date tanggalPengembalian){
        for(Peminjaman pjm : riwayatPeminjaman){
            if(pjm.getId().equals(idPinjaman)){
                pjm.setTanggalPengembalian(tanggalPengembalian);
                pjm.setStatusPeminjaman(false);
                
                //Mengembalikan Stock
                for (int i = 0; i < pjm.totalbuku(); i++) {
                    pjm.getBukuByIndex(i).tambahSiSaBuku();
                }
                
                pjm.hitungDenda(3000);
                System.out.println("Denda : "+pjm.getBiayaDenda());
            }
        }
    }
    
    public Peminjaman getPeminjamanByIndex(int idx) {
        try {
            return riwayatPeminjaman.get(idx);
        } catch (Exception e) {
            return null; //Jika tidak ditemukan; indexoutofbonds
        }
    }
    
    public Peminjaman getPeminjamanById(String idPeminjaman){
        for(Peminjaman pjm : riwayatPeminjaman){
            if(pjm.getId().equals(idPeminjaman))
                return pjm;
        }
        return null; //Jika tidak ditemukan
    }
    
    public String getTanggalPendaftaran(){
        return tanggalPendaftaran;
    }
    
    public String getId(){
        return idAnggota;
    }
    
    public void setId(String idAnggota){
        this.idAnggota = idAnggota;
    }
    
    public int totalPeminjaman() {
        return riwayatPeminjaman.size();
    }
    
    public void getAllPeminjaman(){
        for(int i=0;i<riwayatPeminjaman.size();i++){
            System.out.println("ID :"+riwayatPeminjaman.get(i).getId());
            System.out.println("Tanggal Pinjam :"+riwayatPeminjaman.get(i).getTanggalPinjam());
            System.out.println("Tanggal Kembali"+riwayatPeminjaman.get(i).getTanggalKembali());
            if(riwayatPeminjaman.get(i).getTanggalPengembalian() != null){
                System.out.println("Tanggal Pengembalian :"+riwayatPeminjaman.get(i).getTanggalPengembalian());
            }
            System.out.println();
        }
    }
    
}