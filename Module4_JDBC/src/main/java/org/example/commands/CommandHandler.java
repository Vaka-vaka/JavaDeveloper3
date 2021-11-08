/**
 * JavaDeveloper3. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 08.11.2021
 */

package org.example.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandHandler {

    Map<String, Command> commandMap = new HashMap<>();

    public CommandHandler() {
        commandMap.put("users", new CommandUsers());
    }

    public void handleCommand(String params) {
        int firstSpace = params.indexOf(" ");
        if (firstSpace > -1) {
            Command command = commandMap
                    .get(params.substring(0, firstSpace));
            if(command != null) {
                command.handle(params.substring(firstSpace + 1));
            }else {
                System.out.println("Unknown command");
            }
        }else {
            System.out.println("Unknown command");
        }
    }

}
