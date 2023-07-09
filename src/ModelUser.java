public class ModelUser {
    private String email;
    private String username;
    private String noHP;
    private String password;
    private int saldo;

    // Constructor
    public ModelUser() {
    }

    public ModelUser(String email, String username, String noHP, String password,int saldo) {
        this.email = email;
        this.username = username;
        this.noHP = noHP;
        this.password = password;
        this.saldo = saldo;
    }

    // Setter dan getter

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ModelUser [email=" + email + ", username=" + username + ", noHP=" + noHP + ", password=" + password
                + "]";
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

}
