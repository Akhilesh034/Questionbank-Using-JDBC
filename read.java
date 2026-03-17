import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class read {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/Quiz";
        String user = "root";
        String pass = "Kanha@123";
        try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con = DriverManager.getConnection(url, user, pass);
        //  String readSql = "SELECT * FROM students";
            PreparedStatement ps = con.prepareStatement("SELECT * FROM QB_Table");
            ResultSet rs = ps.executeQuery();

            // System.out.println("\ns.no.| movie | genre | ratings | status");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("S_No")+ " | " +
                        rs.getString("OPtion_A")+" | " +
                        rs.getString("Option_B")+" | " +
                        rs.getString("Option_C")+" | " +
                        rs.getString("Option_D")+" | " +
                        rs.getString("Answer")
                );
            }
    }catch (Exception e) {
            e.printStackTrace();
        }
    
}
}