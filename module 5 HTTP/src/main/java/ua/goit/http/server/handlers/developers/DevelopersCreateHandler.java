/**
 * Module 5. HTTP
 *
 * @autor Valentin Mozul
 * @version of 24.11.2021
 */

package ua.goit.http.server.handlers.developers;

import com.sun.net.httpserver.HttpExchange;
import ua.goit.http.server.handlers.AbstractHandler;
import ua.goit.http.server.service.DevelopersService;
import ua.goit.model.Developers;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class DevelopersCreateHandler extends AbstractHandler {

    private static final DevelopersService developersService = DevelopersService.getInstance();

    @Override
    protected String getTempLateName() {
        return "developersView";
    }

    @Override
    protected void get(HttpExchange exchange){
        handleResponse(exchange, Collections.emptyMap());
    }

    @Override
    protected void post(HttpExchange exchange) {
       try (InputStream inputStream = exchange.getRequestBody();
           Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name())) {
           String next = scanner.next();
           System.out.println(next);
       } catch (IOException e) {
           e.printStackTrace();
       }
    }
}
