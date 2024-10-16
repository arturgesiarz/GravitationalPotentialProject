package gravitationalPotential.model;
import java.util.function.DoubleUnaryOperator;

public class Integral {

    /**
     * The quadrature integral is
     * calculated using Simpson's method.
     *
     */
    public static double calculateIntegral(DoubleUnaryOperator function, double lowerBand, double upperBand){ // O(n)
        double result = 0;
        int intervals = 3;
        double h = (upperBand - lowerBand) / intervals;

        double last = lowerBand;
        double next = lowerBand + h;
        double middle = (last + next) / 2;

        for(int i = 0; i < intervals; i++){
            result += ( ( next - last ) / 6 *
                    ( function.applyAsDouble(last) + 4 * function.applyAsDouble(middle) + function.applyAsDouble(next) ) );
            last = next;
            next += h;
            middle = ( last + next ) / 2;
        }
        return result;
    }
}