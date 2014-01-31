
public class test_adt_ss {
    
    final static int SIZE = 20;
    
    public static void main(String[] args) {
        
        int[] list_a = new int[SIZE];
        adt_ss some_adt = new adt_ss(SIZE);
        
        for (int i = 0; i < SIZE; i++) {
            list_a[i] = some_adt.next_int();
        } 
       
        printArray(list_a, true);
        
        int list_check_result = checkListCorrectness(list_a);
        if (list_check_result < 0) {
            System.out.println("\nThis list is correct!\n");
        } else if (list_check_result > -1) {
            System.err.println("Error at line: " + list_check_result);
        }
    }
    
    
    private static int checkListCorrectness(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == i) {
                return i;
            }
        }
        return -1;
    }
    
    private static void printArray(int[] a, boolean newLine) {
        if (newLine == true) {
            for (int i = 0; i < a.length; i++) {
                System.out.println("Index: " + i + "   Number: " + a[i]);
            } 
        } else {
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i]);
            } 
        }        
    }
    
   
    
}



