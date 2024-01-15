package gravitationalPotential.model;

import org.apache.commons.math3.linear.ArrayRealVector;

public class Vector {
    private static final double G = 6.67430e-11;
    private static final double CONSTANT = 4 * Math.PI * G;
    private final ArrayRealVector vector;
    Vector(int n){
        double h = 3.0 / n;

        // obliczam wektor X, aby potem obliczyc wektor W
        ArrayRealVector preVector = new ArrayRealVector(n);

        for (int i = 1; i <= n; i++) {

            double l = 0;
            final int finalI = i;

            // Licze -B(ϕ,v)
            l -= (double) 1 / 3 * Integral.calculateIntegral(x -> 1 / h, h * (i - 1), h * i);
            l -= (double) 1 / 3 * Integral.calculateIntegral(x -> -1 / h, h * i, h * (i + 1));

            // Licze L(v)
            if (h * (i - 1) >= 1  && (h * i) <= 2) {
                l += CONSTANT * Integral.calculateIntegral(x -> x / h - finalI + 1,h * (i - 1), h * i);
            }
            else if (h * i >= 1 && h * (i + 1) <= 2 ) {
                l += CONSTANT * Integral.calculateIntegral(x -> -x / h + finalI + 1, h * i, h * (i + 1));
            }

            // Dodaje L ̅(v)= L(v) - B(u,v)
            preVector.addToEntry(i - 1, l);
        }
        this.vector = preVector;
    }
    public ArrayRealVector getVector(){
        return vector;
    }
}
