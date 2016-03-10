package classmodels;

//Keterangan : 
// Yang belum date semua;
// 

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Peminjaman{
	private ArrayList<Buku> pinjaman = new ArrayList();
	private String idPeminjaman;
	private Date tanggalPinjam;
	private Date tanggalKembali;
	private Date tanggalPengembalian;
	private boolean statusPeminjaman = true;
	private double denda;
	private int maxPinjam;
        
        //Buat Forma Date

	
        // CONSTRUCTOR //
	public Peminjaman(String IdPeminjaman, Date tanggalPinjam, int maxPinjam) throws ParseException{
            this.idPeminjaman = IdPeminjaman;
            this.maxPinjam = maxPinjam;
            this.tanggalPinjam = tanggalPinjam;

	}
	
        // CLASS METHOD //
        public void addBuku(Buku b){
//            if(getSisaPinjam() >= 0){
//            System.out.print(b.getJudul());
            b.kurangSisaBuku();
                pinjaman.add(b);
//            } else {
//                System.out.println("Peminjaman Penuh");
//            }
            // Belum dikasih else
	}
	
        
	public void removeBuku(Buku b){
            if(pinjaman.size() > 0){    
                pinjaman.remove(b);
            }else{
                System.out.println("Tidak ada buku yang dipinjam");
            }
	}
            
	public Buku getBuku(String id){
            for(Buku bk : pinjaman){
                if(bk.getIdBuku() == id)
                    return bk;
            }
            return null;
	}
	
	public String getIdPeminjaman(){
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
            return maxPinjam - pinjaman.size();
	}
	
	public double  getDenda(){
            return denda;
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
	
	public void setIdPeminjaman(String IdPeminjaman){
            this.idPeminjaman = IdPeminjaman;
	}

        public int getMaxPinjam() {
            return maxPinjam;
        }
        
        public void hitungDenda(){
            //Reserved buat hitung denda
        }
        
}