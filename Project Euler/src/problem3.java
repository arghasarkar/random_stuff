import java.util.Stack;

public class problem3 {
 
    public static Stack primeStack = new Stack();
    static double findSqrt = 600851475143.0;
    
    public static void main (String [] args) {
        /*long checkPrime = 499;
        if (isPrime(checkPrime) == true) {
            System.out.println(checkPrime + " is a prime number.");
        } else {
            System.out.println(checkPrime + " is not a prime number.");
        }*/
        /* count = 0;
         
        for (int i = 11; i < 2147000000; i++) {
            if (isPrime(i) == true) {
                count++;
                System.out.println("" + i);
            }
        }*/
        
        long maxPrime = 0;
        double index = 11;
       
        /*for (int i = 11; i <= (findSqrt/2); i = i + 2) {
            if (isPrime(i) == true && findSqrt % i == 0) {
                maxPrime = i;
                System.out.println("Max Prime: " + maxPrime);
            }
            //System.out.println("" + i);
        }*/
       
        while (index <= (findSqrt/2)) {
            if (isPrime(index) == true && findSqrt % index == 0) {
                maxPrime = (long) index;
                System.out.println("Max Prime: " + maxPrime);
                primeStack.push(maxPrime);
                if ((findSqrt / maxPrime) > maxPrime && (isPrime(findSqrt / maxPrime) == true)) {
                    index = findSqrt / maxPrime;
                    maxPrime = (long) index;
                }
                //System.out.println("Max Prime: " + maxPrime);
            }
            //System.out.println("" + index);
            index = index + 2;
        }
       
        System.out.println("Highest prime factor: " + maxPrime);
    }
   
    public static boolean isPrime(double input) {
       
        if ((input % 2 == 0) || (input % 3 == 0) || (input % 5 == 0) || (input % 7 == 0)) {
            return false;
        }
       
        for (int i = 11; i <= (double) Math.sqrt(input); i = i + 2) {
            if (input % i == 0) {
                return false;
            }
        }
       
        return true;
    }
    
    public static boolean checkPrimeFactors(Stack input) {
        double curMultiple = 0;
        while (input.isEmpty() == false) {
            curMultiple = Integer.parseInt("" + input.pop());
        }
        if (curMultiple == findSqrt) {
            
        }
        return false;
    }
   
}