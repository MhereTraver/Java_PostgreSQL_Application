/*
 @author mhere
 */

package com.yourpackage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");

        try {
            // JDBC connection to PostgreSQL
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LibraryManagementSystemDB", "postgres", "12345");
            
            // Validate credentials
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Login WHERE username = ? AND password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("txtUsername", username);
                response.sendRedirect("welcome.jsp");
            } else {
                response.getWriter().write("Invalid credentials");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Login failed: " + e.getMessage());
        }
    }
}
