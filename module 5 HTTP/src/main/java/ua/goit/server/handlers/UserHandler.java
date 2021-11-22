/**
 * Module 5. HTTP
 *
 * @autor Valentin Mozul
 * @version of 18.11.2021
 */

package ua.goit.server.handlers;

import com.sun.net.httpserver.HttpExchange;

public class UserHandler extends AbstractHandler {

    @Override
    String getTempLateName() {
        return "users";
    }

    @Override
    protected void get(HttpExchange exchange){
        handleResponse(exchange);
    };
}
