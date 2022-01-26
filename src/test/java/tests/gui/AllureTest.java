package tests.gui;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllureTest {

    @Test (description = "Human-readable test name")
    public void testName(){
        Assert.assertTrue(true);
    }

    @Test
    @Description ("Some detailed test description")
    public void testDescription(){
        Assert.assertTrue(true);
    }
}
