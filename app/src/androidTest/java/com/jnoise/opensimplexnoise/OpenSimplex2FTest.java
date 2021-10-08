package com.jnoise.opensimplexnoise;

import android.content.Context;
import android.os.Debug;
import android.util.Log;

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

    private double[] points(int width, int height, int depth, int offX, int offY, int offZ, double freq){
        double[] points = new double[width*height*depth*3];
        int i = 0;
        for (int z = 0; z < depth; z++) {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    double xd = (x + offX) * freq;
                    double yd = (y + offY) * freq;
                    double zd = (z + offZ) * freq;
                    points[i++] = xd;
                    points[i++] = yd;
                    points[i++] = zd;
                }
            }
        }
        return points;
    }

    private double[] points(int width, int height, int depth, int time, int offX, int offY, int offZ, int offW, double freq){
        double[] points = new double[width*height*depth*time*4];
        int i = 0;
        for (int w = 0; w < time; w++) {
            for (int z = 0; z < depth; z++) {
                for (int y = 0; y < height; y++) {
                    for (int x = 0; x < width; x++) {
                        double xd = (x + offX) * freq;
                        double yd = (y + offY) * freq;
                        double zd = (z + offZ) * freq;
                        double wd = (w + offW) * freq;
                        points[i++] = xd;
                        points[i++] = yd;
                        points[i++] = zd;
                        points[i++] = wd;
                    }
                }
            }
        }
        return points;
    }

    @Test
    public void noise2_isCorrect(){
        double[] points = points(512, 512, 0, 0, 0.1);

        startMethodTracing("noise2_isCorrect");
        OpenSimplex2F openSimplex2F = new OpenSimplex2F(1234);
        double[] noise = openSimplex2F.noise2(points, points.length/2);
        assertNotNull(noise);
        stopMethodTracing();
    }

    @Test
    public void noise2_timing(){
        double[] points = points(512, 512, 0, 0, 0.1);

        long t0 = System.currentTimeMillis();
        long numTests = 100;
        for (int c = 0; c < numTests; c++) {
            OpenSimplex2F openSimplex2F = new OpenSimplex2F(c);
            double[] noise = openSimplex2F.noise2(points, points.length/2);
        }
        long t1 = System.currentTimeMillis();
        Log.i("TEST", "time: "+((t1-t0)/numTests)+"ms");
    }

    @Test
    public void noise2XBeforeY_isCorrect(){
        double[] points = points(512, 512, 0, 0, 0.1);

        startMethodTracing("noise2XBeforeY_isCorrect");
        OpenSimplex2F openSimplex2F = new OpenSimplex2F(1234);
        double[] noise = openSimplex2F.noise2XBeforeY(points, points.length/2);
        assertNotNull(noise);
        stopMethodTracing();
    }

    @Test
    public void noise3Classic_isCorrect(){
        double[] points = points(64, 64, 64, 0, 0, 0, 0.1);

        startMethodTracing("noise3Classic_isCorrect");
        OpenSimplex2F openSimplex2F = new OpenSimplex2F(1234);
        double[] noise = openSimplex2F.noise3Classic(points, points.length/3);
        assertNotNull(noise);
        stopMethodTracing();
    }

    @Test
    public void noise3XYBeforeZ_isCorrect(){
        double[] points = points(64, 64, 64, 0, 0, 0, 0.1);

        startMethodTracing("noise3XYBeforeZ_isCorrect");
        OpenSimplex2F openSimplex2F = new OpenSimplex2F(1234);
        double[] noise = openSimplex2F.noise3XYBeforeZ(points, points.length/3);
        assertNotNull(noise);
        stopMethodTracing();
    }

    @Test
    public void noise3XZBeforeY_isCorrect(){
        double[] points = points(64, 64, 64, 0, 0, 0, 0.1);

        startMethodTracing("noise3XZBeforeY_isCorrect");
        OpenSimplex2F openSimplex2F = new OpenSimplex2F(1234);
        double[] noise = openSimplex2F.noise3XZBeforeY(points, points.length/3);
        assertNotNull(noise);
        stopMethodTracing();
    }

    @Test
    public void noise4Classic_isCorrect(){
        double[] points = points(8, 8, 8, 8, 0, 0, 0, 0, 0.1);

        startMethodTracing("noise4Classic_isCorrect");
        OpenSimplex2F openSimplex2F = new OpenSimplex2F(1234);
        double[] noise = openSimplex2F.noise4Classic(points, points.length/4);
        assertNotNull(noise);
        stopMethodTracing();
    }

    @Test
    public void noise4XYBeforeZW_isCorrect(){
        double[] points = points(8, 8, 8, 8, 0, 0, 0, 0, 0.1);

        startMethodTracing("noise4XYBeforeZW_isCorrect");
        OpenSimplex2F openSimplex2F = new OpenSimplex2F(1234);
        double[] noise = openSimplex2F.noise4XYBeforeZW(points, points.length/4);
        assertNotNull(noise);
        stopMethodTracing();
    }

    @Test
    public void noise4XZBeforeYW_isCorrect(){
        double[] points = points(8, 8, 8, 8, 0, 0, 0, 0, 0.1);

        startMethodTracing("noise4XZBeforeYW_isCorrect");
        OpenSimplex2F openSimplex2F = new OpenSimplex2F(1234);
        double[] noise = openSimplex2F.noise4XZBeforeYW(points, points.length/4);
        assertNotNull(noise);
        stopMethodTracing();
    }

    @Test
    public void noise4XYZBeforeW_isCorrect(){
        double[] points = points(8, 8, 8, 8, 0, 0, 0, 0, 0.1);

        startMethodTracing("noise4XYZBeforeW_isCorrect");
        OpenSimplex2F openSimplex2F = new OpenSimplex2F(1234);
        double[] noise = openSimplex2F.noise4XYZBeforeW(points, points.length/4);
        assertNotNull(noise);
        stopMethodTracing();
    }
}