/**
 * JavaDeveloper3. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 08.11.2021
 */

package org.example.commands;

public class CommandUsers implements Command {


    @Override
    public void handle(String params) {
        System.out.println("Users command" + params);
    }
}
