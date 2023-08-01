public class ModelKonfirmasiPembelian {
    private String emailPembeli;
    private String namaBarang;
    private String hargaAsli;
    private String hargaNego;
    private int jumlahBeliBarang;
    private int biayaBayar;
    private String metodeBayar;
    private String emailPenjual;

    public ModelKonfirmasiPembelian() {
    }

    public ModelKonfirmasiPembelian(String emailPembeli, String namaBarang, String hargaAsli, String hargaNego,
            int jumlahBeliBarang, int biayaBayar, String metodeBayar, String emailPenjual) {
        this.emailPembeli = emailPembeli;
        this.namaBarang = namaBarang;
        this.hargaAsli = hargaAsli;
        this.hargaNego = hargaNego;
        this.jumlahBeliBarang = jumlahBeliBarang;
        this.biayaBayar = biayaBayar;
        this.metodeBayar = metodeBayar;
        this.emailPenjual = emailPenjual;
    }

    public String getEmailPembeli() {
        return emailPembeli;
    }

    public void setEmailPembeli(String emailPembeli) {
        this.emailPembeli = emailPembeli;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getHargaAsli() {
        return hargaAsli;
    }

    public void setHargaAsli(String hargaAsli) {
        this.hargaAsli = hargaAsli;
    }

    public String getHargaNego() {
        return hargaNego;
    }

    public void setHargaNego(String hargaNego) {
        this.hargaNego = hargaNego;
    }

    public int getJumlahBeliBarang() {
        return jumlahBeliBarang;
    }

    public void setJumlahBeliBarang(int jumlahBeliBarang) {
        this.jumlahBeliBarang = jumlahBeliBarang;
    }

    public int getBiayaBayar() {
        return biayaBayar;
    }

    public void setBiayaBayar(int biayaBayar) {
        this.biayaBayar = biayaBayar;
    }

    public String getMetodeBayar() {
        return metodeBayar;
    }

    public void setMetodeBayar(String metodeBayar) {
        this.metodeBayar = metodeBayar;
    }

    public String getEmailPenjual() {
        return emailPenjual;
    }

    public void setEmailPenjual(String emailPenjual) {
        this.emailPenjual = emailPenjual;
    }

    @Override
    public String toString() {
        return "ModelKonfirmasiPembelian [emailPembeli=" + emailPembeli + ", namaBarang=" + namaBarang + ", hargaAsli="
                + hargaAsli + ", hargaNego=" + hargaNego + ", jumlahBeliBarang=" + jumlahBeliBarang + ", biayaBayar="
                + biayaBayar + ", metodeBayar=" + metodeBayar + ", emailPenjual=" + emailPenjual + "]";
    }

}
