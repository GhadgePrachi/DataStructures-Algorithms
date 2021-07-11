package datastructures.arrays.verytough;

import java.math.BigInteger;
import java.util.*;

public class BasicMath {
    /** Factorial **/
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

    /** Power **/
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

    /** Prime **/
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

    /** GreatestCommonDivisor **/
    public static int gcd(int a, int b) {
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

    /** LeastCommonMultiple **/
    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    /** Count Zeroes Of Factorial **/
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

    /** CountTwosInRange **/
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

    /** OPERATIONS **/
    /** Add **/
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

    /** Subtract **/
    public static int minus(int a, int b) {
        return a + negate(b);
    }

    /** Multiply **/
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

    /** Divide **/
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

    /** Absolute **/
    public static int abs(int a) {
        if (a < 0) {
            return negate(a);
        }
        else return a;
    }

    /** Negate **/
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

    /** Conversions **/
    /** Roman Number to Decimal Integer **/
    public int romanToInteger(String s) {
        int number = 0;
        if (s != null && s.length() > 0) {
            char[] inputArray = s.toCharArray();
            int n = inputArray.length;
            HashMap digits = populateHashMap();

            for (int i = 0; i < n - 1; i++) {
                int currentDigitValue = (int)digits.get(inputArray[i]);
                int nextDigitValue = (int)digits.get(inputArray[i + 1]);
                if (currentDigitValue >= nextDigitValue) {
                    number += currentDigitValue;
                } else {
                    number -= currentDigitValue;
                }
            }
            number += (int)digits.get(inputArray[n-1]);
        }
        return number;
    }

    private HashMap<Character,Integer> populateHashMap() {
        HashMap digits = new HashMap();
        digits.put('I', 1);
        digits.put('V', 5);
        digits.put('X', 10);
        digits.put('L', 50);
        digits.put('C', 100);
        digits.put('D', 500);
        digits.put('M', 1000);
        return digits;
    }

    /** Decimal Integer to Roman Number **/
    public static String integerToRoman(int number) {
        String bigs[] = {"", "M", "MM", "MMM"};
        String hundreds[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String tens[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String units[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return bigs[number / 1000] + hundreds[(number % 1000) / 100] + tens[(number % 100) / 10] + units[(number % 10) / 1];
    }

    /** String Number to Decimal Integer **/
    public static final int DECIMAL = 10;
    public int convertToInteger(String str) {
        int number = 0, i = 0;
        boolean isNegative = false;
        if (str.charAt(i) == '-') {
            isNegative = true;
            i++;
        }

        while (i < str.length()) {
            int digit = Character.getNumericValue(str.charAt(i));
            if (Integer.MAX_VALUE / DECIMAL < number || Integer.MAX_VALUE / DECIMAL == number && digit > 7) {
                return isNegative? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            number = number * DECIMAL + digit;
            i++;
        }
        return isNegative? -1 * number : number;
    }

    /** Decimal Integer to String Number **/
    public static String[] smalls = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public static String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public static String[] bigs = {"", "Thousand", "Million", "Billion"};
    public static String hundred = "Hundred";
    public static String negative = "Negative";

    public static String integerToString(int num) {
        if (num == 0) {
            return smalls[0];
        } else if (num < 0) {
            return negative + " " + integerToString(-1 * num);
        }

        LinkedList<String> parts = new LinkedList<String>();
        int chunkCount = 0;

        while (num > 0) {
            if (num % 1000 != 0) {
                String chunk = convertChunk(num % 1000) + " " + bigs[chunkCount];
                parts.addFirst(chunk);
            }
            num /= 1000; // shift chunk
            chunkCount++;
        }

        return listToString(parts);
    }

    public static String listToString(LinkedList<String> parts) {
        StringBuilder sb = new StringBuilder();
        while (parts.size() > 1) {
            sb.append(parts.pop());
            sb.append(" ");
        }
        sb.append(parts.pop());
        return sb.toString();
    }

    public static String convertChunk(int number) {
        LinkedList<String> parts = new LinkedList<String>();

        /* Convert hundreds place */
        if (number >= 100) {
            parts.addLast(smalls[number / 100]);
            parts.addLast(hundred);
            number %= 100;
        }

        /* Convert tens place */
        if (number >= 10 && number <= 19) {
            parts.addLast(smalls[number]);
        } else if (number >= 20) {
            parts.addLast(tens[number / 10]);
            number %= 10;
        }

        /* Convert ones place */
        if (number >= 1 && number <= 9) {
            parts.addLast(smalls[number]);
        }

        return listToString(parts);
    }

    /** XML to String **/
    /**Element Class**/
    public class Element {
        public ArrayList<Attribute> attributes;
        public ArrayList<Element> children;
        public String name;
        public String value;

        public Element(String n) {
            name = n;
            attributes = new ArrayList<Attribute>();
            children = new ArrayList<Element>();
        }

        public Element(String n, String v) {
            name = n;
            value = v;
            attributes = new ArrayList<Attribute>();
            children = new ArrayList<Element>();
        }

        public String getNameCode() {
            if (name == "family") {
                return "1";
            } else if (name == "person") {
                return "2";
            } else if (name == "firstName") {
                return "3";
            } else if (name == "lastName") {
                return "4";
            } else if (name == "state") {
                return "5";
            }
            return "--";
        }

        public void insert(Attribute attribute) {
            attributes.add(attribute);
        }

        public void insert(Element child) {
            children.add(child);
        }
    }

    /**Attribute Class**/
    public class Attribute {
        public String tag;
        public String value;
        public Attribute(String t, String v) {
            tag = t;
            value = v;
        }

        public String getTagCode() {
            if (tag == "family") {
                return "1";
            } else if (tag == "person") {
                return "2";
            } else if (tag == "firstName") {
                return "3";
            } else if (tag == "lastName") {
                return "4";
            } else if (tag == "state") {
                return "5";
            }
            return "--";
        }
    }


    public static String encodeToString(Element root) {
        StringBuilder sb = new StringBuilder();
        encode(root, sb);
        return sb.toString();
    }

    public static void encode(Element root, StringBuilder sb) {
        encode(root.getNameCode(), sb);
        for (Attribute a : root.attributes) {
            encode(a, sb);
        }
        encodeEnd(sb);
        if (root.value != null && root.value != "") {
            encode(root.value, sb);
        } else {
            for (Element e : root.children) {
                encode(e, sb);
            }
        }
        encodeEnd(sb);
    }

    public static void encode(Attribute attr, StringBuilder sb) {
        encode(attr.getTagCode(), sb);
        encode(attr.value, sb);
    }

    public static void encode(String v, StringBuilder sb) {
        v = v.replace("0", "\\0");
        sb.append(v);
        sb.append(" ");
    }

    public static void encodeEnd(StringBuilder sb) {
        sb.append("0");
        sb.append(" ");
    }

    /**RANDOM**/
    /** Random7 Using Random5 **/
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

    /** ShuffleCards **/
    public static void shuffleArrayIteratively(int[] cards) {
        for (int i = 0; i < cards.length; i++) {
            int k = rand(0, i);
            int temp = cards[k];
            cards[k] = cards[i];
            cards[i] = temp;
        }
    }

    /** GenerateRandomCards **/
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
