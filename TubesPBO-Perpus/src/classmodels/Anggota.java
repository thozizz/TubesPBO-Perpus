package classmodels;

import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author Fachri Ul
 */
public class Anggota extends Orang {
    private ArrayList<Peminjaman> riwayatPeminjaman = new ArrayList();
    private String idAnggota;
    private String tanggalPendaftaran;
    
    // CONSTRUCTOR
    public Anggota(String idAnggota, String name){
        super(name);
        this.idAnggota = idAnggota;
    }
    
    // METHOD
    public void createPinjaman(Date tanggal, String idPinjam, int maxPinjam){
        Peminjaman pjm;
        //Object created di dalam method (komposisi)
        pjm = new Peminjaman(idPinjam, tanggal, maxPinjam);
        riwayatPeminjaman.add(pjm);
    }
    
    public void pengembalianPinjaman(String idPinjaman, Date tanggalPengembalian){
        for(Peminjaman pjm : riwayatPeminjaman){
            if(pjm.getIdPeminjaman().equals(idPinjaman)){
                pjm.setTanggalPengembalian(tanggalPengembalian);
                pjm.setStatusPeminjaman(false);
                // Disini ditambah logic hitung denda
                //if tanggalPemngebalian.after(pjm.getTanggalKembli())
                //kalo gak salah methodnya after
                //pjm.hitungDenda()
            }
        }
    }
    
    public Peminjaman getPinjamanByIndex(int idx) {
        return riwayatPeminjaman.get(idx);
    }
    
//    public Peminjaman getPinjamanById(int id){
//        //Logic Here;
//    }
    
    public String getTanggalPendaftaran(){
        return tanggalPendaftaran;
    }
    
    public String idAnggota(){
        return idAnggota;
    }
    
}
