package gravitationalPotential.model;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import static java.lang.Math.pow;

public class Matrix {
    private final Array2DRowRealMatrix matrix;

    Matrix(int n) {
        Array2DRowRealMatrix preMatrix = new Array2DRowRealMatrix(n, n);

        fillDiagonal(preMatrix, n);
        fillBesideDiagonal(preMatrix, n);

        this.matrix = preMatrix;
    }
    public Array2DRowRealMatrix getMatrix(){
        return matrix;
    }

    void fillDiagonal(Array2DRowRealMatrix matrix, int n){
        double h = 3.0 / n;

        double valueOnDiagonal = Integral.calculateIntegral(x -> - 1 / pow(h, 2), 0, 2 * h); // O(n)

        for (int i = 0; i < n; i++) {
            // ustawiam wartosci
            matrix.setEntry(i, i, valueOnDiagonal);
        }
    }

    void fillBesideDiagonal(Array2DRowRealMatrix matrix, int n){
        double h = 3.0 / n;

        double valueBesideDiagonal = Integral.calculateIntegral(x -> 1 / pow(h, 2), 0, h);

        for (int i = 0; i < n - 1; i++){
            // ustawiamy wartosci
            matrix.setEntry(i, i + 1, valueBesideDiagonal);
            matrix.setEntry(i + 1, i, valueBesideDiagonal);
        }
    }

}
