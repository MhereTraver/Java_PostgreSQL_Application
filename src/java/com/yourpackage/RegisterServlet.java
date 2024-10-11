/*
 @author Mhere
 */
package com.yourpackage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("txtUsername");
        String name = request.getParameter("txtName");
        String surname = request.getParameter("txtSurname");
        String email = request.getParameter("txtEmail");
        String phone = request.getParameter("txtPhone");
        String password = request.getParameter("txtPassword");

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LibraryManagementSystemDB", "postgres", "12345");
            
            PreparedStatement psCheck = con.prepareStatement("SELECT * FROM Registration WHERE username = ? OR email = ?");
            psCheck.setString(1, username);
            psCheck.setString(2, email);
            if (psCheck.executeQuery().next()) {
                response.getWriter().write("Username or Email already taken");
                return;
            }
            
            PreparedStatement ps = con.prepareStatement("INSERT INTO Registration(username, name, surname, email, phone, password) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, username);
            ps.setString(2, name);
            ps.setString(3, surname);
            ps.setString(4, email);
            ps.setString(5, phone);
            ps.setString(6, password);
            ps.executeUpdate();
            
            
            String insertLoginQuery = "INSERT INTO Login(username, password) VALUES (?, ?)";
            ps = con.prepareStatement(insertLoginQuery);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
            
            response.getWriter().write("Registration Successful");
            response.sendRedirect("login.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Registration failed: " + e.getMessage());
        }
    }
}
