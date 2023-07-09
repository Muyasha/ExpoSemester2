public class ModelPenjualan {
    private String email;
    private int ID;
    private String kategori;
    private String namaBarang;
    private String harga;
    private String stok;
    private String deskripsi;
    private String alamat;
    private String image;

    public ModelPenjualan() {
    }

    public ModelPenjualan(String email, int iD, String kategori, String namaBarang, String harga, String stok,
            String deskripsi, String alamat, String image) {
        this.email = email;
        ID = iD;
        this.kategori = kategori;
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.stok = stok;
        this.deskripsi = deskripsi;
        this.alamat = alamat;
        this.image = image;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public String toString() {
        return "ModelPenjualan [email=" + email + ", ID=" + ID + ", kategori=" + kategori + ", namaBarang=" + namaBarang
                + ", harga=" + harga + ", stok=" + stok + ", deskripsi=" + deskripsi + ", image=" + image + "]";
    }

}
