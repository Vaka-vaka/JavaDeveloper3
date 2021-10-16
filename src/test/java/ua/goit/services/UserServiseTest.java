/**
 * JavaDeveloper3. Module 2. jUnitTest
 *
 *  @autor Valentin Mozul
 *  @version of 08.10.2021
 */

package ua.goit.services;

import org.junit.Assert;
import org.junit.Test;
import ua.goit.Sex;
import ua.goit.User;

import java.util.List;

public class UserServiseTest {

    private UserServise servise = new UserServise();

    @Test
    public void getUsersBySexTest() {
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

        List<User> usersBySex = servise.getUsersBySex(Sex.FEMALE);
        Assert.assertTrue("GetUsersBySex by female", usersBySex.size() == 1);
    }
}