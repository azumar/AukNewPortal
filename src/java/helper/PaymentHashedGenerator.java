
package helper;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import java.util.UUID;

public class PaymentHashedGenerator {

    public String generateHash( ) {
       
        
       int pid = 6207;
       int amount = 3000;
       int currency = 566;
     //  String txn_ref = generateTid();
        String txn_ref = "123456789";
       String mkey = "CEF793CBBE838AA0CBB29B74D571113B4EA6586D3BA77E7CFA0B95E278364EFC4526ED7BD255A366CDDE11F1F607F0F844B09D93B16F7CFE87563B2272007AB3";
       String sUrl = "http:/localhost:8080/AukNewPortal/paid";
       //String refNo = jambNo;
       int payItem =101;
      // String toHashed = pid+amount+currency+jambNo+payItem+sUrl; 
           String toHashed = txn_ref +pid+payItem+amount+sUrl+mkey; 
           System.out.println("Gashi Nan "+toHashed);
        String hash
                = Hashing.sha512()
                .hashString(toHashed, Charsets.UTF_8).toString();
 System.out.println("UUID   "+txn_ref);
        return hash;

    }
    public String generateTid(){
       return  UUID.randomUUID().toString();
    }


}
