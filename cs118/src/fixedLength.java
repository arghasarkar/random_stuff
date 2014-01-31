public class fixedLength {
    
    public static void main (String [] args) {
        String test = "1";
        test = fixedLength(test, 10, true, '-');
        System.out.println(test);
        
    }
    
    public static String fixedLength(String s, int length, boolean fillLeft, char fillChar) {
        String returnString = "";                                               //STRING BEING RETURNED

        if (s.length() == length) {
            returnString = s;
        } else if (s.length() > length) {
            returnString = s.substring(0, length);
        } else {
            String tempString = "" + fillChar;                                  //TEMP STRING USED TO CALCULATE RETURN STRING
            while ((tempString.length() + s.length()) < length) {
                tempString = fillChar + tempString;
            }
            if (fillLeft == true) {
                returnString = tempString + s;
            } else {
                returnString = s + tempString;
            }
        }

        return returnString;
    }
    
}