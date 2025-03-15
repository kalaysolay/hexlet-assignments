package exercise;

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
