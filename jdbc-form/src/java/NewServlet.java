import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NewServlet")
public class NewServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String movie = request.getParameter("movie");
        String theatre = request.getParameter("theatre");
        String date = request.getParameter("date");
        String show = request.getParameter("show");
        String tickets = request.getParameter("tickets");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/moviebooking?useSSL=false",
                    "root",
                    "test@123"
            );
            PreparedStatement ps = con.prepareStatement(
                    "insert into bookings "
                    + "(name, email, phone, movie, theatre, movie_date, show_time, tickets) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?)"
            );

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, movie);
            ps.setString(5, theatre);
            ps.setString(6, date);
            ps.setString(7, show);
            ps.setString(8, tickets);
            ps.executeUpdate();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(
                    "select * from bookings"
            );

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Movie Booking</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 align='center'>Ticket Booking Successful</h1>");
            out.println("<h2 align='center'>Booking Records</h2>");
            out.println("<table border='1' cellpadding='10' align='center'>");
            out.println("<tr>");
            out.println("<th>ID</th>");
            out.println("<th>Name</th>");
            out.println("<th>Email</th>");
            out.println("<th>Phone</th>");
            out.println("<th>Movie</th>");
            out.println("<th>Theatre</th>");
            out.println("<th>Date</th>");
            out.println("<th>Show Time</th>");
            out.println("<th>Tickets</th>");
            out.println("</tr>");

            while (rs.next()) {

                out.println("<tr>");

                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getString("email") + "</td>");
                out.println("<td>" + rs.getString("phone") + "</td>");
                out.println("<td>" + rs.getString("movie") + "</td>");
                out.println("<td>" + rs.getString("theatre") + "</td>");
                out.println("<td>" + rs.getString("movie_date") + "</td>");
                out.println("<td>" + rs.getString("show_time") + "</td>");
                out.println("<td>" + rs.getInt("tickets") + "</td>");

                out.println("</tr>");
            }

            out.println("</table>");

            out.println("</body>");
            out.println("</html>");

            rs.close();
            st.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            out.println("<html>");
            out.println("<body>");

            out.println("<h2>Error</h2>");
            out.println("<p>" + e + "</p>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("index.html");
    }
}
