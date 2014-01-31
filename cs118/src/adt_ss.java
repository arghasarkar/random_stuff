import java.util.Random;
import java.util.Vector;

class adt_ss {
    
    private int current_number = 0;                                             //THE LAST INTEGER RECEIVED
    private Vector used_numbers = new Vector();                                 //THE VECTOR WHICH KEEPS TRACKS OF ALL NUMBERS USED
    private int MAX = 0;                                                        //LARGEST NUMBER REQUESTED
    private int count = 0;                                                      //NUMBER OF ELEMENTS RECEIVED
    
    public adt_ss(int input_size) {
        MAX = input_size;
    }
    
    public int get_MAX() {
        return MAX;
    }
    
    public void set_MAX(int input_size) {
        MAX = input_size;
    }
    
    public int get_count() {
        return count;
    }
    
    public int next_int() {
        /*
            THIS METHOD IS USED FOR GENERATING RANDOM NUMBERS FROM 0 TO A MAX LIMIT
            THE NUMBER WHICH IS RETURNED HAS NOT BEEN RETURNED BEFORE
            IF THE RETURNED NUMBER IS -1, THEN THERE HAS EITHER BEEN SOME ERROR OR THE MAX SIZE HAS BEEN REACHED
        */
       
        if (count < MAX) {
            Random rand_gen = new Random();
            int number = rand_gen.nextInt() % MAX;
            boolean number_found = false;
            
            while (number_found == false) {
                if (used_numbers.contains(number) == false && number >= 0 && number != count) {
                    number_found = true;
                } else {
                    number = rand_gen.nextInt() % MAX;
                }
            }
            
            used_numbers.add(number);
            current_number = number;
            count++;
            return (int) number;
        } else {
            return -1;
        }
    }
   
}