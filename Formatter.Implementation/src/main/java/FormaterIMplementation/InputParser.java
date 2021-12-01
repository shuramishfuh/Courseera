package FEImplementation;

import FEInterfaces.IinputParser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser implements IinputParser {

    @Override
    public List<String> convertStringToInstruction(String str) {
        List<String> list = new ArrayList<String>();
        Matcher m = Pattern.compile("([^\"]\\S*|\".+?\"|[^-])\\s*").matcher(str);
        while (m.find())
            list.add(m.group(1).replaceAll("\"|-", " "));
        return list;
    }

}
