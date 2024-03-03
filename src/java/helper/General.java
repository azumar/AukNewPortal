

package helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class General {
    
    public Date createDate (String dob) throws ParseException {
    SimpleDateFormat formatter = new  SimpleDateFormat("dd/MM/yyyy");
    Date db;
    db = formatter.parse(dob);
    return db;
}
   
}
