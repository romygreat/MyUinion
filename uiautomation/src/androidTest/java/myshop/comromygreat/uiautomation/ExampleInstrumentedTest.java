package myshop.comromygreat.uiautomation;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.util.Log;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    String TAG = getClass().getSimpleName();
    Instrumentation instrumentation;
    UiDevice uiDevice;
    Context mContext;

    @Ignore
    public void setUp() {

    }
    @Test
    public void appContext()  {
        instrumentation = InstrumentationRegistry.getInstrumentation();
        mContext = instrumentation.getContext();
        uiDevice = UiDevice.getInstance(instrumentation);
        uiDevice.takeScreenshot(new File("/sdcard/hello.png"));
        //可以使用by的方式使用测试
     //   am instrument -w -r   -e debug false -e class 'myshop.comromygreat.uiautomation.ExampleInstrumentedTest' myshop.comromygreat.uiautomation.test/android.support.test.runner.AndroidJUnitRunner

    }


}
