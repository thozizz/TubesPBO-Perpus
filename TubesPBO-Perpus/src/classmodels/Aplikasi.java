/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classmodels;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Async
 */
public class Aplikasi {
    private ArrayList<Anggota> DaftarAnggota = new ArrayList();
    
    public void addAnggota(String idAnggota, String name){
        Anggota a = new Anggota(idAnggota, name);
        DaftarAnggota.add(a);
    }
    
    public Anggota getAnggotaById(String id){
        for(Anggota a: DaftarAnggota){
            if (a.getId().equals(id)){
                return a;
            }
        }
        return null;
    }
    
    public Anggota getAnggotaByIndex(int idx){
        try {
            return DaftarAnggota.get(idx);
        } catch (Exception e) {
            return null;
        }
    }
    
    public void DeleteAnggotaById(String id){
        for(Anggota a: DaftarAnggota){
            if(a.getId().equals(id)){
                DaftarAnggota.remove(a);
                break;
            }
        }
    }
    
    void AnggotaRegistrasi(){
        Scanner inp = new Scanner(System.in);
        System.out.print("ID anggota :");
        String id = inp.nextLine();
        System.out.print("Nama  :");
        String nama = inp.nextLine();
 //       System.out.print("Tanggal Pendaftaran :");
 //       String tgl = inp.nextLine();
        addAnggota(id,nama);
    }
    
    void listPinjaman(){
        System.out.print("Masukan ID anggota:");
        Scanner inp = new Scanner(System.in);
        String id = inp.nextLine();
        Anggota a = getAnggotaById(id);
        a.getAllPeminjaman();
    }
    
    void listPeminjamanDetail(){
        
        System.out.print("Masukan ID anggota:");
        Scanner inp = new Scanner(System.in);
        String id = inp.nextLine();
        Anggota a = getAnggotaById(id);
        Peminjaman pjm = a.getPeminjamanById(id);
        System.out.println("ID :"+pjm.getId());
        System.out.println("Tanggal Pinjam :"+pjm.getTanggalPinjam());
        System.out.println("Tanggal Kembali"+pjm.getTanggalKembali());
            if(pjm.getTanggalPengembalian() != null){
                System.out.println("Tanggal Pengembalian :"+pjm.getTanggalPengembalian());
                pjm.hitungDenda(1000);
                System.out.println("Denda :"+pjm.getBiayaDenda());
            }
        System.out.println();
    }
}
