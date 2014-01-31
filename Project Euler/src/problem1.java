public class problem1 {
    
    final static int maxVal = 1000;
    
    public static void main (String[] args) {
        int[] threeArray = multiples(3);
        int[] fiveArray = multiples(5);
        int[] joined = merge(threeArray, fiveArray);
        
        System.out.println(sum(joined));
        
    }
    
    public static int[] multiples(int value) {
        int arraySize = (int) maxVal / value;
        int returnArray[] = new int[arraySize + 1];
        int arrayIndex = 0;
        
        for (int i = 0; i < maxVal; i = i + value) {
            returnArray[arrayIndex] = i;
            arrayIndex++;
        }
        
        return returnArray;
    }
    
    public static int[] merge(int[] a, int[] b) {
        int[] unique = new int[a.length + b.length];
        int uniqueIndex = 0;
        int[] merged;
        
        for (int i = 0; i < a.length; i++) {
            unique[uniqueIndex] = a[i];
            uniqueIndex++;
        }
        
        for (int i = 0; i < b.length; i++) {
            if (contains(unique, b[i]) == false) {
                unique[uniqueIndex] = b[i];
                uniqueIndex++;
            }
        }
        
        merged = new int[uniqueIndex];
        for (int i = 0; i < merged.length; i++) {
            merged[i] = unique[i];
        }
        
        return merged;
    }
    
    public static boolean contains(int[] input, int value) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] == value) {
                return true;
            }
        }
        return false;
    }
    
    public static int sum(int[] input) {
        int total = 0;
        
        for (int i = 0; i < input.length; i++) {
            total = total + input[i];
        }
        
        return total;
    }
    
}