package com.jnoise.opensimplexnoise;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

import com.jnoise.opensimplexnoiselib.OpenSimplex2F;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int WIDTH = 512;
    private static final int HEIGHT = 512;
    private static final int DELAY_MILLIS = 1000;
    private final ArrayList<double[]> heightmaps = new ArrayList<>();
    private final OpenSimplex2F openSimplex2F = new OpenSimplex2F(1234);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heightmaps.add(createHeightmapNoise2(0, 0, 0.1));
        heightmaps.add(createHeightmapNoise2(0, 0, 0.01));
        heightmaps.add(createHeightmapNoise2XBeforeY(0, 0, 0.1));
        heightmaps.add(createHeightmapNoise2XBeforeY(0, 0, 0.01));
        heightmaps.add(createHeightmapNoise3Classic(0, 0, 0, 0.1));
        heightmaps.add(createHeightmapNoise3Classic(0, 0, 0, 0.01));
        heightmaps.add(createHeightmapNoise3XYBeforeZ(0, 0, 0, 0.1));
        heightmaps.add(createHeightmapNoise3XYBeforeZ(0, 0, 0, 0.01));
        heightmaps.add(createHeightmapNoise3XZBeforeY(0, 0, 0, 0.1));
        heightmaps.add(createHeightmapNoise3XZBeforeY(0, 0, 0, 0.01));
        heightmaps.add(createHeightmapNoise4Classic(0, 0, 0, 0, 0.1));
        heightmaps.add(createHeightmapNoise4Classic(0, 0, 0, 0, 0.01));
        heightmaps.add(createHeightmapNoise4XYBeforeZW(0, 0, 0, 0, 0.1));
        heightmaps.add(createHeightmapNoise4XYBeforeZW(0, 0, 0, 0, 0.01));
        heightmaps.add(createHeightmapNoise4XZBeforeYW(0, 0, 0, 0, 0.1));
        heightmaps.add(createHeightmapNoise4XZBeforeYW(0, 0, 0, 0, 0.01));
        heightmaps.add(createHeightmapNoise4XYZBeforeW(0, 0, 0, 0, 0.1));
        heightmaps.add(createHeightmapNoise4XYZBeforeW(0, 0, 0, 0, 0.01));

        ((ImageView)findViewById(R.id.imageView)).postDelayed(new Runnable() {
            @Override
            public void run() {
                if (heightmaps.size() > 0) {
                    showImage(heightmaps.remove(0));
                    ((ImageView)findViewById(R.id.imageView)).postDelayed(this, DELAY_MILLIS);
                }
            }
        }, DELAY_MILLIS);
    }

    private void showImage(double[] noise){
        int[] colors = new int[WIDTH*HEIGHT];
        for (int i = 0; i < noise.length; i++){
            double d = (noise[i]+1.0) / 2.0;
            colors[i] = Color.argb(0xFF, (int)(0xFF*d), (int)(0xFF*d), (int)(0xFF*d));
        }
        Bitmap bitmap = Bitmap.createBitmap(colors, WIDTH, HEIGHT, Bitmap.Config.ARGB_8888);
        ((ImageView)findViewById(R.id.imageView)).setImageBitmap(bitmap);
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

    public double[] createHeightmapNoise2(int offX, int offY, double freq){
        double[] grid = points(WIDTH, HEIGHT, offX, offY, freq);
        return openSimplex2F.noise2(grid, grid.length/2);
    }

    public double[] createHeightmapNoise2XBeforeY(int offX, int offY, double freq){
        double[] grid = points(WIDTH, HEIGHT, offX, offY, freq);
        return openSimplex2F.noise2XBeforeY(grid, grid.length/2);
    }

    public double[] createHeightmapNoise3Classic(int offX, int offY, int offZ, double freq){
        double[] grid = points(WIDTH, HEIGHT, 1, offX, offY, offZ, freq);
        return openSimplex2F.noise3Classic(grid, grid.length/3);
    }

    public double[] createHeightmapNoise3XYBeforeZ(int offX, int offY, int offZ, double freq){
        double[] grid = points(WIDTH, HEIGHT, 1, offX, offY, offZ, freq);
        return openSimplex2F.noise3XYBeforeZ(grid, grid.length/3);
    }

    public double[] createHeightmapNoise3XZBeforeY(int offX, int offY, int offZ, double freq){
        double[] grid = points(WIDTH, HEIGHT, 1, offX, offY, offZ, freq);
        return openSimplex2F.noise3XZBeforeY(grid, grid.length/3);
    }

    public double[] createHeightmapNoise4Classic(int offX, int offY, int offZ, int offW, double freq){
        double[] grid = points(WIDTH, HEIGHT, 1, 1, offX, offY, offZ, offW, freq);
        return openSimplex2F.noise4Classic(grid, grid.length/4);
    }

    public double[] createHeightmapNoise4XYBeforeZW(int offX, int offY, int offZ, int offW, double freq){
        double[] grid = points(WIDTH, HEIGHT, 1, 1, offX, offY, offZ, offW, freq);
        return openSimplex2F.noise4XYBeforeZW(grid, grid.length/4);
    }

    public double[] createHeightmapNoise4XZBeforeYW(int offX, int offY, int offZ, int offW, double freq){
        double[] grid = points(WIDTH, HEIGHT, 1, 1, offX, offY, offZ, offW, freq);
        return openSimplex2F.noise4XZBeforeYW(grid, grid.length/4);
    }

    public double[] createHeightmapNoise4XYZBeforeW(int offX, int offY, int offZ, int offW, double freq){
        double[] grid = points(WIDTH, HEIGHT, 1, 1, offX, offY, offZ, offW, freq);
        return openSimplex2F.noise4XYZBeforeW(grid, grid.length/4);
    }
}