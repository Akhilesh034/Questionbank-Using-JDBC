import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class insert {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Quiz";
        String user = "root";
        String pass = "Akhilesh@034";
        String sql = "INSERT INTO QB_table " +
             "(S_no,Questions, Option_A, Option_B, Option_C, Option_D, Answer) " +
             "VALUES (?, ?, ?, ?, ?, ?, ?)";

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter how many Question you want to enter: ");
        int n = sc.nextInt();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps = con.prepareStatement(sql);
            for (int i = 1; i <= n; i++) {
            System.out.print("Enter Serial Number: ");
            int sno = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter a question : ");
            String ques = sc.nextLine();
            System.out.print("Option A : ");
            String opta = sc.nextLine();

            System.out.print("Option B : ");
            String optb = sc.nextLine();

             System.out.print("Option C : ");
            String optc = sc.nextLine();

            System.out.print("Option D : ");
            String optd = sc.nextLine();

            System.out.print("Chosse Correct Answer A/B/C/D: ");
            String ans = sc.next().toUpperCase();
           
            ps.setInt(1, sno);
            ps.setString(2, ques);
            ps.setString(3, opta);
            ps.setString(4, optb);
            ps.setString(5, optc);
            ps.setString(6, optd);
            ps.setString(7, ans);
            ps.executeUpdate();
            System.out.println("Question inserted successfully ");
            }
            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}













