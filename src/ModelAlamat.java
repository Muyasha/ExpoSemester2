public class ModelAlamat {
    private int nomor;
    private String email;
    private String alamat;

    public ModelAlamat(int nomor, String alamat) {
        this.nomor = nomor;
        this.alamat = alamat;
    }

    public ModelAlamat(String email, int nomor, String alamat) {
        this.nomor = nomor;
        this.email = email;
        this.alamat = alamat;
    }

    public ModelAlamat() {
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

    public int getNomor() {
        return nomor;
    }

    public void setNomor(int nomor) {
        this.nomor = nomor;
    }

    public int indexOf(int angka) {
        return 0;
    }

}
