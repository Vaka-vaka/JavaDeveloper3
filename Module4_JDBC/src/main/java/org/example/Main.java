/**
 * JavaDeveloper3. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 02.11.2021
 */

package org.example;

import org.example.config.DbMigration;
import org.example.console.CommandHandler;
import java.util.*;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {

        private static final Logger LOGGER = LogManager.getLogger(Main.class);

        public static void main (String[]args){
            LOGGER.debug("Start application");
            DbMigration.migrate();

            runMainApp();
            LOGGER.info("END application");
        }

        public static void runMainApp () {
            CommandHandler commandHandler = new CommandHandler();
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                commandHandler.handleCommand(scanner.nextLine());
            }
        }
    }

//        System.out.println("Start application");
//
//        CommandHandler commandHandler = new CommandHandler();
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            commandHandler.handleCommand(scanner.nextLine());
//        }
//
//        System.out.println("And application");
//    }