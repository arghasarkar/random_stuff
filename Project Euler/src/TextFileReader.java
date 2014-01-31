
import java.io.*;

public class TextFileReader {
    
    private String path;                                                        //PATH OF THE FILE TO BE WRITTEN TO
    BufferedReader reader;                                                      //MAIN READER 
    boolean readerInitialised = false;                                      //FLAG TO SEE IF THE CONNECTION HAS BEEN INITIALISED
    
    private String lineRead;
    private String contentRead;
    
    TextFileReader(String pathToFile) {
        path = pathToFile;
    }
    
    private void initialiseReader() {
        if (readerInitialised == false) {
            try {
                reader = new BufferedReader(new FileReader(path));
                readerInitialised = true;
            } catch (IOException e) {
                System.out.println(e.getMessage());
                System.exit(-1);
            }
        }
    }
    
    public String readLine() {
        initialiseReader();
        try {
            lineRead = reader.readLine();
            return lineRead;
        } catch (IOException e) {
            System.out.println("ERROR!");
            return "ERROR!";
        }
    }
    
    public String readToEnd() {
        initialiseReader();
        StringBuilder concatString = new StringBuilder();
        try {
            
            lineRead = reader.readLine();
            while (lineRead != null) {
                concatString.append(lineRead);
                concatString.append("\n");
                lineRead = reader.readLine();
            }
        } catch (IOException e) {
            contentRead = "ERROR!";
            System.out.println("ERROR!");
        }
        contentRead = concatString.toString();
        return contentRead;
    }
    
    public void closeReader() {
        try {
            reader.close();
            readerInitialised = false;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }
}
