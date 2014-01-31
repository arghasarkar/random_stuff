public class problem9 {
    
    public static void main(String [] args) {
        boolean answerFound = false;
        int c = 0;
        int sum = 0;
        for (int a = 1; a <= 999; a++) {
            for (int b = 1; b <= 999; b++) {
                c = (a * a) + (b * b);
                c = (int) Math.sqrt(c);
                sum = a + b + c;
                if (sum == 1000) {
                    if (a * a + b * b == c * c) {
                        System.out.println("a: " + a + "\nb: " + b + "\nc: " + c);
                        answerFound = true;
                        break;
                    }
                }
            }
            if (answerFound == true) {
                break;
            }
        }
        
    }
    
}