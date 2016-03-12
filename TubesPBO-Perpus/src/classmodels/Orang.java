package classmodels;

/*
 * @author ThoriqAbdulAzizz
 * Keterangan : OKE!! + TESTED!!
 */

public abstract class Orang {

    private String nama;
    private String tanggalLahir;
    private String alamat;
    private double noHandphone;
    private String idIdentitas;
    private String jenisKelamin;

    public Orang(String nama) {
        this.nama = nama;
    }
    
    public Orang(String nama, String idIdentitas) {
        this.nama = nama;
        this.idIdentitas = idIdentitas;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public double getNoHandphone() {
        return noHandphone;
    }

    public void setNoHandphone(double noHandphone) {
        this.noHandphone = noHandphone;
    }

    public String getIdIdentitas() {
        return idIdentitas;
    }

    public void setIdIdentitas(String idIdentitas) {
        this.idIdentitas = idIdentitas;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
    
}
