# OpenSimplexNoise
[![](https://jitpack.io/v/MarcoCiaramella/OpenSimplexNoise.svg)](https://jitpack.io/#MarcoCiaramella/OpenSimplexNoise)

The Android library of the [OpenSimplex 2](https://github.com/KdotJPG/OpenSimplex2)
## How to import in your Android project
Add JitPack in your root build.gradle at the end of repositories:

```
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

Add the dependency
```
dependencies {
  implementation 'com.github.MarcoCiaramella:OpenSimplexNoise:1.0.0'
}
```

## How to use
```java
public class Heightmap {

    private static double[] points(int width, int height, int offX, int offY, double freq){
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

    public static double[] create(int width, int height, int offX, int offY, double freq){
        OpenSimplex2F openSimplex2F = new OpenSimplex2F(1234);
        // create a width*height grid of points. Grid must be an array in the form of [x0,y0,x1,y1,....xn,yn]
        double[] grid = points(width, height, offX, offY, freq);
        return openSimplex2F.noise2(grid, grid.length/2);
    }
}
```
