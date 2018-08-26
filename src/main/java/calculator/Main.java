package calculator;

public class Main {

    public static void main(String[] args) {

	Calculator calc = new Calculator();
	System.out.println(calc.evaluate("(1+38)*4-5")); // Result: 151
	System.out.println(calc.evaluate("7*6/2+8"));
	System.out.println(calc.evaluate("-12)1//("));
    }

}
