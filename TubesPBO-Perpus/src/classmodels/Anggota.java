package classmodels;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fachri Ul
 */
public class Anggota extends Orang {
    private ArrayList<Peminjaman> riwayatPeminjaman = new ArrayList();
    private String idAnggota;
    private String tanggalPendaftaran;
    
    // CONSTRUCTOR
    public Anggota( String idAnggota, String name){
        super(name);
        this.idAnggota = idAnggota;
    }
    
    // METHOD
    public void createPinjaman(Date tanggal, String idPinjam, int maxPinjam){
        Peminjaman pjm = null;
        try {
            pjm = new Peminjaman(idPinjam, tanggal, maxPinjam);
        } catch (ParseException ex) {
            Logger.getLogger(Anggota.class.getName()).log(Level.SEVERE, null, ex);
        }
        riwayatPeminjaman.add(pjm);
    }
    
    public void pengembalianPinjaman(String id, Date tanggal){
        for(Peminjaman pjm : riwayatPeminjaman){
                if(pjm.getIdPeminjaman() == id)
                    pjm.setTanggalPengembalian(tanggal);
                    pjm.setStatusPeminjaman(false);
            }
        // status peminjaman flase;z
    }
    
    public Peminjaman getPinjaman(int id) {
        return riwayatPeminjaman.get(id);
    }
    
    public String getTanggalPendaftaran(){
        return tanggalPendaftaran;
    }
    
    public String idAnggota(){
        return idAnggota;
    }
}
