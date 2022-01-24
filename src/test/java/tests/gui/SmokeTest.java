package tests.gui;

import baseEntities.BaseTest;
import core.ReadProperties;
import models.Project;
import models.User;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {
    Project addProject;
    Project updateProject;

    @Test
    public void loginTest() {
        User user = new User();
        user.setEmail(ReadProperties.getUsername());
        user.setPassword(ReadProperties.getPassword());

        User user1 = new User();
        user1.setEmail(ReadProperties.getUsername());
        user1.setPassword(ReadProperties.getPassword());

        System.out.println(toString());
    }
}
