import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Station Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Power Used: ");
        int power = sc.nextInt();

        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/charging station", "root", ""
            );

            String query = "INSERT INTO stations (name, power) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setInt(2, power);

            ps.executeUpdate();

            System.out.println("✅ Data Stored in Database!");

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}