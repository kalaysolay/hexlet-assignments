package exercise;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    /* public static Map<String,String> swapKeyValue(KeyValueStorage storage) {
        Map<String, String> oldStorage = storage.toMap();
        Map<String, String> newStorage = new HashMap<>();
        for (String key: oldStorage.keySet()){
            newStorage.put(oldStorage.get(key), key);
        }
        return newStorage;
    }*/
    public static void main (String[] args) {
       // String path = "~/Hexlet/hexlet-assignments/java-oop-ru/subtyping/src/test/resources/file";
       // String expandedPath = path.replaceFirst("^~", System.getProperty("user.home"));
        FileKV storage = new FileKV("\\\\wsl.localhost\\Ubuntu\\home\\kalaysolay\\Hexlet\\hexlet-assignments\\java-oop-ru\\subtyping\\src\\test\\resources\\file", new HashMap<>(Map.of("key", "value")));
        storage.set("key2", "value2");
        String content = Utils.serialize(storage.toMap());
        System.out.println(content);
        Utils.writeFile("\\\\wsl.localhost\\Ubuntu\\home\\kalaysolay\\Hexlet\\hexlet-assignments\\java-oop-ru\\subtyping\\src\\test\\resources\\file",content);
        //storage.writeToFile();
    }



    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> oldStorage = storage.toMap();
        // storage.clear();
        for (String key: oldStorage.keySet()){
            storage.unset(key);
        }
        System.out.println(storage.toMap().toString());
        System.out.println(storage.toMap().isEmpty());

        // Меняем ключи и значения местами
        for (Map.Entry<String, String> entry : oldStorage.entrySet()) {
            String newKey = entry.getValue(); // Новый ключ
            String newValue = entry.getKey(); // Новое значение

            // Проверяем, чтобы новый ключ не совпадал со старым значением
            if (!newKey.equals(entry.getKey())) {
                storage.set(newKey, newValue);
            }
        }

    }
}
// END
