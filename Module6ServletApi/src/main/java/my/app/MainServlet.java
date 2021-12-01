/**
 * Module 5. HTTP
 *
 * @autor Valentin Mozul
 * @version of 01.12.2021
 */

package my.app;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        try (PrintWriter writer = resp.getWriter()) {
            writer.println("<h2>Welcome to YOU</h2>");
        }
    }

}
