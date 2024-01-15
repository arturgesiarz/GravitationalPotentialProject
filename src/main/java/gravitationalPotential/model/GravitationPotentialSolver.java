package gravitationalPotential.model;

import org.apache.commons.math3.linear.*;
import static java.lang.Math.*;

public class GravitationPotentialSolver {

    public double[] solver(int n) {
        Array2DRowRealMatrix matrix = new Matrix(n).getMatrix();
        ArrayRealVector vector = new Vector(n).getVector();

        return new LUDecomposition(matrix).getSolver().solve(vector).toArray();
    }
}
