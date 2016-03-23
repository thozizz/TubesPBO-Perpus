/*
 * Class Petugas
 * Ket : Tested!!!!!!! 
 */
package classmodels;

import java.util.Date;

/**
 *
 * @author kiswanto-d
 */
public class Petugas extends Orang{
    
    private String idPetugas;
    
    public Petugas(String idPetugas, String nama) {
        super(nama);
        this.idPetugas = idPetugas;
    }
    
    public void addPinjamanAnggota(Anggota a, String idPinjaman, int maxPinjaman){
        Date now = new Date();
        a.createPeminjaman(now, idPinjaman, maxPinjaman);
    }
    
    //new
    public void kembaliPinjamanAnggota(Anggota a, String idPinjaman, Date tanggalkembali){
        a.kembaliPeminjaman(idPinjaman, tanggalkembali);
    }
    
    public void pengembalianPinjamanAnggota(Anggota a, String idPinjaman, Date tanggalPengembalian){
        a.pengembalianPeminjaman(idPinjaman, tanggalPengembalian);
    }
    
    public void changeStatusPinjaman(Peminjaman pjm, boolean status){
        pjm.setStatusPeminjaman(status);
    }
    
    public void addBarangPinjaman(Peminjaman pjm, Buku buku){
        pjm.addBuku(buku);
    }
    
    public void removeBarangPinjaman(Peminjaman pjm, String idBuku){
        Buku buku = pjm.getBukuById(idBuku);
        pjm.removeBukuByObject(buku); //Method ini belum ditulis di dalam ClassDiagram
    }
    
    public boolean cekStatusPinjaman(Peminjaman pjm){
        return pjm.getStatus();
    }
    
    public String getId(){
        return idPetugas;
    }
    
}