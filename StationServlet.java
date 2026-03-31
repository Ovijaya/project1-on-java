import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class StationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("application/json");
        PrintWriter out = res.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ev_station", "root", "password");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM stations");

            out.print("[");

            while (rs.next()) {
                out.print("{");
                out.print("\"station_name\":\"" + rs.getString("station_name") + "\",");
                out.print("\"location\":\"" + rs.getString("location") + "\",");
                out.print("\"power_usage\":" + rs.getFloat("power_usage") + ",");
                out.print("\"status\":\"" + rs.getString("status") + "\"");
                out.print("},");
            }

            out.print("]");

            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}