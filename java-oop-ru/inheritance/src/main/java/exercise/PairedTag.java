package exercise;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
/*
Имя тега в виде строки
Атрибуты тега, которые представлены словарём Map со строковыми ключами и значениями.
Тело тега, строка
Список List детей. В этом задании детьми могут быть только одиночные теги.
В классе реализуйте публичный метод toString(), который возвращает текстовое представление тега в виде строки.


 */
public class PairedTag extends Tag{
    private List<Tag> tags = new ArrayList<>();
    private String body;

    public PairedTag(String tag, Map<String, String> attributes, String body, List<Tag> tags) {
        this.tag = tag;
        this.attributes = attributes;
        this.body = body;
        this.tags = tags;

    }


    @Override
    public String toString() {
        /*String attributesString = attributes.entrySet()
                .stream()
                .map(entry -> entry.getKey() + "=\"" + entry.getValue() + "\"")
                .collect(Collectors.joining(" "));

        return "<" + tag + " " + attributesString + ">";

         */
        StringBuilder result = new StringBuilder(super.toString());
        for (var child : tags) {
            result.append(child.toString());
        }
        result.append(body).append("</").append(tag).append(">");
        return result.toString();
    }

}
// END
