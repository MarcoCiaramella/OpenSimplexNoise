# OpenSimplexNoise
[![](https://jitpack.io/v/MarcoCiaramella/OpenSimplexNoise.svg)](https://jitpack.io/#MarcoCiaramella/OpenSimplexNoise)

The Android library from the gist https://gist.github.com/KdotJPG/b1270127455a94ac5d19
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
import com.jnoise.opensimplexnoise.OpenSimplexNoise;
import java.util.ArrayList;

public class Heightmap {

    private float[] vertices;
    private int verticesIndex;

    public Heightmap(int width, int height, int featureSize){
        vertices = new float[width*height*3];
        verticesIndex = 0;
        OpenSimplexNoise noise = new OpenSimplexNoise();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                double value01 = (noise.eval(x / (double)featureSize, y / (double)featureSize, 0.0)+1) / 2;
                addVertex(x,y,value01);
                addIndex(x,y);
            }
        }
    }

    private void addVertex(int x, int y, double z01){
        vertices[verticesIndex++] = x/(float)width;
        vertices[verticesIndex++] = y/(float)height;
        vertices[verticesIndex++] = (float)z01;
    }
}
```
