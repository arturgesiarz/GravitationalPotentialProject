package gravitationalPotential.model;

import org.apache.commons.math3.linear.*;

public class GravitationPotentialSolver {

    public double[] solver(int n) {

        Array2DRowRealMatrix matrix = new Matrix(n).getMatrix();
        ArrayRealVector vector = new Vector(n).getVector();

        // LU dekompozycja, aby uzyskac macierz wyniowa
        return new LUDecomposition(matrix)
                .getSolver()
                .solve(vector)
                // zamieniam macierz na liste, abym mogl ja zwizualizowac
                .toArray();
    }
}
