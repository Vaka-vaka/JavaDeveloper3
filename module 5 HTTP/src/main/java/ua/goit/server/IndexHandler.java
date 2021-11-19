/**
 * Module 5. HTTP
 *
 * @autor Valentin Mozul
 * @version of 18.11.2021
 */

package ua.goit.server;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class IndexHandler extends AbstractHandler {

    @Override
    String getTempLateName() {
        return "index";
    }

    @Override
    protected void get(HttpExchange exchange) {

    }
}
