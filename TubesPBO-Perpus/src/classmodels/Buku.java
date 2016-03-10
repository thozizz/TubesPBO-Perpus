package classmodels;

/**
 *
 * @author ASYNC
 */

public class Buku {
    private String idBuku;
    private String ISBN;
    private String penulis;
    private String penerbit;
    private String judul;
    private int stockBuku;
    private int sisaBuku;
    

    public Buku(String idBuku, String judul) {
        this.idBuku = idBuku;
        this.judul = judul;
    }
    
    public Buku(String idBuku, String judul, String penulis) {
        this.idBuku = idBuku;
        this.judul = judul;
        this.penulis = penulis;
    }
    
    public String getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(String idBuku) {
        this.idBuku = idBuku;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public int getStockBuku() {
        return stockBuku;
    }

    public void setStockBuku(int stockBuku) {
        this.stockBuku = stockBuku;
    }

    public int getSisaBuku() {
        return sisaBuku;
    }

    public void setSisaBuku(int sisaBuku) {
        this.sisaBuku = sisaBuku;
    }
    
    public void kurangSisaBuku(){
        sisaBuku--;
    }
    
    public void tambahSiSaBuku(){
        sisaBuku++;
    }
    
}
