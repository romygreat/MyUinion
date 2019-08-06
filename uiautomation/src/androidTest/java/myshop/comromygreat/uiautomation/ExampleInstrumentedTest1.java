package myshop.comromygreat.uiautomation;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiSelector;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest1 {
    @Test
    public void useAppContext() {
        UiDevice uiDevice=UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        uiDevice.pressBack();
        UiObject uiObject=new UiObject(new UiSelector().description("uiautomation"));
    }
    @Test
    public void testUi(){

    }
}
