import java.io.FileReader;

public class CreateNewFile {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("newfile.txt");
            System.out.println("File opened successfully.");
            fr.close();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}