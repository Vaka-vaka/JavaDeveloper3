/**
 * Module 5. HTTP
 *
 * @autor Valentin Mozul
 * @version of 22.11.2021
 */

package ua.goit.server.handlers;

import com.sun.net.httpserver.HttpExchange;

public class GeneralGetHandler extends AbstractHandler {

private String templateName;

    public GeneralGetHandler(String templateName) {
        this.templateName = templateName;
    }

    @Override
    String getTempLateName() {
        return this.templateName;
    }

    @Override
    protected void get(HttpExchange exchange) {
        handleResponse(exchange);
    }
}
