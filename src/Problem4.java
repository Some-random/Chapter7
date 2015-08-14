/**
 * Created by Bob_JIANG on 8/14/2015.
 */
public class Problem4 {

    /* Subtract two numbers by negating b and adding them */
    public static int minus(int a, int b) {
        return a + (-b);
    }

    /* Multiply a by b by adding a to itself b times */
    public static int multiply(int a, int b) {
        boolean isNegative = false;
        if(b < 0) {
            isNegative = true;
            b = -b;
        }
        int sum = 0;
        for (int i = b; i > 0; i--) {
            sum += a;
        }
        return isNegative ? -sum : sum;
    }


    public static int divide(int a, int b) throws java.lang.ArithmeticException {
        if (b == 0) {
            throw new java.lang.ArithmeticException("ERROR: Divide by zero.");
        }
        int absa, absb;
        absa = a < 0 ? -a : a;
        absb = b < 0 ? -b : b;

        int product = 0;
        int x = 0;
        while (product + absb <= absa) { /* don't go past a */
            product += absb;
            x++;
        }

        if ((a < 0 && b < 0) || (a > 0 && b > 0)) {
            return x;
        } else {
            return -x;
        }
    }

    public static int randomInt(int n) {
        return (int) (Math.random() * n);
    }

    //Division is a bit tricky
    public static void main(String[] args) {
        int q = multiply(-5, -10);
        System.out.println(q);

        for (int i = 0; i < 100; i++) {
            int a = randomInt(10);
            int b = randomInt(10);
            int ans = minus(a, b);
            if (ans != a - b) {
                System.out.println("ERROR");
            }
            System.out.println(a + " - " + b + " = " + ans);
        }
        for (int i = 0; i < 100; i++) {
            int a = randomInt(10);
            int b = randomInt(10);
            int ans = multiply(a, b);
            if (ans != a * b) {
                System.out.println("ERROR");
            }
            System.out.println(a + " * " + b + " = " + ans);
        }
        for (int i = 0; i < 100; i++) {
            int a = randomInt(10) + 1;
            int b = randomInt(10) + 1;
            System.out.print(a + " / " + b + " = ");
            int ans = divide(a, b);
            if (ans != a / b) {
                System.out.println("ERROR");
            }
            System.out.println(ans);
        }
    }
}
