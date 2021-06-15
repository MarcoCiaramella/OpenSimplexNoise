package com.jnoise.opensimplexnoiselib;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class OpenSimplex2FTest {

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.jnoise.opensimplexnoise", appContext.getPackageName());
    }

    @Test
    public void noise2_isCorrect(){
        OpenSimplex2F openSimplex2F = new OpenSimplex2F();
        double[] noise = openSimplex2F.noise2(1234, 512, 512);
        assertNotNull(noise);
    }
}