public class Calculator {
    private double num1;
    private double num2;
    private double res;
    private char operator;
//-------------Constructor----------------//
    public Calculator(){

    }
    public Calculator(double num1,char operator, double num2){
        this.num1 = num1;
        this.operator = operator;
        this.num2 = num2;
        this.performOperation();
        this.getResult();
    }

//---------------Setters-------------------//
    public void setNum1(double num1){
        this.num1 = num1;
    }
    public void setNum2(double num2){
        this.num2 = num2;
    }
    public void setOperator(char operator){
        this.operator = operator;
    }

//---------------Operation Body------------------//
    public void performOperation(){
        if(operator == '+'){
            res = num1 + num2;
        }
        if(operator == '-'){
            res = num1 - num2;
        }
        if(operator == '*' || operator == 'x'){
            res = num1 * num2;
        }
        if(operator == '/' || operator == '%'){
            res = num1 / num2;
        }
    }

    public void getResult(){
        System.out.println(res);
    }

}
