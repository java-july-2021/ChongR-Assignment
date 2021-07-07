import java.lang.Math;
public class Pythagorean{
    public double calculateHypotenuse (int legA, int legB) {
        double sqA = legA * legA;
        double sqB = legB * legB;
        double legC = Math.sqrt(sqA + sqB);
        return legC;
    }
}