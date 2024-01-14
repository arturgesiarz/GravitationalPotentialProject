package gravitationalPotential.model;
import java.util.function.DoubleUnaryOperator;
public class Integral {
    public static double calculateIntegral(DoubleUnaryOperator function, double lowerBand, double upperBand){
        double result = 0;
        int intervals = 10000;
        double h = (upperBand - lowerBand) / intervals;

        double last = lowerBand;
        double next = lowerBand + h;

        for(int i = 0; i < intervals; i++){
            result += ( ( next - last ) / 2 * (function.applyAsDouble(last) + function.applyAsDouble(next) ) );
            last = next;
            next += h;
        }
        return result;
    }
}
