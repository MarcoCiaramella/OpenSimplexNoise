package com.jnoise.opensimplexnoise;

import android.content.Context;
import android.os.Debug;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.jnoise.opensimplexnoiselib.OpenSimplex2F;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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

    private void startMethodTracing(String name){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss", Locale.getDefault());
        String logDate = dateFormat.format(new Date());
        Debug.startMethodTracing(name + logDate);
    }

    private void stopMethodTracing(){
        Debug.stopMethodTracing();
    }

    private double[] points(int width, int height, int offX, int offY, double freq){
        double[] points = new double[width*height*2];
        int i = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                double xd = (x + offX) * freq;
                double yd = (y + offY) * freq;
                points[i++] = xd;
                points[i++] = yd;
            }
        }
        return points;
    }

    @Test
    public void noise2_isCorrect(){
        double[] points = points(512, 512, 0, 0, 0.1);

        startMethodTracing("noise2_isCorrect");
        OpenSimplex2F openSimplex2F = new OpenSimplex2F(1234);
        double[] noise = openSimplex2F.noise2(points, points.length/2, 0, 0, 0.1);
        assertNotNull(noise);
        stopMethodTracing();
    }
}