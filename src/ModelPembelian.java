public class ModelPembelian {
    private String iD;
    private String namaBarang;
    private String biayaPembelian;
    private String jumlahBeliBarang;
    private String asalBarang;

    public ModelPembelian() {
    }

    public ModelPembelian(String iD, String namaBarang, String biayaPembelian, String jumlahBeliBarang,
            String asalBarang) {
        this.iD = iD;
        this.namaBarang = namaBarang;
        this.biayaPembelian = biayaPembelian;
        this.jumlahBeliBarang = jumlahBeliBarang;
        this.asalBarang = asalBarang;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getBiayaPembelian() {
        return biayaPembelian;
    }

    public void setBiayaPembelian(String biayaPembelian) {
        this.biayaPembelian = biayaPembelian;
    }

    public String getJumlahBeliBarang() {
        return jumlahBeliBarang;
    }

    public void setJumlahBeliBarang(String jumlahBeliBarang) {
        this.jumlahBeliBarang = jumlahBeliBarang;
    }

    public String getAsalBarang() {
        return asalBarang;
    }

    public void setAsalBarang(String asalBarang) {
        this.asalBarang = asalBarang;
    }

    @Override
    public String toString() {
        return "ModelPembelian [iD=" + iD + ", namaBarang=" + namaBarang + ", biayaPembelian=" + biayaPembelian
                + ", jumlahBeliBarang=" + jumlahBeliBarang + ", asalBarang=" + asalBarang + "]";
    }

}
