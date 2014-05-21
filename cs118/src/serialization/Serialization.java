package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization {
	/*
	 * FILE PATH IS THE PATH OF WHERE THE SERIALIZED OBJECT WILL BE STORED
	 */
	String filePath = "";	
	
	/*
	 * THIS METHOD: SAVECLASS TAKES IN TWO PARAMETERS: OBJECT (QUERY) AND THE PATH WHERE THE SERIALIZED OBJECT WILL BE STORED
	 */
	
	public static void saveClass(Object p, String path) {
		
        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(p);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in " + path + "\n");
         } catch(IOException e) {
            System.err.println(e.getMessage());
         }
    }
    
	
	/*
	 * RETURNS THE OBJECT CLASS READ FROM THE FILE PATH
	 */
	
    public static Object openClass(String path) {
        Object o = null;
        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            o = (Object) in.readObject();
            in.close();
            fileIn.close();
            return o;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found");
            System.err.println(e.getMessage());
        }
        return null;
    }
}
