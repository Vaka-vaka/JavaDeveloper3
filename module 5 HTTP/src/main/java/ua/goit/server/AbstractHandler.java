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

abstract public class AbstractHandler implements HttpHandler {

    private TemplateHandler templateHandler = TemplateHandler.getInstance();

    abstract String getTempLateName();
    protected void get(HttpExchange exchange){};
    protected void post(HttpExchange exchange) {};

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        switch (exchange.getRequestMethod()) {
            case "GET" : get(exchange);break;
            case "POST": post(exchange);break;
        }
    }

    protected String getTempLate() {
        return templateHandler.getTempLate(getTempLateName());
    }

    protected void handleResponse(HttpExchange exchange) throws IOException {
        OutputStream outputStream = exchange.getResponseBody();
        exchange.sendResponseHeaders(200, index.length());
        outputStream.write(index.getBytes());
        outputStream.close();
    }


}
