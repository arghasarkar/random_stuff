
import java.io.*;
import java.util.Random;

public class secretSanta {
    
    public static void main (String[] args) {
        String[] nameList = getNameList();
        printArray(nameList, true);
        printSecretSantaList(nameList,prepareGiftList(nameList));
        
        //printSecretSantaList(prepareGiftList(giftList, nameList));
    }
    
    private static String[] getNameList() {
        TextFileReader fileReader = new TextFileReader("./nameList.txt"); 
        String nameString = fileReader.readToEnd();
        String[] nameList = nameString.split("\n");
        return nameList;
    }
    
    private static String[] prepareGiftList(String[] nameList) {
        String[] giftList = new String[nameList.length];
        for (int i = 0; i < nameList.length - 1; i++) {
            giftList[i] = nameList[i+1];
        }
        giftList[giftList.length - 1] = nameList[0];
        return giftList;
    }
    
    private static int[] prepareGiftList2(String[] nameList) {
        int[] giftList = initialiseArray(nameList.length, -1);
        Random randGen = new Random();
        
        return giftList;
    }
    
    //private static 
    
    private static boolean listCorrect(int[] input, int index) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] == index) {
                return false;
            } 
        }
        return true;
    }
    
    private static boolean completedList(int[] input) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] == -1) {
                return false;
            }
        }
        return true;
    }
    
    private static int[] initialiseArray(int size, int initNum) {
        int[] initArray = new int[size];
        for (int i = 0; i < size; i++) {
            initArray[i] = initNum;
        }
        return initArray;
    }
    
    private static void printSecretSantaList(String[] nameList, String[] giftList) {
        for (int i = 0; i < nameList.length; i++) {
            System.out.println(nameList[i] + " --> " + giftList[i]);
        }
    }
    
    private static void printSecretSantaList(String[][] giftList) {
        for (int i = 0; i < giftList.length; i++) {
            System.out.println(giftList[i][0] + " --> " + giftList[i][1]);
        }
    }
    
    private static void printArray(String[] a, boolean newLine) {
        if (newLine == true) {
            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
            } 
        } else {
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i]);
            } 
        }        
    }
    
}

class TextFileReader {
    
    private String path;                                                        //PATH OF THE FILE TO BE WRITTEN TO
    BufferedReader reader;                                                      //MAIN READER 
    boolean readerInitialised = false;                                          //FLAG TO SEE IF THE CONNECTION HAS BEEN INITIALISED
    
    private String lineRead;
    private String contentRead;
    
    public TextFileReader(String pathToFile) {
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
