public class testjoin {
    
    public static void main (String [] args) {
        int[] A = {1, 3};
        int P = 4;
        int[] B = {4, 5, 6};
        int[] test = new int[A.length + 1];

        test = join(A, P, B);
        
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
        
    }
    
    public static int[] append (int[] a, int b) {
       int[] returnArray;
       
       if (a.length != 0) {
           returnArray = new int[a.length + 1];
           for (int i = 0; i < a.length; i++) {
               returnArray[i] = a[i];
           }
           returnArray[a.length]=b;
       } else {
           returnArray = new int[1];
           returnArray[0] = b;
       }
       
       return returnArray;
    }
    
    public static int[] join(int[] a, int p, int[] b) {
        int[] returnArray = new int[a.length + b.length + 1];
        int[] tempArray = new int[0];
   
        returnArray = append(a, p);
        tempArray = returnArray;
        
        for (int i = 0; i < b.length; i++) {
            returnArray = append(tempArray, b[i]);
            tempArray = returnArray;
        }        
        return returnArray;
    }
}