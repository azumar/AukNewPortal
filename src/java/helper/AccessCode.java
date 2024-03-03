

package helper;


public class AccessCode {
    static  int   count = 0;
    public String getAccessCodes()
    {
      
        String pin =    getRandomTriple() + "-" +
                        getRandomTriple() + "-" +
                        getRandomTriple() + "-" +
                     getRandomTriple();
        count++;
        return pin;
        
    }

    public  int getCount() {
        return count;
    }
    
     public static int getRandomDigit() {
        return (int)(100.0 * Math.random());
    } 
      
    public static char getRandomChar() {
        return (char)('A' + (26.0 * Math.random()) );
    }
    
    public static String getRandomTriple() {
        return "" + getRandomDigit() + getRandomDigit() + getRandomChar();
    } 
}

