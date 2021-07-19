public class CalculatorTest {
    public static void main(String[] args) {
        Calculator c = new Calculator();

        c.setNum1(5.7);
        c.setNum2(10.2);
        c.setOperator('+');
        c.performOperation();
        c.getResult();

        //-------------------------------------------//
        Calculator k = new Calculator(4.9, '%', 2);
        // k.performOperation();
        // k.getResult();
    }
}
