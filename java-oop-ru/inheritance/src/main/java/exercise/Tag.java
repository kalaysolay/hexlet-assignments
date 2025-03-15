package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    protected String tag;
    protected Map<String, String> attributes;

    public String toString() {
        StringBuilder result = new StringBuilder("<");
        result.append(tag);
        for (var entry : attributes.entrySet()) {
            result.append(" ").append(entry.getKey()).append("=").append("\"").append(entry.getValue()).append("\"");
        }
        result.append(">");
        return result.toString();
    }
}
// END
