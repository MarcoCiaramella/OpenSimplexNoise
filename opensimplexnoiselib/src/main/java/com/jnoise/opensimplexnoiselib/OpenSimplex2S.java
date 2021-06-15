package com.jnoise.opensimplexnoiselib;

/**
 * K.jpg's OpenSimplex 2, smooth variant ("SuperSimplex")
 *
 * - 2D is standard simplex, modified to support larger kernels.
 *   Implemented using a lookup table.
 * - 3D is "Re-oriented 8-point BCC noise" which constructs a
 *   congruent BCC lattice in a much different way than usual.
 * - 4D uses a naïve pregenerated lookup table, and averages out
 *   to the expected performance.
 *
 * Multiple versions of each function are provided. See the
 * documentation above each, for more info.
 */
public class OpenSimplex2S {

    static {
        System.loadLibrary("OpenSimplex2S");
    }

    /**
     * 2D SuperSimplex noise, standard lattice orientation.
     */
    public native double[] noise2(long seed, int width, int height);

    /**
     * 2D SuperSimplex noise, with Y pointing down the main diagonal.
     * Might be better for a 2D sandbox style game, where Y is vertical.
     * Probably slightly less optimal for heightmaps or continent maps.
     */
    public native double[] noise2XBeforeY(long seed, int width, int height);

    /**
     * 3D Re-oriented 8-point BCC noise, classic orientation
     * Proper substitute for what 3D SuperSimplex would be,
     * in light of Forbidden Formulae.
     * Use noise3_XYBeforeZ or noise3_XZBeforeY instead, wherever appropriate.
     */
    public native double[] noise3Classic(long seed, int width, int height);

    /**
     * 3D Re-oriented 8-point BCC noise, with better visual isotropy in (X, Y).
     * Recommended for 3D terrain and time-varied animations.
     * The Z coordinate should always be the "different" coordinate in your use case.
     * If Y is vertical in world coordinates, call noise3_XYBeforeZ(x, z, Y) or use noise3_XZBeforeY.
     * If Z is vertical in world coordinates, call noise3_XYBeforeZ(x, y, Z).
     * For a time varied animation, call noise3_XYBeforeZ(x, y, T).
     */
    public native double[] noise3XYBeforeZ(long seed, int width, int height);

    /**
     * 3D Re-oriented 8-point BCC noise, with better visual isotropy in (X, Z).
     * Recommended for 3D terrain and time-varied animations.
     * The Y coordinate should always be the "different" coordinate in your use case.
     * If Y is vertical in world coordinates, call noise3_XZBeforeY(x, Y, z).
     * If Z is vertical in world coordinates, call noise3_XZBeforeY(x, Z, y) or use noise3_XYBeforeZ.
     * For a time varied animation, call noise3_XZBeforeY(x, T, y) or use noise3_XYBeforeZ.
     */
    public native double[] noise3XZBeforeY(long seed, int width, int height);

    /**
     * 4D SuperSimplex noise, classic lattice orientation.
     */
    public native double[] noise4Classic(long seed, int width, int height);

    /**
     * 4D SuperSimplex noise, with XY and ZW forming orthogonal triangular-based planes.
     * Recommended for 3D terrain, where X and Y (or Z and W) are horizontal.
     * Recommended for noise(x, y, sin(time), cos(time)) trick.
     */
    public native double[] noise4XYBeforeZW(long seed, int width, int height);

    /**
     * 4D SuperSimplex noise, with XZ and YW forming orthogonal triangular-based planes.
     * Recommended for 3D terrain, where X and Z (or Y and W) are horizontal.
     */
    public native double[] noise4XZBeforeYW(long seed, int width, int height);

    /**
     * 4D SuperSimplex noise, with XYZ oriented like noise3_Classic,
     * and W for an extra degree of freedom.
     * Recommended for time-varied animations which texture a 3D object (W=time)
     */
    public native double[] noise4XYZBeforeW(long seed, int width, int height);
}
