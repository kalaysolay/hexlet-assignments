package exercise;

import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
public class SingleTag extends Tag {


    public SingleTag(String tag, Map<String, String> attributes) {
        this.tag = tag;
        this.attributes = attributes;
    }

   /*
    @Override
    public String toString() {
        String attributesString = attributes.entrySet()
            .stream()
            .map(entry -> entry.getKey() + "=\"" + entry.getValue() + "\"")
            .collect(Collectors.joining(" "));

        return "<" + tag  + attributesString + ">";
    }
    */


}
// END
