public class problem17 {
    
    static String sourceString;    
    static String[] sourceArray;
    static double[] doubleArray;
    
    static TextFileReader fileReader;
    static String fileLoc = "/Users/arghasarkar/Documents/Personal Work/Java/ProjectEuler/p17res.txt";
    
    static double answer;
    
    public static void main (String [] args) {
        
        fileReader = new TextFileReader(fileLoc);
        sourceString = fileReader.readToEnd();
        //System.out.println(sourceString);
        
        sourceArray = sourceString.split("\n");
        doubleArray = new double[sourceArray.length];
                
        //System.out.println("" + doubleArray.length);
        
        for (int i = 0; i < sourceArray.length; i++) {
            doubleArray[i] = Double.parseDouble(sourceArray[i]);
            answer = answer + doubleArray[i];
            System.out.println(sourceArray[i]);
        }
        System.out.println("Answer: " + answer);
    }
    
}