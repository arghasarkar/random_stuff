public class problem7 {
    
    public static void main (String [] args) {
        System.out.println("" + xthPrime(1000001));
    }
    
    public static long xthPrime(long input) {
        long primeCount = 0;
        long answer = 2;
        while (primeCount != input) {
            if (isPrime(answer) == true) {
                primeCount++;
                if (primeCount == input) {
                    return answer;
                }
            }
            answer++;
        }
        return answer;
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