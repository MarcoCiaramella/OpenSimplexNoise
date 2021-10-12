package com.jnoise.opensimplexnoiselib;

/**
 * K.jpg's OpenSimplex 2, faster variant
 *
 * - 2D is standard simplex implemented using a lookup table.
 * - 3D is "Re-oriented 4-point BCC noise" which constructs a
 *   congruent BCC lattice in a much different way than usual.
 * - 4D constructs the lattice as a union of five copies of its
 *   reciprocal. It successively finds the closest point on each.
 *
 * Multiple versions of each function are provided. See the
 * documentation above each, for more info.
 */
public class OpenSimplex2F {

    static {
        System.loadLibrary("OpenSimplex2F");
    }

    public OpenSimplex2F(long seed){
        init(seed);
    }

    private native void init(long seed);

    /**
     * Calls native noise2 function.
     * @param points must be in the form of [x0,y0,x1,y1,....xn,yn]
     * @param numPoints number of input points
     * @return array of noise values. One value for each (xi,yi) input point
     */
    public native double[] noise2(double[] points, int numPoints);

    /**
     * Calls native noise2XBeforeY function.
     * @param points must be in the form of [x0,y0,x1,y1,....xn,yn]
     * @param numPoints number of input points
     * @return array of noise values. One value for each (xi,yi) input point
     */
    public native double[] noise2XBeforeY(double[] points, int numPoints);

    /**
     * Calls native noise3Classic function.
     * @param points must be in the form of [x0,y0,z0,x1,y1,z1,....xn,yn,zn]
     * @param numPoints number of input points
     * @return array of noise values. One value for each (xi,yi,zi) input point
     */
    public native double[] noise3Classic(double[] points, int numPoints);

    /**
     * Calls native noise3XYBeforeZ function.
     * @param points must be in the form of [x0,y0,z0,x1,y1,z1,....xn,yn,zn]
     * @param numPoints number of input points
     * @return array of noise values. One value for each (xi,yi,zi) input point
     */
    public native double[] noise3XYBeforeZ(double[] points, int numPoints);

    /**
     * Calls native noise3XZBeforeY function.
     * @param points must be in the form of [x0,y0,z0,x1,y1,z1,....xn,yn,zn]
     * @param numPoints number of input points
     * @return array of noise values. One value for each (xi,yi,zi) input point
     */
    public native double[] noise3XZBeforeY(double[] points, int numPoints);

    /**
     * Calls native noise4Classic function.
     * @param points must be in the form of [x0,y0,z0,w0,x1,y1,z1,w1,....xn,yn,zn,wn]
     * @param numPoints number of input points
     * @return array of noise values. One value for each (xi,yi,zi,wi) input point
     */
    public native double[] noise4Classic(double[] points, int numPoints);

    /**
     * Calls native noise4XYBeforeZW function.
     * @param points must be in the form of [x0,y0,z0,w0,x1,y1,z1,w1,....xn,yn,zn,wn]
     * @param numPoints number of input points
     * @return array of noise values. One value for each (xi,yi,zi,wi) input point
     */
    public native double[] noise4XYBeforeZW(double[] points, int numPoints);

    /**
     * Calls native noise4XZBeforeYW function.
     * @param points must be in the form of [x0,y0,z0,w0,x1,y1,z1,w1,....xn,yn,zn,wn]
     * @param numPoints number of input points
     * @return array of noise values. One value for each (xi,yi,zi,wi) input point
     */
    public native double[] noise4XZBeforeYW(double[] points, int numPoints);

    /**
     * Calls native noise4XYZBeforeW function.
     * @param points must be in the form of [x0,y0,z0,w0,x1,y1,z1,w1,....xn,yn,zn,wn]
     * @param numPoints number of input points
     * @return array of noise values. One value for each (xi,yi,zi,wi) input point
     */
    public native double[] noise4XYZBeforeW(double[] points, int numPoints);
}
