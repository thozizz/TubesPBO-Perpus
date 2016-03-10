package classmodels;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

/**
 *
 * @author g40
 */
public class MainTest {
    

    public static void main(String[] args) throws ParseException {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        
        // CLASS [BUKU] TESTING CASE
        // Instantiate Object Buku
        Buku buku1 = new Buku("IDB1", "Antara Aku dan Dia");
        Buku buku2 = new Buku("IDB2", "Kekasihku yang telah tiada", 
                "Budi Rahardjo");
        
        buku1.setSisaBuku(10);
        
        // CLASS [ANGGOTA] TESTING CASE
        // Instantiate Object Anggota
        Anggota anggota1 = new Anggota("IDA1", "Andrew Darwis");
        int maxPinjam;
        
        // Anggota Create Pinjaman 
        try {
           date = dateFormat.parse("02-02-2016");
        } catch (Exception e) {
           System.out.println("error at parsing");
        }
        
        anggota1.createPinjaman(date, "IDP1", 5);
        System.out.println("Status Sebelum : " + anggota1.getPinjamanByIndex(0).getStatus());
        
        try {
           date = dateFormat.parse("10-02-2016");
        } catch (Exception e) {
           System.out.println("error at parsing");
        }
        
        
        anggota1.pengembalianPinjaman("IDP1", date);
        
        System.out.println("Status Sebelum : " + anggota1.getPinjamanByIndex(0).getStatus());
       
        System.out.println(buku1.getSisaBuku());
        
        anggota1.getPinjamanByIndex(0).addBuku(buku1);
        
        System.out.println(buku1.getSisaBuku());
        
        HashSet hs = new HashSet();
    }
    
}
