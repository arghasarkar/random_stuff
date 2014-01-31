public class problem14 {
    
    final static int maxValue = 999999;
    static int LCVal = 0;
    static int LCNum = 0;
    static int curVal = 0;
    static int curNum = 2;
    
    public static void main(String [] args) {
        for (int i = curNum; i <= maxValue; i++) {
            
        }
    }
    
    public static int getNextNumber(int input) {
        int result;
        if (input % 2 == 0) {
            result = input / 2;
        } else {
            result = input * 3 + 1;
        }
        return result;
    }
    
}