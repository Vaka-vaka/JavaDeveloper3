/**
 * Module 5. HTTP
 *
 * @autor Valentin Mozul
 * @version of 18.11.2021
 */

package ua.goit.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.OutputStream;

abstract public class AbstractHandler implements HttpHandler {

        public static final Logger LOGGER = LogManager.getLogger(AbstractHandler.class);

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

    protected void handleResponse(HttpExchange exchange) {
        String body = getTempLate();
        try(OutputStream outputStream = exchange.getResponseBody()) {
            exchange.sendResponseHeaders(200, body.length());
            outputStream.write(body.getBytes());
        } catch (IOException e) {
            LOGGER.error("Error while sending response.", e);
        }
    }

}
