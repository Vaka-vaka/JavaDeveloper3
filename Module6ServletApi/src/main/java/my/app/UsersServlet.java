/**
 * Module 5. HTTP
 *
 * @autor Valentin Mozul
 * @version of 01.12.2021
 */

package my.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("111111111");
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse rest) throws IOException {
        users(rest);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        users(resp);
    }

    private void users(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        try (PrintWriter writer = response.getWriter()) {
            writer.println("<h2>Welcome User</h2>");
        }
    }
}