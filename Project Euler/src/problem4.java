public class problem4 {
   
    public static void main (String [] args) {
        String outputString = "" + findHighestPalindrome(10 * 10, 999 * 999);
        System.out.println(outputString);
    }
   
    public static String flipString(String input) {
        String output = "";
        char[] inputChars = input.toCharArray();
       
        for (int i = inputChars.length- 1; i >= 0; i--) {
            output = output + inputChars[i];
        }
        return output;
    }
   
    public static int findHighestPalindrome(int lowLimit, int highLimit) {
        int highestPalindrome = 0;
       
        for (int i = lowLimit; i <= highLimit; i++) {
            String original = "" + i;
            String flipped = flipString(original);
           
            if (original.equals(flipped) == true) {
                if (i > highestPalindrome) {
                    highestPalindrome = i;
                }
            }    
        }
       
        return highestPalindrome;
    }
}