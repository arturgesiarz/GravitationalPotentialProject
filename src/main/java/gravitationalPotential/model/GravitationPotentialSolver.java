package gravitationalPotential.model;

import org.apache.commons.math3.linear.*;

public class GravitationPotentialSolver {

    public double[] solver(int n) {

        Array2DRowRealMatrix matrix = new Matrix(n).getMatrix();  // O(n)
        ArrayRealVector vector = new Vector(n).getVector();  // O(n)

        // LU dekompozycja, aby uzyskac macierz wyniowa
        return new LUDecomposition(matrix)  // O(n^3) - wykorzystuje algortym Gaussa-Jordana
                .getSolver()
                .solve(vector)
                // zamieniam macierz na liste, abym mogl ja zwizualizowac
                .toArray();
    }
}
