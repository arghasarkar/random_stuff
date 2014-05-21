package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author arghasarkar
 */
public class PersonTest {
    
    public static void main(String[] args) {
        
        String filePath = "./person.ser";
        
        Person argha = new Person();
        
        printData(argha);  
        saveClass(argha, filePath);
        
    }
    
    public static void printData(Person p) {
        System.out.println("First name: " + p.first_name);
        System.out.println("Last name: " + p.last_name);
        System.out.println("Age: " + p.age);
        System.out.println("Gender: " + p.gender);
    }
    
    public static void saveClass(Object p, String path) {
        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(p);
            out.close();
            fileOut.close();
            //System.out.println(ClassLoader.getSystemResource("").getPath());
            System.out.printf("Serialized data is saved in " + path + "\n");
         } catch(IOException e) {
            System.err.println(e.getMessage());
         }
    }
    
    public static void openClass(String path) {
        Person p = null;
        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            p = (Person) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found");
            System.err.println(e.getMessage());
        }
    }
    
}
