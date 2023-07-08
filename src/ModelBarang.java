public class ModelBarang {
    // atribut barang
    // private String image= null;
    private int ID;
    private String kategori;
    private String namaBarang;
    private String harga;
    private String stok;
    private String deskripsi;
    private String image;
    private String alamat;

    // constructor
    public ModelBarang() {
    }

    public ModelBarang(int ID, String kategori, String namaBarang, String harga, String stok, String deskripsi,
            String image, String alamat) {
        this.ID = ID;
        this.kategori = kategori;
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.stok = stok;
        this.deskripsi = deskripsi;
        this.image = image;
        this.alamat = alamat;
    }

    // getter dan setter

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getStok() {
        return stok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        this.ID = iD;
    }

    @Override
    public String toString() {
        return "ModelBarang [ID=" + ID + ", kategori=" + kategori + ", namaBarang=" + namaBarang + ", harga=" + harga
                + ", stok=" + stok + ", deskripsi=" + deskripsi + ", image=" + image + "]";
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

}
