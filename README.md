# OpenSimplexNoise
[![](https://jitpack.io/v/MarcoCiaramella/OpenSimplexNoise.svg)](https://jitpack.io/#MarcoCiaramella/OpenSimplexNoise)

The Android library from the gist https://gist.github.com/KdotJPG/b1270127455a94ac5d19
## How to import in your Androdi project
Add it in your root build.gradle at the end of repositories:

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
                double value01 = (noise.eval(x / featureSize, y / featureSize, 0.0)+1) / 2;
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

## License
This is free and unencumbered software released into the public domain.

Anyone is free to copy, modify, publish, use, compile, sell, or
distribute this software, either in source code form or as a compiled
binary, for any purpose, commercial or non-commercial, and by any
means.

In jurisdictions that recognize copyright laws, the author or authors
of this software dedicate any and all copyright interest in the
software to the public domain. We make this dedication for the benefit
of the public at large and to the detriment of our heirs and
successors. We intend this dedication to be an overt act of
relinquishment in perpetuity of all present and future rights to this
software under copyright law.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
OTHER DEALINGS IN THE SOFTWARE.
