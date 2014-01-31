
public class problem12 {
    
    public static void main(String [] args) {
        int[] array = generateTriangleNumbers(10);
        System.out.println("Array generated.");
        for (int i = 0; i < array.length; i++) {
            System.out.println("Current Value: " + i);
            if (checkNumberOfDivisors(array[i]) >= 5) {
                System.out.println("ANSWER: " + array[i]);
                break;
            }
        }
        //System.out.println(checkNumberOfDivisors(6));
    }
    
    public static int[] generateTriangleNumbers(int size) {
        int[] returnArray = new int[size];
        int numT = 0;
        int curTnum = 0;
        while (numT != size) {
            curTnum = curTnum + numT + 1;
            returnArray[numT] = curTnum;
            numT++;
        } 
        return returnArray;
    }
    
    public static int checkNumberOfDivisors(long input) {
        int result = 1;
        
        if (input % 2 == 0) {
            for (int i = 2; i <= input; i++) {
                if (input % i == 0) {
                    result++;
                }
            }
        } else {    
            for (int i = 2; i <= input; i++) {
                if (input % i == 0) {
                    result++;
                }
            }
        }
        return result;
    }
    
}