/**
 * Module 5. HTTP
 *
 * @autor Valentin Mozul
 * @version of 23.11.2021
 */

package ua.goit.server.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.goit.dao.DevelopersDao;

public class DevelopersService {

    private static final Logger LOGGER = LogManager.getLogger(DevelopersService.class);

    private final DevelopersDao developersDao = new DevelopersDao();


}
