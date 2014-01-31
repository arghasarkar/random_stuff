public class problem10 {
    
    public static void main (String [] args) {
        System.out.println("Answer: " + sumOfPrimes(2000000));
    }
    
    public static long sumOfPrimes(int maxValue) {
        long result = 2;
        for (int i = 3; i <= maxValue; i = i + 2) {
            if (isPrime(i) == true) {
                result = result + i;
            }
        }
        return result;
    }
    
    public static boolean isPrime(long input) {

        for (int i = 2; i <= (long) Math.sqrt((double) input); i++) {
            if (input % i == 0) {
                return false;
            }
        }

        return true;
    }
    
}