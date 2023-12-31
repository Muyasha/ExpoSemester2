public class ModelPembelian {
    private String email;
    private String identitas;
    private String namaBarang;
    private String biayaPembelian;
    private String jumlahBeliBarang;
    private String asalBarang;
    private String metodeBayar;

    


    public ModelPembelian() {
    }

    public ModelPembelian(String email, String iD, String namaBarang, String biayaPembelian, String jumlahBeliBarang,
            String asalBarang, String metodeBayar) {
        this.email = email;
        this.identitas = iD;
        this.namaBarang = namaBarang;
        this.biayaPembelian = biayaPembelian;
        this.jumlahBeliBarang = jumlahBeliBarang;
        this.asalBarang = asalBarang;
        this.metodeBayar = metodeBayar;
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
        return "ModelPembelian [email=" + email + ", identitas=" + identitas + ", namaBarang=" + namaBarang
                + ", biayaPembelian=" + biayaPembelian + ", jumlahBeliBarang=" + jumlahBeliBarang + ", asalBarang="
                + asalBarang + ", metodeBayar=" + metodeBayar + "]";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMetodeBayar() {
        return metodeBayar;
    }

    public void setMetodeBayar(String metodeBayar) {
        this.metodeBayar = metodeBayar;
    }

    public String getIdentitas() {
        return identitas;
    }

    public void setIdentitas(String identitas) {
        this.identitas = identitas;
    }

}
