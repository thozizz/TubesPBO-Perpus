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
    
    public void pengembalianPeminjaman(String idPinjaman, Date tanggalPengembalian){
        for(Peminjaman pjm : riwayatPeminjaman){
            if(pjm.getId().equals(idPinjaman)){
                pjm.setTanggalPengembalian(tanggalPengembalian);
                pjm.setStatusPeminjaman(false);
                
                //Mengembalikan Stock
                for (int i = 0; i < pjm.totalbuku(); i++) {
                    pjm.getBukuByIndex(i).tambahSiSaBuku();
                }
                
                // Disini ditambah logic hitung denda
                //if tanggalPemngebalian.after(pjm.getTanggalKembli())
                //kalo gak salah methodnya after
                //pjm.hitungDenda()
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
    
}