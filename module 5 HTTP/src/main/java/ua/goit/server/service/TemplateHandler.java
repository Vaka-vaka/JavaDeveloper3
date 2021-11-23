/**
 * Module 5. HTTP
 *
 * @autor Valentin Mozul
 * @version of 18.11.2021
 */

package ua.goit.server.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateHandler {

    private static final Pattern pattern = Pattern.compile(
            "\\{\\{(\\w+)\\}\\}", Pattern.MULTILINE);

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

    public String handleTemplate(String templateName, Map<String, String> params) {
        String template = getTempLate(templateName);
        final Matcher matcher = pattern.matcher(template);
        while (matcher.find()) {
            template = template.replace(
                    matcher.group(0), params.get(matcher.group(1)));
        }
       return template;
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
