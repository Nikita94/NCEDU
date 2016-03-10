package JSONParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nik on 02.03.2016.
 */
public class fromJSON {
    private String jarNames = "";

    public fromJSON(String jarNames) {
        this.jarNames = jarNames;
    }

    public List<String> getListNames () {
        List<String> listNames = new ArrayList<>();
        jarNames = jarNames.substring(1, jarNames.length() - 1);
        String array[] = jarNames.split(", ");
        listNames = Arrays.asList(array);
        return listNames;
    }
}
