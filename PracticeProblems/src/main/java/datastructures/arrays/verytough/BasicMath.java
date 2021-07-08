package datastructures.arrays.verytough;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

public class BasicMath {
    /**Factorial**/
    public int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int result = 1;
        for(int i = 2; i <= n; i++){
            result *= i;
        }
        return result;
    }

    /**Power**/
    public float power(float x, int y) {
        if( y == 0) {
            return 1;
        }

        float temp = power(x, y/2);
        if (y%2 == 0) {
            return temp * temp;
        } else {
            if(y > 0) {
                return temp * temp * x;
            } else {
                return (temp * temp) / x;
            }
        }
    }

    /**Prime**/
    public boolean isPrime(int n) {
        if (n <= 1)
            return false;

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**GreatestCommonDivisor**/
    public int gcd(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        if (a == b) {
            return a;
        }

        if (a > b) {
            return gcd(a - b, b);
        } else {
            return gcd(a, b - a);
        }
    }

    /**LeastCommonMultiple**/
    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    /**CountZeroesOfFactorial**/
    public static int countFactorialZeros(int num) {
        if (num < 0) {
            return 0;
        }

        int count = 0;
        for (int i = 5; num / i > 0; i *= 5) {
            count += num / i;
        }
        return count;
    }

    /**CountTwosInRange**/
    public static int countTwosInRange(int number) {
        int count = 0;
        int len = String.valueOf(number).length();
        for (int digit = 0; digit < len; digit++) {
            count += countTwosInRangeAtDigit(number, digit);
        }
        return count;
    }

    public static int countTwosInRangeAtDigit(int number, int d) {
        int powerOf10 = (int) Math.pow(10, d);
        int nextPowerOf10 = powerOf10 * 10;
        int right = number % powerOf10;

        int roundDown = number - number % nextPowerOf10;
        int roundUp = roundDown + nextPowerOf10;

        int digit = (number / powerOf10) % 10;
        if (digit < 2) {
            return roundDown / 10;
        } else if (digit == 2) {
            return roundDown / 10 + right + 1;
        } else {
            return roundUp / 10;
        }
    }

    /**OPERATIONS**/
    /**Add**/
    public String addBinary(String a, String b) {
        BigInteger a2 = new BigInteger(a,2);
        BigInteger b2 = new BigInteger(b,2);
        BigInteger result = add(a2,b2);
        return result.toString(2);

    }

    public BigInteger add(BigInteger a, BigInteger b){
        BigInteger zero = new BigInteger("0", 2);
        while(b.compareTo(zero)!=0){
            BigInteger ans = a.xor(b);
            BigInteger carry = a.and(b).shiftLeft(1);
            a=ans;
            b=carry;
        }
        return a;
    }

    /**Subtract**/
    public static int minus(int a, int b) {
        return a + negate(b);
    }

    /**Multiply**/
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();

        char[] result = new char[n1 + n2];
        Arrays.fill(result, '0');
        for(int i = n1 - 1; i >= 0; i--) {
            for(int j = n2 -1; j >= 0; j--) {
                int temp = charToInt(num1.charAt(i)) * charToInt(num2.charAt(j));
                temp += charToInt(result[i + j + 1]);
                result[i + j + 1] = intToChar(temp % 10);
                result[i + j] = intToChar(charToInt(result[i + j]) + temp / 10);
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for(char c : result){
            if(flag && c == '0') {
                continue;
            }
            flag = false;
            sb.append(c);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    private int charToInt(char c) {
        return c - '0';
    }

    private char intToChar(int i) {
        return (char)(i + '0');
    }

    /**Divide**/
    public static int divide(int a, int b) throws java.lang.ArithmeticException {
        if (b == 0) {
            throw new java.lang.ArithmeticException("ERROR: Divide by zero.");
        }
        int absoluteA = abs(a);
        int absoluteB = abs(b);

        int product = 0;
        int x = 0;
        while (product + absoluteB <= absoluteA) {
            product += absoluteB;
            x++;
        }

        if ((a < 0 && b < 0) || (a > 0 && b > 0)) {
            return x;
        } else {
            return negate(x);
        }
    }

    /**Absolute**/
    public static int abs(int a) {
        if (a < 0) {
            return negate(a);
        }
        else return a;
    }

    /**Negate**/
    public static int negate(int a) {
        int neg = 0;
        int newSign = a < 0 ? 1 : -1;
        int delta = newSign;
        while (a != 0) {
            boolean differentSigns = (a + delta > 0) != (a > 0);
            if (a + delta != 0 && differentSigns) {
                delta = newSign;
            }
            neg += delta;
            a += delta;
            delta += delta;
        }
        return neg;
    }

    /**RANDOM**/
    /**Random7UsingRandom5**/
    public static int rand7() {
        while (true) {
            int r1 = 2 * rand5(); /* generate evens between 0 and 9 */
            int r2 = rand5();
            if (r2 != 4) { /* r2 has an extra even number, so discard the extra */
                int rand1 = r2 % 2; /* generate 0 or 1 */
                int num = r1 + rand1; /* will be in the range 0 through 9 */
                if (num < 7) {
                    return num;
                }
            }
        }
    }

    public static int rand5() {
        return (int) (Math.random() * 100) % 5;
    }

    /**ShuffleCards**/
    public static void shuffleArrayIteratively(int[] cards) {
        for (int i = 0; i < cards.length; i++) {
            int k = rand(0, i);
            int temp = cards[k];
            cards[k] = cards[i];
            cards[i] = temp;
        }
    }

    /**GenerateRandomCards**/
    public static int[] pickMIteratively(int[] original, int k) {
        int[] subset = new int[k];
        for (int i = 0; i < k ; i++) {
            subset[i] = original[i];
        }
        for (int i = k; i < original.length; i++) {
            int random = rand(0, i);
            if (random < k) {
                subset[random] = original[i];
            }
        }
        return subset;
    }

    public static int rand(int lower, int higher) {
        Random random = new Random();
        return lower + random.nextInt(higher - lower);
    }
}
