/**
 * Module 5. HTTP
 *
 * @autor Valentin Mozul
 * @version of 18.11.2021
 */

package ua.goit.server;

import com.sun.net.httpserver.HttpServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.InetSocketAddress;

public class WebServer {

    private static final Logger LOGGER = LogManager.getLogger(WebServer.class);

    public void start() {
        try {
            HttpServer server = HttpServer.create(
                    new InetSocketAddress("localhost", 80), 0);

            server.createContext("/", new IndexHandler());
            server.start();
        } catch (IOException e) {
           LOGGER.error("Problem with starting web server", e);
        }
    }

    public static void main(String[] args) {
//        WebServer server = new WebServer();
//        server.start();

        String index = TemplateHandler.getInstance().getTempLate("index");
        System.out.println(index);
    }

}
