package exercise;

import jdk.jshell.execution.Util;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage{
    private String path;
    //private Map<String, String> storage = new HashMap<>();

    public FileKV(String path, Map<String, String> storage) {
        this.path = path;
        var content = Utils.serialize(storage);
        Utils.writeFile(path, content);
    }

    @Override
    public void set(String key, String value) {
        String content = Utils.readFile(path);
        Map<String, String> data = Utils.deserialize(content);
        data.put(key, value);
        Utils.writeFile(path, Utils.serialize(data));

    }

    @Override
    public void unset(String key) {
        String content = Utils.readFile(path);
        Map<String, String> data = Utils.deserialize(content);
        data.remove(key);
        Utils.writeFile(path, Utils.serialize(data));
    }

    @Override
    public String get(String key, String defaultValue) {
        String content = Utils.readFile(path);
        Map<String, String> kvdata = Utils.deserialize(content);
        return kvdata.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        String content = Utils.readFile(path);
        Map<String, String> data = Utils.deserialize(content);
        return data;
    }
/*
    public void writeToFile() {
        String serializedData = Utils.serialize(this.storage);
       try {
           Utils.writeFile(this.path, serializedData);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
        System.out.println("DATA: ");
        System.out.println(serializedData);
        System.out.println(this.path);
    }*/
}
// END
