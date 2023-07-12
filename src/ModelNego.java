public class ModelNego {
    String emailPengirim;
    int hargaNego;
    String emailPenerima;

    public ModelNego(String emailPengirim, int hargaNego, String emailPenerima) {
        this.emailPengirim = emailPengirim;
        this.hargaNego = hargaNego;
        this.emailPenerima = emailPenerima;
    }

    public ModelNego() {
    }

    public String getEmailPengirim() {
        return emailPengirim;
    }

    public void setEmailPengirim(String emailPengirim) {
        this.emailPengirim = emailPengirim;
    }

    public int getHargaNego() {
        return hargaNego;
    }

    public void setHargaNego(int hargaNego) {
        this.hargaNego = hargaNego;
    }

    public String getEmailPenerima() {
        return emailPenerima;
    }

    public void setEmailPenerima(String emailPenerima) {
        this.emailPenerima = emailPenerima;
    }

    @Override
    public String toString() {
        return "ModelNego [emailPengirim=" + emailPengirim + ", hargaNego=" + hargaNego + ", emailPenerima="
                + emailPenerima + "]";
    }

}
