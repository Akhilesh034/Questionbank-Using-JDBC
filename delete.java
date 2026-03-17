import java.sql.*;
import java.util.Scanner;

public class delete {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/Quiz";
        String user = "root";
        String pass = "Kanha@123";

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the s.no of the question to delete:");
        int n = sc.nextInt();

        try {
            Connection con = DriverManager.getConnection(url, user, pass);

            String sql = "DELETE FROM QB_Table WHERE S_No = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, n);

            ps.executeUpdate();
            System.out.println("Deleted successfully");
           

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}