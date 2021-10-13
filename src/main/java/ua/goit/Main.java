/**
 * JavaDeveloper3. Module 2. jUnitTest
 *
 *  @autor Valentin Mozul
 *  @version of 08.10.2021
 */

package ua.goit;

import ua.goit.services.UserServise;

public class Main {

    static UserServise servise = new UserServise();

    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setAge(55);
        user.setName("Aka");
        user.setSex(Sex.MALE);
        servise.putUser(user);
        System.out.println(servise.getAll());
    }


}
