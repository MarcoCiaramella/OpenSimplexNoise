package com.jnoise.opensimplexnoise;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.jnoise.opensimplexnoiselib.OpenSimplex2S;

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
public class OpenSimplex2STest {

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.jnoise.opensimplexnoise", appContext.getPackageName());
    }

    @Test
    public void noise2_isCorrect(){
        OpenSimplex2S openSimplex2S = new OpenSimplex2S();
        double[] noise = openSimplex2S.noise2(1234, 512, 512, 0, 0, 0.1);
        assertNotNull(noise);
    }
}