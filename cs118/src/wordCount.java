import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class wordCount {
    
    public static void main(String [] args)throws IOException {
        System.out.println("\nWord Count: " + wcReturn(cmdFileLoc()));
    }   
    
    public static int wcReturn(String location) throws IOException{
        int count = 0;
        BufferedReader read = new BufferedReader(new FileReader(location));     //DECLARES AND INITIALISES BUFFEREDREADER AND INITIALISES FILE READER WITH FILE LOCATION AS THE PARAMETRE
        String lineRead = "";                                                   //DECLARES THE LINE STRING
        String contentRead = "";                                                //DECLARES CONTENT STRING READ STRING
        boolean fileHasBeenRead = false;                                        //FLAG TO CHECK WHEN THE FILE HAS BEEN READ
        
        while (lineRead != null) {                                              //LOOP TO WORK UNTIL THE END OF THE FILE IS REACHED
            try {                                                               //TRY TO CATCH EXCEPTIONS
                lineRead = read.readLine();                                     //READS THE DOCUMENT LINE BY LINE
                if ((lineRead.equals("") == false)) {                           //ONLY ADDS THE CONTENT TO THE ARRAY IF THE CONTENT EXISTS AND IS NOT A SPACE
                    contentRead = contentRead + lineRead;                       //ADDS THE CURRENT LINE READ TO THE TOTAL CONTENT READ
                    fileHasBeenRead = true;                                     //SETS THE FILE FOUND AS TRUE TO END THE LOOP
                }
            } catch (NullPointerException npe) {}                               //EXCEPTION CATCHING IF THE LINE IS EMPTY
        }

        if (fileHasBeenRead == true) {
            String[] words = contentRead.split(" ");                            //SPLITS THE ENTIRE STRING BY USING SPACE AS THE DELIMITER
            count = words.length;
        } else {
            count = 0;
        }
        return count;
    }
    
    public static  String cmdFileLoc() throws IOException{
        String fc = "";
        boolean fileFound = false;  
        while (fileFound == false ){
            System.out.println("\nPlease enter the file location of the text document: \n");
            Scanner readFileLoc = new Scanner(System.in);                       //SCANNER USED TO READ THE FILE LOCATION FROM CMD
            String fileLoc = readFileLoc.nextLine();                            //fileLoc is the location of the file to be read. 
           
            File fileCheck = new File(fileLoc);                                 //
            if (fileCheck.exists() == true) {
                fileFound  = true; 
                fc = fileLoc;
            } else {
                System.out.println("\nPlease enter a valid file location!");
                fc = "error";
            }
        }
        return fc;
    }
}