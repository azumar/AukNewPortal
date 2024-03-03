
package helper;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

public class HashedPasswordGenerator {

    public String generateHash(String password) {

        String hash
                = Hashing.sha256()
                .hashString(password, Charsets.UTF_8).toString();

        return hash;

    }


}
