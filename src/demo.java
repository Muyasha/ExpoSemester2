import java.util.ArrayList;

public class demo {
    public static void main(String[] args) {
        ArrayList<ModelUser> dataUser = new CSVReader()
                .readCSVFile("C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataLogin.csv");
        CSVWriter writer = new CSVWriter();

        for (int i = 0; i < dataUser.size(); i++) {
            String email = dataUser.get(i).getEmail();
            int saldo = dataUser.get(i).getSaldo();

            if (email.equals("email")) {
                dataUser.get(i).setSaldo(200);
                writer.simpanData(dataUser, "C://Kuliah//Semester 2//FPA//THRIFTSHOP//Aplikasi//src//dataLogin.csv");
            }
        }
    }
}
