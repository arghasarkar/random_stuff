public class problem2 {
    
    public static void main(String [] args) {
        System.out.println(Fibonacci(4000000));
    }
    
    public static long Fibonacci(int maxValue) {
        boolean baseLoop = true;
        long base1 = 1;
        long base2 = 2;
        long fibVal = 2;
        long sum = 2;
       
        while (fibVal < maxValue) {
            fibVal = base1 + base2;
            base1 = base2;
            base2 = fibVal;
            
            if (fibVal % 2 == 0) {
                sum = sum + fibVal;
            }
        }
        
       return sum;
    }
    
}