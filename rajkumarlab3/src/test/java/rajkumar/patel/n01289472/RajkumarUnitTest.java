package rajkumar.patel.n01289472;

import org.junit.Test;

import rajkumar.patel.n01289472.ui.home.RaHome;
import rajkumar.patel.n01289472.ui.lastname.PaSrv;
import rajkumar.patel.n01289472.ui.settings.PatSet;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class RajkumarUnitTest {

    @Test
    public void spinnerCoursePasses() {
        RaHome utils = new RaHome();
        assertTrue(utils.validCourse("CENG 319"));
    }

    @Test
    public void zipCodeEditTextPasses() {
        PaSrv utils = new PaSrv();
        assertTrue(utils.validZipCode("12345"));
    }

    @Test
    public void backgroundColourPasses() {
        PatSet utils = new PatSet();
        assertTrue(utils.validBackgroundColour("Green"));
    }

}