/**
 * Module 5. HTTP
 *
 * @autor Valentin Mozul
 * @version of 18.11.2021
 */

package ua.goit.server;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TemplateHandler {

    private static TemplateHandler instance;

    private static ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    private TemplateHandler() {
    }

    public static TemplateHandler getInstance() {
        if (instance == null) {
            instance = new TemplateHandler();
        }
        return instance;
    }

    public String getTempLate(String templateName) {
        try {
            InputStream inputStream = new FileInputStream(
                    "src/main/resources/templates/" + templateName + ".html");
            return new String(inputStream.readAllBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return " ";
    }
}
