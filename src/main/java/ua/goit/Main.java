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
        user.setName("Vaka");
        user.setSex(Sex.MALE);
        servise.putUser(user);

        User user1 = new User();
        user1.setId(2);
        user1.setAge(70);
        user1.setName("Ana");
        user1.setSex(Sex.FEMALE);
        servise.putUser(user1);

        User user2 = new User();
        user2.setId(3);
        user2.setAge(20);
        user2.setName("GAna");
        user2.setSex(Sex.FEMALE);
        servise.putUser(user2);
        System.out.println(servise.getAll());
        System.out.println(servise.getUsersBySex(Sex.MALE));
        System.out.println(servise.getUsersBySex(Sex.FEMALE));
        System.out.println(servise.getUser(2));
        System.out.println(servise.getUserJungleThan(35));
        System.out.println(servise.getUsersOlderThan(45));
    }


}
