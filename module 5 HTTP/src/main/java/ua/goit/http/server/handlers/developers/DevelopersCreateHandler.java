/**
 * Module 5. HTTP
 *
 * @autor Valentin Mozul
 * @version of 24.11.2021
 */

package ua.goit.http.server.handlers.developers;

import com.sun.net.httpserver.HttpExchange;
import ua.goit.http.server.dto.DevelopersDto;
import ua.goit.http.server.handlers.AbstractHandler;
import ua.goit.http.server.service.DevelopersService;
import ua.goit.model.Developers;

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
          getRequestBody(exchange, DevelopersDto.class)
                  .ifPresent(developersDto -> {
                      Developers developers = new Developers();
                      developers.setId(developersDto.getId());
                      developers.setName_(developersDto.getName_());
                      developers.setAge(developersDto.getAge());
                      developers.setGender(developersDto.getGender());
                      developers.setSalary(developersDto.getSalary());
                      developersService.create(developers);
                  });
    }
}
