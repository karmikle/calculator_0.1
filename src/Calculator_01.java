import java.util.Scanner;

public class Calculator_01
{
    public static void main(String[] args)
    {

        String [] calculations = new String[5];

        System.out.println("Enter the first number:");
        Scanner in = new Scanner(System.in);
        String a = in.next();
        double n = 0;

        try {
            n = Double.parseDouble(a);
            calculations[0] = Double.toString(n);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }

        System.out.println("Enter operation: +, -, *, /");
        char oprtr = in.next().charAt(0);
        calculations[1] = Character.toString(oprtr) ;

        System.out.println("Enter the second number:");
        String b = in.next();
        double m = 0;

        try {
            m = Double.parseDouble(b);
            calculations[2] = Double.toString(m);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }

        calculations[3] = "=";

        double result = 0;

        switch (oprtr) {
            case '+':
                result = n + m;
                break;
            case '-':
                result = n - m;
                break;
            case '*':
                result = n * m;
                break;
            case '/':
                if (m != 0) {
                    result = n / m;
                } else {
                    System.out.println("Mistake of dividing by ZERO 0");
                    return;
                }
                break;
            default:
                System.out.println("Mistake: wrong operator!!");
        }

        calculations[4] = Double.toString(result);

        String example = String.join(" ", calculations);
        System.out.println(example);

        System.out.println("Result: " + result);


        while (true) {

            calculations[0] = Double.toString(result);

            System.out.println("Enter next operator ( +, -, *, / ) or 'q' to quit:");
            char nextChar = in.next().charAt(0);
            if ( nextChar == 81 || nextChar == 113) {
                System.out.println("Goodbye");
                break;
            }

            calculations[1] = Character.toString(nextChar);

            System.out.println("Enter next number:");
            String nextNum = in.next();
            double nextNumber = 0;

            try {
                nextNumber = Double.parseDouble(nextNum);
                calculations[2] = Double.toString(nextNumber);
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
            }

            switch (nextChar) {
                case '+':
                    result += nextNumber;
                    break;
                case '-':
                    result -= nextNumber;
                    break;
                case '*':
                    result *= nextNumber;
                    break;
                case '/':
                    if (nextNumber != 0) {
                        result /= nextNumber;
                    } else {
                        System.out.println("Error of deviding by ZERO 0");
                        return;
                    }
                    break;
                default:
                    System.out.println("Mistake: wrong operator!!!");
                    return;
            }

            calculations[4] = Double.toString(result);

            String newExample = String.join(" ", calculations);
            System.out.println(newExample);
        }
        System.out.println("final result: " + result);
    }
}