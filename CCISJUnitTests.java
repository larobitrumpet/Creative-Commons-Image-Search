import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CCISJUnitTests
{
    @BeforeClass
    public static void initialize() throws InterruptedException
    {
        Thread thread = new Thread("JavaFx Init Thread")
        {
            public void run()
            {
                CCISMockMain mockmain = new CCISMockMain();
                mockmain.JUnitRun();
            }
        };
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(5000);
    }

    @Test
    public void test_constructURL_1()
    {
        CCISModel model = new CCISModel();
        String url = model.constructURL("test", "", "", "", "", "", "", "", false);
        assertEquals(url, "http://api.creativecommons.engineering/v1/images?format=json&q=test");
    }

    @Test
    public void test_constructURL_2()
    {
        CCISModel model = new CCISModel();
        String url = model.constructURL("space ship", "modification", "", "nasa,spacex,wikimedia", "", "jpeg,png,svg", "", "medium,large", false);
        assertEquals(url, "http://api.creativecommons.engineering/v1/images?format=json&q=space+ship&license_type=modification&source=nasa,spacex,wikimedia&extension=jpeg,png,svg&size=medium,large");
    }

    @Test
    public void test_constructURL_3()
    {
        CCISModel model = new CCISModel();
        String url = model.constructURL("person", "", "", "", "", "", "", "", true);
        assertEquals(url, "http://api.creativecommons.engineering/v1/images?format=json&creator=person");
    }

    @Test
    public void testDetailTitle()
    {
        CCISModel model = new CCISModel();
        boolean success = model.getImageDetail("7c829a03-fb24-4b57-9b03-65f43ed19395");
        assertEquals(success, true);
        String[] imageDetails = model.getDetails();
        assertEquals(imageDetails[0], "exam test");
    }

    @Test
    public void testDetailCreator()
    {
        CCISModel model = new CCISModel();
        boolean success = model.getImageDetail("7c829a03-fb24-4b57-9b03-65f43ed19395");
        assertEquals(success, true);
        String[] imageDetails = model.getDetails();
        assertEquals(imageDetails[1], "Sean MacEntee");
    }

    @Test
    public void testDetailCreatorURL()
    {
        CCISModel model = new CCISModel();
        boolean success = model.getImageDetail("7c829a03-fb24-4b57-9b03-65f43ed19395");
        assertEquals(success, true);
        String[] imageDetails = model.getDetails();
        assertEquals(imageDetails[2], "https://www.flickr.com/photos/18090920@N07");
    }

    @Test
    public void testDetailLicense()
    {
        CCISModel model = new CCISModel();
        boolean success = model.getImageDetail("7c829a03-fb24-4b57-9b03-65f43ed19395");
        assertEquals(success, true);
        String[] imageDetails = model.getDetails();
        assertEquals(imageDetails[3], "CC BY 2.0");
    }

    @Test
    public void testDetailAttribution()
    {
        CCISModel model = new CCISModel();
        boolean success = model.getImageDetail("7c829a03-fb24-4b57-9b03-65f43ed19395");
        assertEquals(success, true);
        String[] imageDetails = model.getDetails();
        assertEquals(imageDetails[4], "\"exam test\" by Sean MacEntee is licensed under CC-BY 2.0. To view a copy of this license, visit https://creativecommons.org/licenses/by/2.0/.");
    }

    @Test
    public void testDetailURL()
    {
        CCISModel model = new CCISModel();
        boolean success = model.getImageDetail("7c829a03-fb24-4b57-9b03-65f43ed19395");
        assertEquals(success, true);
        String[] imageDetails = model.getDetails();
        assertEquals(imageDetails[5], "https://live.staticflickr.com/5122/5264886972_3234d62748.jpg");
    }
}
