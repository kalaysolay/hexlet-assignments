package exercise;

import javax.swing.text.html.HTML;
import java.util.Map;

public class App {
    public static void Main (String[] args) {
        Tag img = new SingleTag("img", Map.of("class", "v-10", "id", "wop"));
        System.out.println(img.toString());
    }
}
