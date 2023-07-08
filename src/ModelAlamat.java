public class ModelAlamat {
    private String email;
    private String alamat;

    public ModelAlamat() {
    }

    public ModelAlamat(String email, String alamat) {
        this.email = email;
        this.alamat = alamat;
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

}
