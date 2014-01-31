public class problem6 {
    
    public static void main (String [] args) {
        System.out.println("The answer is: " + (squareOfSums(100) - sumOfSquares(100)));
    }
    
    public static long sumOfSquares(int maxValue) {
        long returnValue = 0;
        for (int i = 1; i <= maxValue; i++) {
            returnValue = returnValue + (i*i);
        }
        return returnValue;
    }
    
    public static long squareOfSums(int maxValue) {
        long returnValue = 0;
        for (int i = 1; i <= maxValue; i++) {
            returnValue = returnValue + i;
        }
        returnValue = returnValue * returnValue;
        return returnValue;
    }
    
}