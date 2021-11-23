

package ua.goit.server.handlers;

import com.sun.net.httpserver.HttpExchange;

import java.util.Map;

public class DevelopersHandler extends AbstractHandler {

    @Override
    String getTempLateName() {
        return "Developers";
    }

    @Override
    protected void get(HttpExchange exchange){
        handleResponse(exchange, Map.of(
                "usersName", "Valera",
                "usersDetail", "Kurochkin"
        ));
    }
}
