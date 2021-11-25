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

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DevelopersViewHandler extends AbstractHandler {

    private static final DevelopersService developersService = DevelopersService.getInstance();

    @Override
    protected String getTempLateName() {
        return "developersView";
    }

    @Override
    protected void get(HttpExchange exchange){
        Map<String, String> urlParams = getUrlParams(exchange);
        String id = urlParams.get("id");
        if(id == null) {
            throw new RuntimeException("Need id for developers");
        }
        Optional<Developers> developersOptional = developersService.get(Long.parseLong(id));
        developersOptional.map(developers -> {
            Map<String, String> params = new HashMap<>();
            params.put("id", developers.getId().toString());
            params.put("name_", developers.getName_());
            params.put("age", String.valueOf(developers.getAge()));
            params.put("gender", developers.getGender());
            params.put("salary", String.valueOf(developers.getSalary()));
            return params;
        }).ifPresent(params -> {
            handleResponse(exchange, params);
        });
    }
}
