/*
 * Class Petugas
 * 
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
        a.createPinjaman(now, idPinjaman, maxPinjaman);
    }
    
    public void removePinjamanAnggota(Anggota a, String idPinjaman, Date tanggalPengembalian){
        a.pengembalianPinjaman(idPinjaman, tanggalPengembalian);
    }
    
    public void changeStatusPinjaman(Peminjaman pjm, boolean status){
        pjm.setStatusPeminjaman(status);
    }
    
    public void addBarangPinjaman(Peminjaman pjm, Buku buku){
        pjm.addBuku(buku);
    }
    
    public void removeBarangPinjaman(Peminjaman pjm, String idBuku, String judul){
        Buku b = new Buku(idBuku, judul);
        pjm.removeBuku(b); //Method ini belum ditulis di dalam ClassDiagram
    }
    
    public boolean cekStatusPinjaman(Peminjaman pjm){
        return pjm.getStatus();
    }
    
}