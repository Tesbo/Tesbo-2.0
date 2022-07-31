package web.object_repository.Tests;

import io.unity.framework.readers.DataReader;
import org.testng.annotations.DataProvider;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    @DataProvider(name = "abcd")
    public Object[][] data() {

        List pricing  = new ArrayList();
        pricing.add("Pro");
        pricing.add("Free");

        List randpm  = new ArrayList();
        randpm.add("av");
        randpm.add("tests");

        DataReader reader = new DataReader();
        List ac = new ArrayList();
        ac.add(pricing);
        ac.add(randpm);

        List xyz = reader.getColumnData("addNewUser.xlsx", "Sheet 1", "Item Type");

        ac.add(xyz);
        return reader.generateCombinationData(ac);

    }

  @org.testng.annotations.Test(dataProvider = "abcd")
    public void testman(String a, String b, String c)
    {
        System.out.println(a + " : " +b +" : " +c);

    }
}
