package com.jnoise.opensimplexnoise;

import org.junit.Test;
import static org.junit.Assert.*;

public class OpenSimplex2FTest {

    @Test
    public void noise2_isCorrect(){
        OpenSimplex2F openSimplex2F = new OpenSimplex2F();
        double[] noise = openSimplex2F.noise2(1234, 512, 512);
        assertNotNull(noise);
    }
}
