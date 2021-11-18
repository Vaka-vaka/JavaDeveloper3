/**
 * Module 5. HTTP
 *
 * @autor Valentin Mozul
 * @version of 18.11.2021
 */

package ua.goit.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class IndexHandler implements HttpHandler {

    private TemplateHandler templateHandler = TemplateHandler.getInstance();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if("get".equalsIgnoreCase(exchange.getRequestMethod())) {
           handleGet(exchange);
        }

    }

    private void handleGet(HttpExchange exchange) throws IOException {
        OutputStream responseBody = exchange.getResponseBody();
        String index = templateHandler.getTempLate("index");
        responseBody.write(index.getBytes());
        exchange.sendResponseHeaders(200, index.length());
        responseBody.close();
    }
}
