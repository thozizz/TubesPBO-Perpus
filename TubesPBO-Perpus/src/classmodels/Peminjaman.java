package classmodels;

//Keterangan : 
// Yang belum date semua;
// 

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Peminjaman{
	private ArrayList<Buku> listBuku = new ArrayList();
	private String idPeminjaman;
	private Date tanggalPinjam;
	private Date tanggalKembali;
	private Date tanggalPengembalian;
	private boolean statusPeminjaman = true;
	private double denda;
	private int maxPinjam;
        //Buat Format Date

        
        // CONSTRUCTOR //
	public Peminjaman(String IdPeminjaman, Date tanggalPinjam, int maxPinjam){
            this.idPeminjaman = IdPeminjaman;
            this.maxPinjam = maxPinjam;
            this.tanggalPinjam = tanggalPinjam;
	}
	
        // CLASS METHOD //
        public void addBuku(Buku b){
//            if(getSisaPinjam() >= 0){
//            System.out.print(b.getJudul());
            b.kurangSisaBuku();
                listBuku.add(b);
//            } else {
//                System.out.println("Peminjaman Penuh");
//            }
            // Belum dikasih else
	}
	
        
	public void removeBuku(Buku b){
            if(listBuku.size() > 0){    
                listBuku.remove(b);
            }else{
                System.out.println("Tidak ada buku yang dipinjam");
            }
	}
        
        public Buku getBukuByIndex(int idx){
            return listBuku.get(idx);
	}
            
	public Buku getBukuById(String id){
            for(Buku bk : listBuku){
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
            return maxPinjam - listBuku.size();
	}
	
	public double getDenda(){
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
        
        public void setDenda(double denda){
            this.denda = denda;
        }

        public int getMaxPinjam() {
            return maxPinjam;
        }
        
        public void hitungDenda(long nominal){
            //Reserved buat hitung denda
//            simpan ke
//            this.setDenda(denda);
        }
        
}